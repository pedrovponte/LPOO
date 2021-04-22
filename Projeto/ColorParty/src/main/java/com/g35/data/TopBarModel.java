package com.g35.data;

import com.g35.gui.ArenaView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TopBarModel {
    private int width;
    private int height;
    private Color color;
    private ArenaView gui;
    private static int lastIndex = 10;
    List<Color> colorList = Arrays.asList(new Color("#01DF01"), new Color("#DF0101"), new Color("#0080FF"), new Color("#D6DF01"), new Color("#C001DF"), new Color("#FF8C00"), new Color("#8B4513"), new Color("#FFFFFF"));

    public TopBarModel(int width, int height, ArenaView gui) {
        this.width = width;
        this.height = height;
        this.gui = gui;
        Random rand = new Random();
        int index = rand.nextInt(colorList.size());
        this.color = colorList.get(index);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {this.color = color;}

    public boolean colorInArena(Color color) {
        BlockComposite composite = gui.getArenaBlock();
        return composite.colorIn(color);
    }

    public void newColor() {
        Random rand = new Random();
        int index = rand.nextInt(colorList.size());
        while(lastIndex == index || !colorInArena(colorList.get(index))) {
            index = rand.nextInt(colorList.size());
        }
        lastIndex = index;
        this.color = colorList.get(index);
    }
}
