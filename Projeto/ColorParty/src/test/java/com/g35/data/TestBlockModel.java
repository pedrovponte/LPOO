package com.g35.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBlockModel {
    private Position position;
    private Color color;
    private Color newColor;
    private BlockModel block;

    @Before
    public void Preparations() {
        position = mock(Position.class);
        when(position.getX()).thenReturn(45);
        when(position.getY()).thenReturn(25);
        color = mock(Color.class);
        when(color.getCode()).thenReturn("#0080FF");
        newColor = mock(Color.class);
        when(newColor.getCode()).thenReturn("#FFFFFF");
        block = new BlockModel(position, color);
    }

    @Test
    public void testGetPosition() {
        assertEquals(position, block.getPosition());
    }

    @Test
    public void testGetColor() {
        assertEquals(color, block.getColor());
    }

    @Test
    public void testChangeColor() {
        assertEquals("#0080FF", block.getColor().getCode());
        block.changeColor(newColor);
        assertEquals("#FFFFFF", block.getColor().getCode());
    }

    @Test
    public void testColorIn() {
        assertTrue(block.colorIn(new Color("#0080FF")));
        assertFalse(block.colorIn(new Color("#F0F0F0")));
    }
}
