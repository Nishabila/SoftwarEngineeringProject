package com.example.almuhtazibah11.APplicationLayer;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers();
}
