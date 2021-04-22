package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.Position;
import com.g35.data.RandomEnemyModel;
import com.g35.gui.ArenaView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class TestRandomEnemyController {
    @Test
    public void testMoveEnemy() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        arenaModel.createEnemies(1);
        List<EnemyModel> enemyModels = arenaModel.getEnemies();
        Position initialPos = new Position(35, 25);
        EnemyModel enemyModel = new RandomEnemyModel(initialPos);
        enemyModels.add(enemyModel);
        RandomEnemyController randomEnemyController = new RandomEnemyController(enemyModels);
        randomEnemyController.moveEnemy(arenaView, arenaModel, enemyModel);

        assertNotEquals(initialPos, enemyModel.getPosition());
    }
}
