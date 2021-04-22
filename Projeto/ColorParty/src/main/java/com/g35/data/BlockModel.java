package com.g35.data;

import com.g35.observer.Observable;

import java.util.Random;

public class BlockModel extends Observable<BlockModel> implements BlockComposite {
    private Position position;
    private Color color;

    public BlockModel(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void randomColor() {
        Random rand = new Random();
        int index = rand.nextInt(colorList.size());
        this.color = colorList.get(index);
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
        this.notifyObservers(this);
    }

    @Override
    public boolean colorIn(Color color) {
        return color.sameColor(this.color);
    }

    @Override
    public void notifyHeroChange(Position position) {
        if (this.position.samePosition(position))
            this.notifyObservers(this);
    }

    @Override
    public void notifyEnemyChange(Position position) {
        if (this.position.samePosition(position))
            this.notifyObservers(this);
    }
}
