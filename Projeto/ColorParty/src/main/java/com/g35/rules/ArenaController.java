package com.g35.rules;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.*;
import com.g35.gui.ArenaView;

import java.io.IOException;
import java.util.List;

public class ArenaController {
    private ArenaView gui;
    private ArenaModel arena;

    private HeroController heroController;
    private EnemyController randomEnemyController, lineEnemyController, followEnemyController;

    public enum COMMAND {UP, RIGHT, DOWN, LEFT, BREAK, Q, NULL}

    public ArenaController(ArenaView gui, ArenaModel arena) {
        this.gui = gui;
        this.arena = arena;
    }

    public void initObservers() {
        HeroModel hero = arena.getHero();
        hero.addObserver(gui.getHeroObserver());
        List<EnemyModel> enemies = arena.getEnemies();
        for (EnemyModel enemy : enemies)
            enemy.addObserver(gui.getEnemyObserver());
        arena.addObserver(gui);
        arena.notifyObservers(arena);
    }

    public void initControllers() {
        heroController = new HeroController(arena.getHero());
        randomEnemyController = new RandomEnemyController(arena.getRandomEnemies());
        lineEnemyController = new LineEnemyController(arena.getLineEnemies());
        followEnemyController = new FollowEnemyController(arena.getFollowEnemies());
    }

    public void firstArenaDraw() {
        BlockModel HeroBlock = gui.findArenaBlock(arena.getHeroPosition());
        HeroBlock.notifyObservers(HeroBlock);
        arena.getHero().notifyObservers(arena.getHero());
        for (EnemyModel enemy : arena.getEnemies()) {
            BlockModel EnemyBlock = gui.findArenaBlock(enemy.getPosition());
            EnemyBlock.notifyObservers(EnemyBlock);
            enemy.notifyObservers(enemy);
        }
        arena.notifyObservers(arena);
    }

    public boolean checkColor(Color correctColor) {
        BlockModel heroBlock = gui.findArenaBlock(arena.getHeroPosition());
        return heroBlock.getColor().sameColor(correctColor);
    }

    public void updateHero(COMMAND command) {
        BlockModel previousHeroBlock = gui.findArenaBlock(arena.getHeroPosition());
        previousHeroBlock.notifyObservers(previousHeroBlock);

        heroController.moveHero(gui, command);

        BlockModel newHeroBlock = gui.findArenaBlock(arena.getHeroPosition());
        newHeroBlock.notifyObservers(newHeroBlock);
        arena.getHero().notifyObservers(arena.getHero());
    }

    public void updateEnemy(EnemyModel enemy) {
        BlockModel previousEnemyBlock = gui.findArenaBlock(enemy.getPosition());
        previousEnemyBlock.notifyObservers(previousEnemyBlock);

        if (enemy instanceof RandomEnemyModel)
            randomEnemyController.moveEnemy(gui, arena, enemy);
        else if (enemy instanceof LineEnemyModel)
            lineEnemyController.moveEnemy(gui, arena, enemy);
        else
            followEnemyController.moveEnemy(gui, arena, enemy);

        BlockModel newEnemyBlock = gui.findArenaBlock(enemy.getPosition());
        newEnemyBlock.notifyObservers(newEnemyBlock);
        enemy.notifyObservers(enemy);
    }

    public COMMAND getCommand(Screen screen) throws IOException {
        while (true) {
            KeyStroke key = screen.pollInput();

            if (key == null) return COMMAND.NULL;
            if (key.getKeyType() == KeyType.ArrowUp) return COMMAND.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return COMMAND.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;
            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'q' || key.getCharacter() == 'Q')) return COMMAND.Q;
            if (key.getKeyType() == KeyType.EOF) return COMMAND.BREAK;
        }
    }

    public int start(int mode) throws IOException {
        initObservers();
        initControllers();

        firstArenaDraw();

        int score = 0;

        long game_time = System.currentTimeMillis();

        int timeCounter;

        if (mode == 3) {
            timeCounter = 6;
        }
        else {
            timeCounter = 10;
        }

        long enemy_time = System.currentTimeMillis();
        long follow_enemy_time = System.currentTimeMillis();

        gui.getTimeView().setTime(new TimeModel(timeCounter));
        gui.getTimeView().drawTime();
        arena.notifyObservers(arena);

        Color correctColor = gui.getTopBarView().changeToRandomColor(score);

        while (true) {
            COMMAND command = getCommand(gui.getScreen());

            if (command == COMMAND.Q)
                return score;

            else if (command == COMMAND.BREAK)
                return -1;

            else if (command != COMMAND.NULL) {
                updateHero(command);
            }

            if (System.currentTimeMillis() - enemy_time > 150) {
                for (EnemyModel enemy : arena.getEnemies()) {
                    if (enemy instanceof FollowEnemyModel)
                        continue;
                    updateEnemy(enemy);
                }
                for (EnemyModel enemy : arena.getEnemies()) {
                    if (heroController.checkEnemyCollision(enemy))
                        return score;
                }
                enemy_time = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - follow_enemy_time > 350) {
                for (EnemyModel enemy : arena.getEnemies()) {
                    if (!(enemy instanceof FollowEnemyModel))
                        continue;
                    updateEnemy(enemy);
                }
                for (EnemyModel enemy : arena.getEnemies()) {
                    if (heroController.checkEnemyCollision(enemy))
                        return score;
                }
                follow_enemy_time = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - game_time > 1000) {
                timeCounter--;
                if (timeCounter == 0) {
                    if (!checkColor(correctColor)) {
                        return score;
                    }
                    else {
                        score++;
                    }
                    ((BlockGroup) gui.getArenaBlock()).differentColors();
                    correctColor = gui.getTopBarView().changeToRandomColor(score);
                    updateHero(COMMAND.NULL);
                    for (EnemyModel enemy : arena.getEnemies()) {
                        updateEnemy(enemy);
                    }
                    if (mode == 3) {
                        timeCounter = 6;
                    }
                    else {
                        timeCounter = 10;
                    }
                }
                gui.getTimeView().setTime(new TimeModel(timeCounter));
                gui.getTimeView().drawTime();
                arena.notifyObservers(arena);
                game_time = System.currentTimeMillis();
            }

            arena.notifyObservers(arena);
        }
    }
}