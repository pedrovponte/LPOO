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

public class TestInstructionsView {
    InstructionsView view;
    Screen screenMock;

    @Before
    public void Preparations() throws IOException {
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        view = new InstructionsView(screenMock, graphicsMock);

        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.EOF));
    }

    @Test
    public void testDrawInstructions() throws IOException {
        view.drawInstructions();
        verify(screenMock, times(1)).refresh();
        verify(screenMock, times(1)).clear();
        assertEquals(true, view.drawInstructions());
    }

    @Test
    public void testGetCommand() throws IOException {
        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertTrue(view.getCommand());
        when(screenMock.readInput()).thenReturn(new KeyStroke('x', false, false));
        assertFalse(view.getCommand());
        when(screenMock.readInput()).thenReturn(new KeyStroke('X', false, false));
        assertFalse(view.getCommand());
    }
}
