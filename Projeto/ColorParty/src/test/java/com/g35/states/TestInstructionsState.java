package com.g35.states;

import com.g35.gui.InstructionsView;
import com.g35.rules.GameController;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TestInstructionsState {
    private InstructionsState state;
    private GameController controllerMock;
    private InstructionsView instructionsViewMock;

    @Before
    public void Preparations() {
        state = new InstructionsState();
        Screen screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        controllerMock = Mockito.mock(GameController.class);
        instructionsViewMock = Mockito.mock(InstructionsView.class);
        state.init(screenMock, graphicsMock, controllerMock);
        state.setInstructionsView(instructionsViewMock);
    }

    @Test
    public void TestDoStep() throws IOException {
        Mockito.when(instructionsViewMock.drawInstructions()).thenReturn(true);
        assertTrue(state.doStep());

        Mockito.when(instructionsViewMock.drawInstructions()).thenReturn(false);
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToMenuState();
    }
}
