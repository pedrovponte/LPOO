package com.g35.states;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.ArenaModel;
import com.g35.gui.ArenaView;
import com.g35.rules.ArenaController;
import com.g35.rules.GameController;

import java.io.IOException;

public class GameState extends State {
    private int mode;
    private boolean exit = false;

    public GameState(int mode) {
        this.mode = mode;
    }

    @Override
    public void init(Screen screen, TextGraphics graphics, GameController gameController) throws IOException {
        ArenaModel arena = new ArenaModel(102, 49, mode);
        ArenaView gui = new ArenaView(102, 49, screen, graphics, mode);

        ArenaController controller = new ArenaController(gui, arena);
        int score = controller.start(mode);
        if (score != -1)
            gameController.changeToGameOverState(score);
        else
            exit = true;
    }

    @Override
    public boolean doStep() {
        return exit;
    }
}
