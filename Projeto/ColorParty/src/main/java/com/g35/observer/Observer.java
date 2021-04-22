package com.g35.observer;

public interface Observer<T> {
    void changed(T subject);
}