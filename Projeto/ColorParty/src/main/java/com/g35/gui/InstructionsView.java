package com.g35.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class InstructionsView {
    private Screen screen;
    private TextGraphics graphics;

    public InstructionsView(Screen screen, TextGraphics graphics) {
        this.screen = screen;
        this.graphics = graphics;
    }

    public boolean drawInstructions() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FA5858"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(102, 49), ' ');
        graphics.putString(15,4,"  ___ _   _ ____ _____ ____  _   _  ____ _____ ___ ___  _   _ ____ ");
        graphics.putString(15,5," |_ _| \\ | / ___|_   _|  _ \\| | | |/ ___|_   _|_ _/ _ \\| \\ | / ___| ");
        graphics.putString(15,6,"  | ||  \\| \\___ \\ | | | |_) | | | | |     | |  | | | | |  \\| \\___ \\ ");
        graphics.putString(15,7,"  | || |\\  |___) || | |  _ <| |_| | |___  | |  | | |_| | |\\  |___) |");
        graphics.putString(15,8," |___|_| \\_|____/ |_| |_| \\_\\\\___/ \\____| |_| |___\\___/|_| \\_|____/ ");
        graphics.putString(5, 13, "The arena is divided into different blocks, each one with a color");
        graphics.putString(5, 15, "There is a top bar with the punctuation, the color and the time left");
        graphics.putString(5, 17, "The goal of the game is to move the hero to a block with the same color as the one ");
        graphics.putString(5, 19, "on the top bar before time finishes, trying not to collide with enemies");
        graphics.putString(5, 21, "If the time ends and the player is in a block with the right color, wins a point");
        graphics.putString(5, 23, "and continues to the next color");
        graphics.putString(5, 25, "Otherwise or if collides with an enemy, the game ends");
        graphics.putString(5, 27, "To move the hero, press the keyboard arrows");
        graphics.putString(5, 31, "Press X to return to the Menu");
        screen.refresh();
        return getCommand();
    }

    public boolean getCommand() throws IOException {
        while(true) {
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'x' || key.getCharacter() == 'X')) return false;

            if (key.getKeyType() == KeyType.EOF) return true;
        }
    }
}
