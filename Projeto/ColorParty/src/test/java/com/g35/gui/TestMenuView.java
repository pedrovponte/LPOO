package com.g35.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestMenuView {
    MenuView view;
    Screen screenMock;

    @Before
    public void Preparations() throws IOException {
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        view = new MenuView(screenMock, graphicsMock);

        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.Escape));
    }

    @Test
    public void testDrawMenu() throws IOException {
        view.drawMenu();
        verify(screenMock, times(1)).refresh();
        verify(screenMock, times(1)).clear();
    }

    @Test
    public void testGetSetOpt() {
        view.setOpt("a");
        assertEquals(view.getOpt(), "a");
    }

    @Test
    public void testGetCommand() throws IOException {
        when(screenMock.readInput()).thenReturn(new KeyStroke('a', false, false));
        view.getCommand();
        assertEquals(view.getOpt(), "a");
        when(screenMock.readInput()).thenReturn(new KeyStroke('A', false, false));
        view.getCommand();
        assertEquals(view.getOpt(), "a");
        when(screenMock.readInput()).thenReturn(new KeyStroke('b', false, false));
        view.getCommand();
        assertEquals(view.getOpt(), "b");
        when(screenMock.readInput()).thenReturn(new KeyStroke('B', false, false));
        view.getCommand();
        assertEquals(view.getOpt(), "b");
        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.Escape));
        view.getCommand();
        assertEquals(view.getOpt(), "esc");
    }
}
