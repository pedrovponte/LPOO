package com.g35.data;

import com.g35.observer.Observable;

public class ElementModel extends Observable<ElementModel> {
    protected Position position;

    public ElementModel(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
