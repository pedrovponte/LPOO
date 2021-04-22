package com.g35.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.*;
import com.g35.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class TimeView {
    TimeModel time;
    Position position;
    private TextGraphics graphics;
    private TopBarModel topBarModel;
    private TopBarModel timeTopBar;
    public List<BlockModel> topBlocks;
    public Observer<BlockModel> blockModelObserver;

    public TimeView(ArenaView gui) {
        this.graphics = gui.getGraphics();
        this.time=new TimeModel(10);
        topBlocks = new ArrayList<>();
        blockModelObserver = new BlockView(graphics);
        topBarModel = new TopBarModel(80, 5, gui);
        timeTopBar = new TopBarModel(102-topBarModel.getWidth(),5, gui);
        position = new Position(93,2);
    }

    public void setTime(TimeModel time) {
        this.time = time;
    }

    public void drawTime()
    {
        fill();
        notifyTopBlocks();
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(86, 2, "TIME: ");
        print_Number();
    }

    public void fill()
    {
        for (int i=1;i<timeTopBar.getHeight();i++)
        {
            for (int j=topBarModel.getWidth();j<timeTopBar.getWidth()+topBarModel.getWidth()-2;j++)
            {
                BlockModel block = new BlockModel(new Position(j, i), new Color("#5A5A5A"));
                block.addObserver(blockModelObserver);
                topBlocks.add(block);
            }
        }
    }

    void print_Number() {
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), String.valueOf(time.getTime()));
    }

    public void notifyTopBlocks() {
        for(BlockModel blockModel:topBlocks)
            blockModel.notifyObservers(blockModel);
    }
}
