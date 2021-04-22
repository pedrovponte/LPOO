package com.g35.rules;

import com.g35.states.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TestGameController {
    private GameController controller;
    private Screen screenMock;
    private TextGraphics graphicsMock;
    private State stateMock;

    @Before
    public void Preparations() throws IOException {
        controller = new GameController();
        screenMock = mock(Screen.class);
        controller.screen = screenMock;
        Screen spy = spy(controller.screen);
        doAnswer(invocation -> null).when(spy).startScreen();

        graphicsMock = mock(TextGraphics.class);
        stateMock = mock(State.class);
        controller.graphics = graphicsMock;
        controller.state = new MenuState();
    }

    @Test
    public void testInit() throws IOException {
        when(screenMock.pollInput()).thenReturn(new KeyStroke(KeyType.Escape));
        controller.init();
        assertTrue(controller.state instanceof MenuState);
    }

    @Test
    public void testDoStep() throws IOException {
        controller.state = stateMock;
        controller.doStep();
        Mockito.verify(stateMock, Mockito.times(1)).doStep();
    }

    @Test
    public void testChangeToMenuState() throws IOException {
        controller.changeToMenuState();
        assertTrue(controller.state instanceof MenuState);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
    }

    @Test
    public void testChangeToChooseModeState() throws IOException {
        controller.changeToChooseModeState();
        assertTrue(controller.state instanceof ChooseModeState);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
    }

    @Test
    public void testChangeToGameOverState() throws IOException {
        controller.changeToGameOverState(1);
        assertTrue(controller.state instanceof GameOverState);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
    }

    @Test
    public void testChangeToInstructionsStates() throws IOException {
        controller.changeToInstructionsState();
        assertTrue(controller.state instanceof InstructionsState);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
    }
}
