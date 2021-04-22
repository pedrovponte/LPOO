package com.g35.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    private List<Observer<T>> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void notifyObservers(T subject) {
        for (Observer<T> observer : observers)
            observer.changed(subject);
    }
}
