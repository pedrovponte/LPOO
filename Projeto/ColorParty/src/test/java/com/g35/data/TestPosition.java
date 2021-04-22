package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPosition {
    @Test
    public void testGetX(){
        Position P = new Position(10,20);
        assertEquals(10,P.getX());
    }

    @Test
    public void testGetY(){
        Position P = new Position(10,20);
        assertEquals(20,P.getY());
    }

    @Test
    public void testSetX(){
        Position P = new Position(10,20);
        P.setX(30);
        assertEquals(30,P.getX());
    }

    @Test
    public void testSetY(){
        Position P = new Position(10,20);
        P.setY(30);
        assertEquals(30,P.getY());
    }

    @Test
    public void testUp(){
        Position P = new Position(10,20);
        P = P.up();
        assertEquals(19,P.getY());
    }

    @Test
    public void testDown(){
        Position P = new Position(10,20);
        P = P.down();
        assertEquals(21,P.getY());
    }

    @Test
    public void testRight(){
        Position P = new Position(10,20);
        P = P.right();
        assertEquals(11,P.getX());
    }

    @Test
    public void testLeft(){
        Position P = new Position(10,20);
        P = P.left();
        assertEquals(9,P.getX());
    }

    @Test
    public void testSamePosition(){
        Position P = new Position(10,20);
        Position S = new Position(10,20);
        assertEquals(true,P.samePosition(S));

        Position F = new Position(10,21);
        assertEquals(false,P.samePosition(F));

        Position G = new Position(11,20);
        assertEquals(false,P.samePosition(G));
    }
}
