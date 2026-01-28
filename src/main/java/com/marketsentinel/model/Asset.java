package com.marketsentinel.model;

import java.util.ArrayList;
import java.util.List;

import com.marketsentinel.observer.Observer;

public abstract class Asset {
    protected String symbol;
    protected double price;
    protected List<Observer> observers;

    public Asset(String symbol) {
        this.symbol = symbol;
        this.observers = new ArrayList<>();
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
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
