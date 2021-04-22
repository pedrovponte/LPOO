package com.g35.states;

import com.g35.gui.ChooseModeView;
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

public class TestChooseModeState {
    private ChooseModeState state;
    private ChooseModeView chooseModeViewMock;
    private GameController controllerMock;
    private Screen screenMock;

    @Before
    public void Preparations() {
        state = new ChooseModeState();
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        controllerMock = Mockito.mock(GameController.class);
        chooseModeViewMock = Mockito.mock(ChooseModeView.class);
        state.init(screenMock, graphicsMock, controllerMock);
        state.setChooseModeView(chooseModeViewMock);
    }

    @Test
    public void TestDoStep() throws IOException {
        // Test for user input "A" (Easy Mode)
        Mockito.when(chooseModeViewMock.drawModes()).thenReturn("a");
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToGameState(1);

        // Test for user input "B" (Medium Mode)
        Mockito.when(chooseModeViewMock.drawModes()).thenReturn("b");
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToGameState(2);

        // Test for user input "C" (Hard Mode)
        Mockito.when(chooseModeViewMock.drawModes()).thenReturn("c");
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToGameState(3);

        // Test for user input "ESC" (Quit Game)
        Mockito.when(chooseModeViewMock.drawModes()).thenReturn("esc");
        assertFalse(state.doStep());
        //verify(controllerMock, times(1)).changeToMenuState();
    }
}
