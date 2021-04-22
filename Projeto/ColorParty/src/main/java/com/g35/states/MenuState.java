package com.g35.states;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.gui.MenuView;
import com.g35.rules.GameController;

import java.io.IOException;

public class MenuState extends State {
    private GameController gameController;
    private MenuView menuView;
    Screen screen;
    TextGraphics graphics;

    @Override
    public void init(Screen screen, TextGraphics graphics, GameController gameController) {
        this.screen = screen;
        this.graphics = graphics;
        this.gameController = gameController;
        menuView = new MenuView(screen, graphics);
    }

    public void setMenuView(MenuView view) {
        this.menuView = view;
    }

    @Override
    public boolean doStep() throws IOException {
        menuView.drawMenu();

        switch (menuView.getOpt()) {
            case "a":
                gameController.changeToChooseModeState();
                break;
            case "b":
                gameController.changeToInstructionsState();
                break;
            case "esc":
                screen.close();
                return true;
        }
        return false;
    }
}
