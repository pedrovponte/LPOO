package com.g35.rules;

import com.g35.data.*;
import com.g35.gui.ArenaView;
import com.g35.gui.TimeView;
import com.g35.gui.TopBarView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestArenaController {
    private ArenaModel arena;
    private ArenaView gui;
    private ArenaController controller;
    private HeroModel hero;
    private EnemyModel enemy;
    private Screen screen;
    private TextGraphics graphics;
    private BlockModel block;
    private Position position;
    private TimeView timeView;
    private TopBarView topBarView;

    @Before
    public void Preparations() {
        arena = Mockito.mock(ArenaModel.class);
        gui = Mockito.mock(ArenaView.class);
        controller = new ArenaController(gui, arena);
        hero = Mockito.mock(HeroModel.class);
        enemy = Mockito.mock(RandomEnemyModel.class);
        screen = mock(Screen.class);
        graphics = mock(TextGraphics.class);
        block = mock(BlockModel.class);
        position = mock(Position.class);
        timeView = mock(TimeView.class);
        topBarView = mock(TopBarView.class);
        List<EnemyModel> enemies = new ArrayList<>();
        enemies.add(enemy);

        List<BlockModel> borders = new ArrayList<>();
        borders.add(block);
        gui.limits = borders;

        when(arena.getEnemies()).thenReturn(enemies);
        when(arena.getHeight()).thenReturn(100);
        when(arena.getWidth()).thenReturn(50);
        when(arena.getHero()).thenReturn(hero);
        when(block.getPosition()).thenReturn(position);
        when(hero.getPosition()).thenReturn(position);
        when(gui.findArenaBlock(arena.getHeroPosition())).thenReturn(block);
        when(enemy.getPosition()).thenReturn(position);
        when(gui.findArenaBlock(enemy.getPosition())).thenReturn(block);
        when(gui.getTimeView()).thenReturn(timeView);
        when(gui.getTopBarView()).thenReturn(topBarView);
        when(gui.getScreen()).thenReturn(screen);
        when(position.getX()).thenReturn(40);
        when(position.getY()).thenReturn(25);
    }

    @Test
    public void testInitObservers() {
        controller.initObservers();

        Mockito.verify(hero, Mockito.times(1)).addObserver(gui.getHeroObserver());
        Mockito.verify(arena, Mockito.times(1)).addObserver(gui);
        Mockito.verify(arena, Mockito.times(1)).notifyObservers(arena);
        Mockito.verify(enemy, Mockito.times(1)).addObserver(gui.getEnemyObserver());
    }

    @Test
    public void testFirstArenaDraw() {
        controller.firstArenaDraw();

        Mockito.verify(block, Mockito.times(2)).notifyObservers(block);
        Mockito.verify(hero, Mockito.times(1)).notifyObservers(hero);
        Mockito.verify(enemy, Mockito.times(1)).notifyObservers(enemy);
        Mockito.verify(arena, Mockito.times(1)).notifyObservers(arena);
    }

    @Test
    public void testCheckColor() {
        Color correctColor = new Color("#FFFFFF");

        when(block.getColor()).thenReturn(new Color("#AAAAAA"));
        assertFalse(controller.checkColor(correctColor));

        when(block.getColor()).thenReturn(new Color("#FFFFFF"));
        assertTrue(controller.checkColor(correctColor));
    }

    @Test
    public void testUpdateHero() {
        ArenaController.COMMAND command = ArenaController.COMMAND.UP;

        controller.initControllers();
        controller.updateHero(command);

        Mockito.verify(block, Mockito.times(2)).notifyObservers(block);
        Mockito.verify(hero, Mockito.times(1)).notifyObservers(hero);
    }

    @Test
    public void testUpdateEnemy() {
        controller.initControllers();

        // Testing for RandomEnemy
        controller.updateEnemy(enemy);
        Mockito.verify(enemy, Mockito.times(1)).notifyObservers(enemy);

        // Testing for LineEnemy
        EnemyModel lineEnemy = mock(LineEnemyModel.class);
        when(lineEnemy.getPosition()).thenReturn(position);
        controller.updateEnemy(lineEnemy);
        Mockito.verify(lineEnemy, Mockito.times(1)).notifyObservers(lineEnemy);

        // Testing for FollowEnemy
        FollowEnemyModel followEnemy = mock(FollowEnemyModel.class);
        when(followEnemy.getPosition()).thenReturn(position);
        when(followEnemy.getHeroPosition()).thenReturn(position);
        controller.updateEnemy(followEnemy);
        Mockito.verify(followEnemy, Mockito.times(1)).notifyObservers(followEnemy);

        Mockito.verify(block, Mockito.times(6)).notifyObservers(block);
    }

    @Test
    public void testGetCommand() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(ArenaController.COMMAND.UP, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(ArenaController.COMMAND.RIGHT, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(ArenaController.COMMAND.DOWN, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(ArenaController.COMMAND.LEFT, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false));
        assertEquals(ArenaController.COMMAND.Q, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(ArenaController.COMMAND.BREAK, controller.getCommand(screen));
        when(screen.pollInput()).thenReturn(null);
        assertEquals(ArenaController.COMMAND.NULL, controller.getCommand(screen));
    }

    @Test
    public void testStart() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false));
        assertEquals(0, controller.start(1));

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(-1, controller.start(3));

        Mockito.verify(hero, Mockito.times(2)).notifyObservers(hero);
    }
}
