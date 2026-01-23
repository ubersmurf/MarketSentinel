package com.marketsentinel.model;

public abstract class Asset {
    // This should hold the common member fields for future assets
    protected String symbol;
    protected double price;

    public Asset(String symbol, double price) {
        this.symbol = symbol;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract String getType();
}
