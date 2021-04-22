package com.g35.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TestGameOverView {
    GameOverView view;
    Screen screenMock;

    @Before
    public void Preparations() throws IOException {
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        view = new GameOverView(screenMock, graphicsMock);

        when(screenMock.readInput()).thenReturn(new KeyStroke(KeyType.Enter));
    }

    @Test
    public void testDrawGameOver() throws IOException {
        view.drawGameOver(0);
        verify(screenMock, times(1)).refresh();
        verify(screenMock, times(1)).clear();
    }

    @Test
    public void testGetCommand() throws IOException {
        view.getCommand();
        verify (screenMock, times(1)).readInput();
    }
}
