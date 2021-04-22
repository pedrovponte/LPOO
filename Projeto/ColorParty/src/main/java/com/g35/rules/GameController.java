package com.g35.rules;

import com.g35.states.*;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GameController {
    State state;
    Screen screen;
    TextGraphics graphics;

    public GameController() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(102, 49)).createTerminal();
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();
    }

    public void init() throws IOException {
        state = new MenuState();
        state.init(screen,graphics,this);
    }

    public boolean doStep() throws IOException {
        return state.doStep();
    }

    public void changeToGameState(int mode) throws IOException {
        screen.clear();
        state = new GameState(mode);
        state.init(screen, graphics, this);
    }

    public void changeToMenuState() throws IOException {
        screen.clear();
        state = new MenuState();
        state.init(screen, graphics, this);
    }

    public void changeToChooseModeState() throws IOException {
        screen.clear();
        state = new ChooseModeState();
        state.init(screen, graphics, this);
    }

    public void changeToGameOverState(int score) throws IOException {
        screen.clear();
        state = new GameOverState(score);
        state.init(screen, graphics, this);
    }

    public void changeToInstructionsState() throws IOException {
        screen.clear();
        state = new InstructionsState();
        state.init(screen, graphics, this);
    }
}
