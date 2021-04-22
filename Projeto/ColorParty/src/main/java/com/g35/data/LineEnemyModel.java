package com.g35.data;

public class LineEnemyModel extends EnemyModel {
    private int movement = 0;
    private int direction;

    public LineEnemyModel(Position position) {
        super(position);
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
