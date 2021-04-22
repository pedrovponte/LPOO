package com.g35;

import com.g35.rules.GameController;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController();
        gameController.init();
        boolean exit = false;
        while(!exit)
        {
            exit = gameController.doStep();
        }
    }
}
