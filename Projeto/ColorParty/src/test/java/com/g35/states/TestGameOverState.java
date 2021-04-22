package com.g35.states;

import com.g35.gui.GameOverView;
import com.g35.rules.GameController;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TestGameOverState {
    private GameOverState state;
    private GameOverView gameOverViewMock;
    private GameController controllerMock;

    @Before
    public void Preparations() throws IOException {
        state = new GameOverState(0);
        Screen screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        controllerMock = Mockito.mock(GameController.class);
        gameOverViewMock = Mockito.mock(GameOverView.class);
        state.init(screenMock, graphicsMock, controllerMock);
        state.setGameOverView(gameOverViewMock);
    }

    @Test
    public void TestDoStep() throws IOException {
        state.doStep();
        verify(gameOverViewMock, times(1)).drawGameOver(0);
        verify(controllerMock, times(1)).changeToMenuState();
        assertFalse(state.doStep());
    }
}
