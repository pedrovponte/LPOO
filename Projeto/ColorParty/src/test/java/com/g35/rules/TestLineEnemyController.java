package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.LineEnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TestLineEnemyController {
    @Test
    public void testMoveEnemy() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        arenaModel.createEnemies(1);
        List<EnemyModel> enemyModels = arenaModel.getEnemies();
        Position initialPos = new Position(35, 25);
        EnemyModel enemyModel = new LineEnemyModel(initialPos);
        enemyModels.add(enemyModel);
        LineEnemyController lineEnemyController = new LineEnemyController(enemyModels);
        ((LineEnemyModel) enemyModel).setDirection(-1);
        lineEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);

        assertTrue(((LineEnemyModel) enemyModel).getDirection() < 4);
        assertFalse(((LineEnemyModel) enemyModel).getDirection() < 0);
        assertEquals(5, ((LineEnemyModel) enemyModel).getMovement());
        assertNotEquals(initialPos, enemyModel.getPosition());
        initialPos = enemyModel.getPosition();

        lineEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);
        assertEquals(4 ,((LineEnemyModel) enemyModel).getMovement());
        assertNotEquals(initialPos, enemyModel.getPosition());
    }
}
