package com.g35.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TestChooseModeView {
    ChooseModeView view;
    Screen screenMock;

    @Before
    public void Preparations() throws IOException {
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        view = new ChooseModeView(screenMock, graphicsMock);

        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.Escape));
    }

    @Test
    public void testDrawInstructions() throws IOException {
        view.drawModes();
        verify(screenMock, times(1)).refresh();
        verify(screenMock, times(1)).clear();
        assertEquals("esc", view.drawModes());
        /*assertNotEquals(null , view.drawModes());
        assertNotEquals(" ", view.drawModes());*/
    }

    @Test
    public void testGetCommand() throws IOException {
        when(screenMock.readInput()).thenReturn(new KeyStroke('a', false, false));
        assertEquals(view.getCommand(), "a");
        when(screenMock.readInput()).thenReturn(new KeyStroke('A', false, false));
        assertEquals(view.getCommand(), "a");
        when(screenMock.readInput()).thenReturn(new KeyStroke('b', false, false));
        assertEquals(view.getCommand(), "b");
        when(screenMock.readInput()).thenReturn(new KeyStroke('B', false, false));
        assertEquals(view.getCommand(), "b");
        when(screenMock.readInput()).thenReturn(new KeyStroke('c', false, false));
        assertEquals(view.getCommand(), "c");
        when(screenMock.readInput()).thenReturn(new KeyStroke('C', false, false));
        assertEquals(view.getCommand(), "c");
        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.Escape));
        assertEquals(view.getCommand(), "esc");
    }
}
