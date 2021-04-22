package com.g35.gui;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MenuView {
    private Screen screen;
    private TextGraphics graphics;
    public String opt;

    public MenuView(Screen screen, TextGraphics graphics) {
        this.screen = screen;
        this.graphics = graphics;
    }

    public void drawMenu() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ADD1"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(102, 49), ' ');
        graphics.putString(36,2,"  __  __ _____ _   _ _   _ ");
        graphics.putString(36,3," |  \\/  | ____| \\ | | | | |");
        graphics.putString(36,4," | |\\/| |  _| |  \\| | | | |");
        graphics.putString(36,5," | |  | | |___| |\\  | |_| |");
        graphics.putString(36,6," |_|  |_|_____|_| \\_|\\___/ ");
        graphics.putString(20,8,"__________________________________________________________");

        graphics.putString(10, 13, " ____             ___ _      ___   __   ___   _   __  __ ___ ");
        graphics.putString(10, 14, "||A ||           | _ \\ |    /_\\ \\ / /  / __| /_\\ |  \\/  | __|");
        graphics.putString(10, 15, "||__||           |  _/ |__ / _ \\ V /  | (_ |/ _ \\| |\\/| | _| \n");
        graphics.putString(10, 16, "|/__\\|           |_| |____/_/ \\_\\_|    \\___/_/ \\_\\_|  |_|___|");

        graphics.putString(10, 20, " ____             ___ _  _ ___ _____ ___ _   _  ___ _____ ___ ___  _  _ ___ ");
        graphics.putString(10, 21, "||B ||           |_ _| \\| / __|_   _| _ \\ | | |/ __|_   _|_ _/ _ \\| \\| / __|");
        graphics.putString(10, 22, "||__||            | || .` \\__ \\ | | |   / |_| | (__  | |  | | (_) | .` \\__ \\");
        graphics.putString(10, 23, "|/__\\|           |___|_|\\_|___/ |_| |_|_\\\\___/ \\___| |_| |___\\___/|_|\\_|___/");

        graphics.putString(10, 30, " ____             _____  _____ _____    ___   _   __  __ ___ ");
        graphics.putString(10, 31, "||ESC||          | __\\ \\/ /_ _|_   _|  / __| /_\\ |  \\/  | __|");
        graphics.putString(10, 32, "||___||          | _| >  < | |  | |   | (_ |/ _ \\| |\\/| | _| ");
        graphics.putString(10, 33, "|/___\\|          |___/_/\\_\\___| |_|    \\___/_/ \\_\\_|  |_|___|");
        screen.refresh();
        getCommand();
    }

    public void getCommand() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'a' || key.getCharacter() == 'A')) {
                opt = "a";
                break;
            }

            else if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'b' || key.getCharacter() == 'B')) {
                opt = "b";
                break;
            }

            else if (key.getKeyType() == KeyType.Escape) {
                opt = "esc";
                break;
            }
        }
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
}
