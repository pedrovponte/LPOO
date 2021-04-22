package com.g35.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestColor {
    @Test
    public void testGetCode() {
        Color color = new Color("#01DF01");

        assertEquals("#01DF01", color.getCode());
    }

    @Test
    public void testSameColor() {
        Color color1 = new Color("#01DF01");
        Color color2 = new Color("#01DF01");
        Color color3 = new Color("#FFFFFF");

        assertEquals(true, color1.sameColor(color2));
        assertEquals(false, color1.sameColor(color3));
    }

    @Test
    public void testShowColor() {
        Color color = new Color("#FFFFFF");
        assertNotEquals(color.showColor(), null);
    }
}
