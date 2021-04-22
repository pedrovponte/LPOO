package com.g35.states;

import com.g35.gui.ChooseModeView;
import com.g35.rules.GameController;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class ChooseModeState extends State {
    private GameController gameController;
    private ChooseModeView chooseModeView;
    Screen screen;
    TextGraphics graphics;

    @Override
    public void init(Screen screen, TextGraphics graphics, GameController gameController) {
        this.screen = screen;
        this.graphics = graphics;
        this.gameController = gameController;
        chooseModeView = new ChooseModeView(screen, graphics);
    }

    void setChooseModeView(ChooseModeView view) {
        this.chooseModeView = view;
    }

    @Override
    public boolean doStep() throws IOException {
        String option = chooseModeView.drawModes();
        switch (option) {
            case "a":
                gameController.changeToGameState(1);
                break;
            case "b":
                gameController.changeToGameState(2);
                break;
            case "c":
                gameController.changeToGameState(3);
                break;
            case "esc":
                gameController.changeToMenuState();
                break;
        }
        return false;
    }
}
