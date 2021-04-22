package com.g35.states;

import com.g35.gui.MenuView;
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

public class TestMenuState {
    private MenuState state;
    private GameController controllerMock;
    private MenuView menuViewMock;
    private Screen screenMock;

    @Before
    public void Preparations() {
        state = new MenuState();
        screenMock = Mockito.mock(Screen.class);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        controllerMock = Mockito.mock(GameController.class);
        menuViewMock = Mockito.mock(MenuView.class);
        state.init(screenMock, graphicsMock, controllerMock);
        state.setMenuView(menuViewMock);
    }

    @Test
    public void TestDoStep() throws IOException {
        menuViewMock.drawMenu();
        verify(menuViewMock, times(1)).drawMenu();
        // Test for user input "A" (Play Game)
        Mockito.when(menuViewMock.getOpt()).thenReturn("a");
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToChooseModeState();

        // Test for user input "B" (Instructions)
        Mockito.when(menuViewMock.getOpt()).thenReturn("b");
        assertFalse(state.doStep());
        verify(controllerMock, times(1)).changeToInstructionsState();

        // Test for user input "ESC" (Quit Game)
        Mockito.when(menuViewMock.getOpt()).thenReturn("esc");
        assertTrue(state.doStep());
        verify(screenMock, times(1)).close();
    }
}
