package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestLineEnemyModel {
    @Test
    public void testGetMovement() {
        LineEnemyModel lineEnemyModel = new LineEnemyModel(new Position(45, 50));
        lineEnemyModel.setMovement(4);

        assertEquals(4, lineEnemyModel.getMovement());
        assertNotEquals(null, lineEnemyModel.getMovement());
    }

    @Test
    public void testGetDirection() {
        LineEnemyModel lineEnemyModel = new LineEnemyModel(new Position(45, 50));
        lineEnemyModel.setDirection(2);

        assertEquals(2, lineEnemyModel.getDirection());
        assertNotEquals(null, lineEnemyModel.getDirection());
    }
}
