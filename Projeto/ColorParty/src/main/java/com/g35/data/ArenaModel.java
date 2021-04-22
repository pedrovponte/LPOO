package com.g35.data;

import com.g35.observer.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaModel extends Observable<ArenaModel> {
    private int width;
    private int height;

    private int maxLineEnemies;
    private int maxFollowEnemies;
    private int maxRandomEnemies;

    private HeroModel hero;
    private List<EnemyModel> enemies;

    public ArenaModel(int width, int height, int mode) {
        this.width = width;
        this.height = height;
        this.hero = new HeroModel(new Position(width / 2, height / 2));
        this.enemies = new ArrayList<>();
        createEnemies(mode);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public HeroModel getHero() {
        return hero;
    }

    public List<EnemyModel> getEnemies() {
        return enemies;
    }

    public List<EnemyModel> getLineEnemies() {
        List<EnemyModel> lineEnemies = new ArrayList<>();
        for (int i = 0 ; i < maxLineEnemies ; i++)
            lineEnemies.add(enemies.get(i));
        return lineEnemies;
    }

    public List<EnemyModel> getFollowEnemies() {
        List<EnemyModel> followEnemies = new ArrayList<>();
        for (int i = maxLineEnemies ; i < maxLineEnemies + maxFollowEnemies ; i++)
            followEnemies.add(enemies.get(i));
        return followEnemies;
    }

    public List<EnemyModel> getRandomEnemies() {
        List<EnemyModel> randomEnemies = new ArrayList<>();
        for (int i = maxLineEnemies + maxFollowEnemies; i < maxLineEnemies + maxFollowEnemies + maxRandomEnemies; i++)
            randomEnemies.add(enemies.get(i));
        return randomEnemies;
    }

    public Position getHeroPosition() {
        return hero.getPosition();
    }

    public void createEnemies(int mode) {
        createLineEnemies(mode);

        createFollowEnemies(mode);

        createRandomEnemies();
    }

    private void createRandomEnemies() {
        maxRandomEnemies = 4;

        for(int i = 0; i < 2; i++) {
            Random r = new Random();
            int enemy_x = r.nextInt(35) + 2;
            int enemy_y = r.nextInt(height - 10) + 6;
            EnemyModel enemyModel = new RandomEnemyModel(new Position(enemy_x, enemy_y));
            enemies.add(enemyModel);
        }

        for(int i = 0; i < 2; i++) {
            Random r = new Random();
            int enemy_x = r.nextInt(30) + 60;
            int enemy_y = r.nextInt(height - 10) + 6;
            EnemyModel enemyModel = new RandomEnemyModel(new Position(enemy_x, enemy_y));
            enemies.add(enemyModel);
        }
    }

    private void createFollowEnemies(int mode) {
        if (mode == 1) {
            maxFollowEnemies = 4;
        }
        else if (mode == 2) {
            maxFollowEnemies = 6;
        }
        else if (mode == 3){
            maxFollowEnemies = 8;
        }

        EnemyModel enemyModel1 = new FollowEnemyModel(new Position(5, 15), hero);
        EnemyModel enemyModel2 = new FollowEnemyModel(new Position(90, 15), hero);
        EnemyModel enemyModel3 = new FollowEnemyModel(new Position(5, 45), hero);
        EnemyModel enemyModel4 = new FollowEnemyModel(new Position(90, 45), hero);
        enemies.add(enemyModel1);
        enemies.add(enemyModel2);
        enemies.add(enemyModel3);
        enemies.add(enemyModel4);

        if (mode == 2) {
            EnemyModel enemyModel5 = new FollowEnemyModel(new Position(45, 15), hero);
            EnemyModel enemyModel6 = new FollowEnemyModel(new Position(45, 45), hero);
            enemies.add(enemyModel5);
            enemies.add(enemyModel6);
        }
        else if(mode == 3) {
            EnemyModel enemyModel5 = new FollowEnemyModel(new Position(45, 15), hero);
            EnemyModel enemyModel6 = new FollowEnemyModel(new Position(45, 45), hero);
            EnemyModel enemyModel7 = new FollowEnemyModel(new Position(5, 30), hero);
            EnemyModel enemyModel8 = new FollowEnemyModel(new Position(90, 30), hero);
            enemies.add(enemyModel5);
            enemies.add(enemyModel6);
            enemies.add(enemyModel7);
            enemies.add(enemyModel8);
        }
    }

    private void createLineEnemies(int mode) {
        if (mode == 1) {
            maxLineEnemies = 4;
        }
        else if (mode == 2) {
            maxLineEnemies = 8;
        }
        else if (mode == 3){
            maxLineEnemies = 12;
        }

        for (int i = 0; i < maxLineEnemies / 2; i++) {
            Random r = new Random();
            int enemy_x = r.nextInt(35) + 2;
            int enemy_y = r.nextInt(height - 10) + 6;
            EnemyModel enemyModel = new LineEnemyModel(new Position(enemy_x, enemy_y));
            enemies.add(enemyModel);
        }

        for (int i = 0; i < maxLineEnemies / 2; i++) {
            Random r = new Random();
            int enemy_x = r.nextInt(30) + 60;
            int enemy_y = r.nextInt(height - 10) + 6;
            EnemyModel enemyModel = new LineEnemyModel(new Position(enemy_x, enemy_y));
            enemies.add(enemyModel);
        }
    }
}
