package com.g35.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class ChooseModeView {
    private Screen screen;
    private TextGraphics graphics;

    public ChooseModeView(Screen screen, TextGraphics graphics) {
        this.screen = screen;
        this.graphics = graphics;
    }

    public String drawModes() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00FF3F"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(102, 49), ' ');
        graphics.putString(2,2,"   ______       _       ____    ____  ________   ____    ____   ___   ______   ________   ______   ");
        graphics.putString(2,3," .' ___  |     / \\     |_   \\  /   _||_   __  | |_   \\  /   _|.'   `.|_   _ `.|_   __  |.' ____ \\  ");
        graphics.putString(2,4,"/ .'   \\_|    / _ \\      |   \\/   |    | |_ \\_|   |   \\/   | /  .-.  \\ | | `. \\ | |_ \\_|| (___ \\_| ");
        graphics.putString(2,5,"| |   ____   / ___ \\     | |\\  /| |    |  _| _    | |\\  /| | | |   | | | |  | | |  _| _  _.____`.  ");
        graphics.putString(2,6,"\\ `.___]  |_/ /   \\ \\_  _| |_\\/_| |_  _| |__/ |  _| |_\\/_| |_\\  `-'  /_| |_.' /_| |__/ || \\____) | ");
        graphics.putString(2,7," `._____.'|____| |____||_____||_____||________| |_____||_____|`.___.'|______.'|________| \\______.' ");
        graphics.putString(22,9,"__________________________________________________________");


        graphics.putString(6, 13, "   ___ _  _  ___   ___  ___ ___     _      ___   _   __  __ ___   __  __  ___  ___  ___  _ ");
        graphics.putString(6, 14, "  / __| || |/ _ \\ / _ \\/ __| __|   /_\\    / __| /_\\ |  \\/  | __| |  \\/  |/ _ \\|   \\| __|(_)");
        graphics.putString(6, 15, " | (__| __ | (_) | (_) \\__ \\ _|   / _ \\  | (_ |/ _ \\| |\\/| | _|  | |\\/| | (_) | |) | _|  _ ");
        graphics.putString(6, 16, "  \\___|_||_|\\___/ \\___/|___/___| /_/ \\_\\  \\___/_/ \\_\\_|  |_|___| |_|  |_|\\___/|___/|___|(_)");

        graphics.putString(10, 20, " ____              _    _____   _____ _      ___   _   _____   __");
        graphics.putString(10, 21, "||A ||            | |  | __\\ \\ / / __| |    | __| /_\\ / __\\ \\ / /");
        graphics.putString(10, 22, "||__||            | |__| _| \\ V /| _|| |__  | _| / _ \\\\__ \\\\ V / ");
        graphics.putString(10, 23, "|/__\\|            |____|___| \\_/ |___|____| |___/_/ \\_\\___/ |_|  ");

        graphics.putString(10, 26, " ____              _    _____   _____ _      __  __ ___ ___ ___ _   _ __  __ ");
        graphics.putString(10, 27, "||B ||            | |  | __\\ \\ / / __| |    |  \\/  | __|   \\_ _| | | |  \\/  |");
        graphics.putString(10, 28, "||__||            | |__| _| \\ V /| _|| |__  | |\\/| | _|| |) | || |_| | |\\/| |");
        graphics.putString(10, 29, "|/__\\|            |____|___| \\_/ |___|____| |_|  |_|___|___/___|\\___/|_|  |_|");

        graphics.putString(10, 33, " ___              _    _____   _____ _      _  _   _   ___ ___  ");
        graphics.putString(10, 34, "||C ||           | |  | __\\ \\ / / __| |    | || | /_\\ | _ \\   \\ ");
        graphics.putString(10, 35, "||__||           | |__| _| \\ V /| _|| |__  | __ |/ _ \\|   / |) |");
        graphics.putString(10, 36, "|/__\\|           |____|___| \\_/ |___|____| |_||_/_/ \\_\\_|_\\___/ ");

        graphics.putString(10, 41, " ____             _____  _____ _____   _____ ___    __  __ ___ _  _ _   _ ");
        graphics.putString(10, 42, "||ESC||          | __\\ \\/ /_ _|_   _| |_   _/ _ \\  |  \\/  | __| \\| | | | |");
        graphics.putString(10, 43, "||___||          | _| >  < | |  | |     | || (_) | | |\\/| | _|| .` | |_| |");
        graphics.putString(10, 44, "|/___\\|          |___/_/\\_\\___| |_|     |_| \\___/  |_|  |_|___|_|\\_|\\___/ ");

        screen.refresh();
        return getCommand();
    }

    public String getCommand() throws IOException {
        while(true) {
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'a' || key.getCharacter() == 'A')) {
                return "a";
            }

            else if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'b' || key.getCharacter() == 'B')) {
                return "b";
            }

            else if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'c' || key.getCharacter() == 'C')) {
                return "c";
            }

            else if(key.getKeyType() == KeyType.Escape) {
                return "esc";
            }
        }
    }
}
