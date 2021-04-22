package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHeroModel {

    @Test
    public void TestGetPosition()
    {
        HeroModel heroModel = new HeroModel(new Position(50,25));
        assertEquals(50,heroModel.getPosition().getX());
        assertEquals(25,heroModel.getPosition().getY());
    }

    @Test
    public void TestSetPosition()
    {
        HeroModel heroModel = new HeroModel(new Position(50,25));
        heroModel.setPosition(new Position(50,25));
        assertEquals(50,heroModel.getPosition().getX());
        assertEquals(25,heroModel.getPosition().getY());
    }
}
