package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestFollowEnemyModel {
    @Test
    public void testGetHeroPosition() {
        HeroModel heroModel = new HeroModel(new Position(50, 45));
        FollowEnemyModel followEnemyModel = new FollowEnemyModel(new Position(50, 45), heroModel);

        assertEquals(new Position(50, 45).getX(), followEnemyModel.getHeroPosition().getX());
        assertEquals(new Position(50, 45).getY(), followEnemyModel.getHeroPosition().getY());
        assertNotEquals(null, followEnemyModel.getHeroPosition());
    }
}
