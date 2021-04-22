package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TestEnemyController {
    @Test
    public void TestCheckLimitsCollision() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        arenaModel.createEnemies(1);
        List<EnemyModel> enemyModelList = arenaModel.getEnemies();
        EnemyModel enemyModel = enemyModelList.get(0);
        enemyModel.setPosition(new Position(18, 35));

        LineEnemyController lineEnemyController = new LineEnemyController(enemyModelList);
        FollowEnemyController followEnemyController = new FollowEnemyController(enemyModelList);
        RandomEnemyController randomEnemyController = new RandomEnemyController(enemyModelList);

        assertFalse(lineEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));
        assertFalse(followEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));
        assertFalse(randomEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));

        enemyModel.setPosition(new Position(100, 26));
        assertTrue(lineEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));
        assertTrue(followEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));
        assertTrue(randomEnemyController.checkLimitsCollision(enemyModel.getPosition(), arenaView.limits));
    }

    @Test
    public void testCheckEnemiesCollision() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        arenaModel.createEnemies(1);
        List<EnemyModel> enemyModelList = arenaModel.getEnemies();
        EnemyModel enemyModel = enemyModelList.get(0);
        enemyModel.setPosition(new Position(18, 35));

        LineEnemyController lineEnemyController = new LineEnemyController(enemyModelList);
        FollowEnemyController followEnemyController = new FollowEnemyController(enemyModelList);
        RandomEnemyController randomEnemyController = new RandomEnemyController(enemyModelList);

        assertFalse(lineEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));
        assertFalse(followEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));
        assertFalse(randomEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));

        enemyModel = enemyModelList.get(1);
        enemyModel.setPosition(new Position(18, 35));

        assertTrue(lineEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));
        assertTrue(followEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));
        assertTrue(randomEnemyController.checkEnemiesCollision(new Position(18, 35), arenaModel));
    }
}
