package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEnemyModel {

    @Test
    public void TestGetPosition() {
        EnemyModel enemyModel = new EnemyModel(new Position(21, 30));
        assertEquals(21, enemyModel.getPosition().getX());
        assertEquals(30, enemyModel.getPosition().getY());
    }

    @Test
    public void TestSetPosition() {
        EnemyModel enemyModel = new EnemyModel(new Position(21, 30));
        enemyModel.setPosition(new Position(21, 30));
        assertEquals(21, enemyModel.getPosition().getX());
        assertEquals(30, enemyModel.getPosition().getY());
    }
}
