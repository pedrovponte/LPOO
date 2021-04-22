package com.g35.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.*;
import com.g35.files.ReadFiles;
import com.g35.observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaView implements Observer<ArenaModel> {
    private Screen screen;
    private TextGraphics graphics;

    private BlockView blockObserver;
    private ElementView heroObserver;
    private ElementView enemyObserver;

    private TopBarView topBarView;

    private BlockComposite arenaBlock;

    public List<BlockModel> limits;
    public List<BlockModel> minimumBlocks;

    private TimeView timeView;

    public TimeView getTimeView() {
        return timeView;
    }

    public List<BlockModel> getMinimumBlocks() {
        return minimumBlocks;
    }

    public ElementView getHeroObserver() {
        return heroObserver;
    }

    public ElementView getEnemyObserver() {
        return enemyObserver;
    }

    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public TopBarView getTopBarView() {
        return topBarView;
    }

    public BlockComposite getArenaBlock() {
        return arenaBlock;
    }

    public ArenaView(int width, int height, Screen screen, TextGraphics graphics, int mode) {
        this.screen = screen;
        this.graphics = graphics;

        topBarView = new TopBarView(this);

        limits = new ArrayList<>();
        minimumBlocks = new ArrayList<>();

        blockObserver = new BlockView(graphics);
        heroObserver = new ElementView(graphics);
        enemyObserver = new ElementView(graphics);

        createMinimumBlocks(width, height);
        createLimits(width, height);

        List<BlockComposite> blockGroups = new ArrayList<>();
        switch (mode) {
            case 1:
                blockGroups = ReadFiles.read(minimumBlocks, "Arenas/Level_1/Pattern.txt");
                break;
            case 2:
                blockGroups = ReadFiles.read(minimumBlocks, "Arenas/Level_2/Pattern.txt");
                break;
            case 3:
                blockGroups = ReadFiles.read(minimumBlocks, "Arenas/Level_3/Pattern.txt");
                break;
        }

        arenaBlock = new BlockGroup(blockGroups, mode);

        ((BlockGroup) arenaBlock).differentColors();

        timeView = new TimeView(this);

        drawLimits();
        getTimeView().drawTime();
        topBarView.paint(0);
    }

    @Override
    public void changed(ArenaModel arena) {
        drawArena();
    }

    public void drawArena() {
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawLimits() {
        for (BlockModel limit : limits)
            limit.notifyObservers(limit);
    }

    private void createLimits(int width, int height) {
        Color limitsColor = new Color("#78787a");

        // Para limites do lado Esquerdo
        for (int h = 5 ; h < height ; h++) {
            BlockModel block = new BlockModel(new Position(0, h), limitsColor);
            BlockModel block2 = new BlockModel(new Position(1, h), limitsColor);
            block.addObserver(blockObserver);
            block2.addObserver(blockObserver);
            limits.add(block);
            limits.add(block2);
        }
        // Para limites do lado Direito
        for (int h = 5 ; h < height ; h++) {
            BlockModel block = new BlockModel(new Position(width - 1, h), limitsColor);
            BlockModel block2 = new BlockModel(new Position(width - 2, h), limitsColor);
            block.addObserver(blockObserver);
            block2.addObserver(blockObserver);
            limits.add(block);
            limits.add(block2);
        }
        // Para limites de Cima
        for (int w = 0 ; w < width ; w++) {
            BlockModel block = new BlockModel(new Position(w, 5), limitsColor);
            block.addObserver(blockObserver);
            limits.add(block);
        }
        // Para limites de Baixo
        for (int w = 0 ; w < width ; w++) {
            BlockModel block = new BlockModel(new Position(w, height - 1), limitsColor);
            block.addObserver(blockObserver);
            limits.add(block);
        }
    }

    private void createMinimumBlocks(int width, int height)
    {
        for (int i=6; i<height; i++) {
            for (int j=2; j<width - 2; j++)
            {
                BlockModel blockModel = new BlockModel(new Position(j,i), null);
                blockModel.addObserver(blockObserver);
                minimumBlocks.add(blockModel);
            }
        }
    }

    public BlockModel findArenaBlock(Position position) {
        for (BlockModel minimum : minimumBlocks) {
            if (minimum.getPosition().samePosition(position))
                return minimum;
        }
        return null;
    }

    public void closeScreen() throws IOException {
        screen.close();
    }
}