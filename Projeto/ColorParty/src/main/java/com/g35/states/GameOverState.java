package com.g35.states;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.gui.GameOverView;
import com.g35.rules.GameController;

import java.io.IOException;

public class GameOverState extends State {
    private GameController gameController;
    private GameOverView gameOverView;
    private int score;
    Screen screen;
    TextGraphics graphics;

    public GameOverState(int score) {
        this.score = score;
    }

    @Override
    public void init(Screen screen, TextGraphics graphics, GameController gameController) {
        this.screen = screen;
        this.graphics = graphics;
        this.gameController = gameController;
        gameOverView = new GameOverView(screen, graphics);
    }

    void setGameOverView(GameOverView view) {
        this.gameOverView = view;
    }

    @Override
    public boolean doStep() throws IOException {
        gameOverView.drawGameOver(score);
        gameController.changeToMenuState();
        return false;
    }
}
