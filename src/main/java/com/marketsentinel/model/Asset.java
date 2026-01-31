package com.marketsentinel.model;

import java.util.ArrayList;
import java.util.List;

import com.marketsentinel.observer.Observer;
import java.time.LocalDateTime;

public abstract class Asset {
    protected String symbol;
    protected double price;
    protected LocalDateTime timeStamp;
    protected List<Observer> observers;

    public Asset(String symbol) {
        this.symbol = symbol;
        this.observers = new ArrayList<>();
        this.timeStamp = LocalDateTime.now();
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setPrice(double price) {
        this.price = price;
        this.timeStamp = LocalDateTime.now();
        notifyObservers();
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public double getPrice() {
        return this.price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean addObserver(Observer o) {
        if (!this.observers.add(o)) {
            return false;
        }
        return true;
    }

    public boolean removeObserver(Observer o) {
        if (!this.observers.remove(o)) {
            return false;
        }
        return true;
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public abstract String getType();
}
