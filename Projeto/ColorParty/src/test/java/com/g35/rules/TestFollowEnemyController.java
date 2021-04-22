package com.g35.rules;

import com.g35.data.*;
import com.g35.gui.ArenaView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TestFollowEnemyController {
    @Test
    public void testMoveEnemy() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        arenaModel.createEnemies(1);
        List<EnemyModel> enemyModels = arenaModel.getEnemies();
        HeroModel heroModel = arenaModel.getHero();
        heroModel.setPosition(new Position(30, 25));
        EnemyModel enemyModel = new FollowEnemyModel(new Position(45, 20), heroModel);
        enemyModels.add(enemyModel);
        FollowEnemyController followEnemyController = new FollowEnemyController(enemyModels);

        assertTrue(enemyModels.size() > 0);

        for(EnemyModel enemy : enemyModels) {
            assertNotEquals(null, enemy);
        }

        followEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(new Position(44, 20).getX(), enemyModel.getPosition().getX());
        assertEquals(new Position(44, 20).getY(), enemyModel.getPosition().getY());

        heroModel.setPosition(new Position(60, 25));
        followEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(new Position(45, 20).getX(), enemyModel.getPosition().getX());
        assertEquals(new Position(45, 20).getY(), enemyModel.getPosition().getY());

        heroModel.setPosition(new Position(41, 25));
        followEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(new Position(45, 21).getX(), enemyModel.getPosition().getX());
        assertEquals(new Position(45, 21).getY(), enemyModel.getPosition().getY());

        heroModel.setPosition(new Position(41, 16));
        followEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(new Position(45, 20).getX(), enemyModel.getPosition().getX());
        assertEquals(new Position(45, 20).getY(), enemyModel.getPosition().getY());

        enemyModel.setPosition(new Position(30, 24));
        heroModel.setPosition(new Position(30, 25));
        followEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(new Position(30, 25).getX(), enemyModel.getPosition().getX());
        assertEquals(new Position(30, 25).getY(), enemyModel.getPosition().getY());
    }
}
