package com.g35.data;

import com.g35.observer.Observable;

import java.util.List;
import java.util.Random;

public class BlockGroup extends Observable<BlockGroup> implements BlockComposite {
    private List<BlockComposite> blockList;
    private int level;
    private static int index = 0;
    private static int line = 0;
    private static int column = 0;
    private static int[][] matrix_index = new int[14][32];

    public BlockGroup(List<BlockComposite> blockList, int level) {
        this.blockList = blockList;
        this.level = level;
    }

    @Override
    public Color getColor() {
        return blockList.get(0).getColor();     // All elements of a group have the same color
    }

    public void differentColors() {
        for (BlockComposite block : blockList) {
            block.randomColor();
        }
        line = 0;
        column = 0;
    }

    @Override
    public void randomColor() {
        if (level == 1 || level == 2)
            putDifferentColors();
        else {
            Random rand = new Random();
            index = rand.nextInt(colorList.size());
        }

        for (BlockComposite block : blockList) {
            block.changeColor(colorList.get(index));
        }
    }

    private void putDifferentColors() {
        Random rand = new Random();
        index = rand.nextInt(colorList.size());

        if(line == 0 && column == 0) {
            matrix_index[line][column] = index;
        }

        else if(line == 0 && column > 0) {
            while(index == matrix_index[line][column - 1]){
                index = rand.nextInt(colorList.size());
            }
            matrix_index[line][column] = index;
        }

        else if(line > 0 && column == 0) {
            while (index == matrix_index[line - 1][0]){
                index = rand.nextInt(colorList.size());
            }
            matrix_index[line][column] = index;
        }

        else {
            while (index == matrix_index[line - 1][column] || index == matrix_index[line][column - 1]) {
                index = rand.nextInt(colorList.size());
            }
            matrix_index[line][column] = index;
        }

        column++;
        if(column == 7 && level == 1){
            column = 0;
            if (line < 2)
                line++;
        }
        else if(column == 32 && level == 2) {
            column = 0;
            if (line < 14)
                line++;
        }
    }

    @Override
    public void changeColor(Color color) {
        for (BlockComposite block : blockList) {
            block.changeColor(color);
        }
    }

    @Override
    public boolean colorIn(Color color) {
        for (BlockComposite block : blockList) {
            if (block.colorIn(color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void notifyHeroChange(Position position) {
        for (BlockComposite block : blockList) {
            block.notifyHeroChange(position);
        }
    }

    @Override
    public void notifyEnemyChange(Position position) {
        for (BlockComposite block : blockList) {
            block.notifyEnemyChange(position);
        }
    }
}
