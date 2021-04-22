package com.g35.states;

import com.g35.gui.InstructionsView;
import com.g35.rules.GameController;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class InstructionsState extends State {
    private GameController gameController;
    private InstructionsView instructionsView;
    Screen screen;
    TextGraphics graphics;

    @Override
    public void init(Screen screen, TextGraphics graphics, GameController gameController) {
        this.screen = screen;
        this.graphics = graphics;
        this.gameController = gameController;
        instructionsView = new InstructionsView(screen, graphics);
    }

    public void setInstructionsView(InstructionsView view) {
        this.instructionsView = view;
    }

    @Override
    public boolean doStep() throws IOException {
        boolean exit = instructionsView.drawInstructions();
        if (!exit) {
            gameController.changeToMenuState();
            return false;
        }
        return true;
    }
}
