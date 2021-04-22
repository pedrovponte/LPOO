package com.g35.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g35.data.*;
import com.g35.observer.Observable;
import com.g35.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class TopBarView extends Observable<TopBarView> {
    private TextGraphics graphics;
    private TopBarModel topBarModel;
    private TopBarModel timeTopBar;
    public List<BlockModel> topBlocks;
    public Observer<BlockModel> blockModelObserver;

    public TopBarView(ArenaView gui) {
        this.graphics = gui.getGraphics();
        topBlocks = new ArrayList<>();
        topBarModel = new TopBarModel(80, 5, gui);
        timeTopBar = new TopBarModel(102-topBarModel.getWidth(),5, gui);
        blockModelObserver = new BlockView(graphics);
    }

    public void paint(int score) {
        paintColorSpace();
        paintClockSpace();
        paintColorSurrounding();

        notifyTopBlocks();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5A5A5A"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(5, 2, "SCORE: ");
        graphics.putString(new TerminalPosition(12,2), String.valueOf(score));
    }

    private void paintColorSpace()
    {
        for (int i=0; i<topBarModel.getHeight();i++) {
            for (int j=0; j<topBarModel.getWidth();j++) {
                BlockModel block = new BlockModel(new Position(j,i), topBarModel.getColor());
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }
        }
    }

    private void paintClockSpace()
    {
        for (int i=1;i<timeTopBar.getHeight();i++)
        {
            for (int j=2;j<2+timeTopBar.getWidth();j++)
            {
                BlockModel block = new BlockModel(new Position(j,i), new Color("#5A5A5A"));
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }
        }
    }

    private void paintColorSurrounding()
    {
        for (int j=0;j<topBarModel.getWidth()+timeTopBar.getWidth();j++)
        {
            for (int i=0;i<1;i++)
            {
                BlockModel block = new BlockModel(new Position(j,i), new Color("#78787a"));
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }
        }
        for (int i=0;i<topBarModel.getHeight();i++)
        {
            for (int j=0;j<2;j++)
            {
                BlockModel block = new BlockModel(new Position(j,i), new Color("#78787a"));
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }

            for (int j=100;j<=102;j++)
            {
                BlockModel block = new BlockModel(new Position(j,i), new Color("#78787a"));
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }
        }
    }

    public void notifyTopBlocks() {
        for(BlockModel blockModel:topBlocks)
            blockModel.notifyObservers(blockModel);
    }

    public Color changeToRandomColor(int score) {
        topBarModel.newColor();
        paint(score);
        return topBarModel.getColor();
    }
}
