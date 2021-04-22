package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestElementModel {
    @Test
    public void TestGetPosition() {
        ElementModel elementModel = new EnemyModel(new Position(21, 30));
        assertEquals(21, elementModel.getPosition().getX());
        assertEquals(30, elementModel.getPosition().getY());
    }

    @Test
    public void TestSetPosition() {
        ElementModel elementModel = new EnemyModel(new Position(21, 30));
        elementModel.setPosition(new Position(21, 30));
        assertEquals(21, elementModel.getPosition().getX());
        assertEquals(30, elementModel.getPosition().getY());
    }
}
