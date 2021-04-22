package com.g35.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class GameOverView {
    private Screen screen;
    private TextGraphics graphics;

    public GameOverView(Screen screen, TextGraphics graphics) {
        this.screen=screen;
        this.graphics=graphics;
    }

    public void drawGameOver(int score) throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(102, 49), ' ');
        graphics.putString(20,10,"   ____    _    __  __ _____    _____     _______ ____  ");
        graphics.putString(20,11,"  / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ ");
        graphics.putString(20,12," | |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |");
        graphics.putString(20,13," | |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < ");
        graphics.putString(20,14,"  \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\");

        graphics.putString(15,20,"         , ,\\ ,'\\,'\\ ,'\\ ,\\ ,");
        graphics.putString(15,21,"   ,  ;\\/ \\' `'     `   '  /|");
        graphics.putString(15,22,"   |\\/                      |");
        graphics.putString(15,23,"   :                        |");
        graphics.putString(15,24,"   :                        |");
        graphics.putString(60,24,"Final Score: " + score);
        graphics.putString(15,25,"    |                       |");
        graphics.putString(15,26,"    |                       |");
        graphics.putString(15,27,"    :               -.     _|");
        graphics.putString(15,28,"     :                \\     `.");
        graphics.putString(15,29,"     |         ________:______\\");
        graphics.putString(15,30,"     :       ,'o       / o    ;");
        graphics.putString(15,31,"     :       \\       ,'-----./");
        graphics.putString(15,32,"      \\_      `--.--'        )");
        graphics.putString(15,33,"     ,` `.              ,---'|");
        graphics.putString(15,34,"     : `                     |");
        graphics.putString(15,35,"      `,-'                   |");
        graphics.putString(15,36,"      /      ,---.          ,'");
        graphics.putString(15,37,"   ,-'            `-,------'");
        graphics.putString(15,38,"  '   `.        ,--'");
        graphics.putString(15,39,"        `-.____/ ");
        graphics.putString(15,40,"                \\");


        screen.refresh();
        getCommand();
    }

    public void getCommand() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Enter) break;
        }
    }
}
