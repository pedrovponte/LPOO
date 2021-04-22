package com.g35.states;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.rules.GameController;

import java.io.IOException;

public abstract class State {
    public abstract void init(Screen screen, TextGraphics graphics, GameController gameController) throws IOException;

    public abstract boolean doStep() throws IOException;
}
