package com.marketsentinel.model;

public class Stock extends Asset {

    public Stock(String symbol, double price) {
        super(symbol, price);
    }

    @Override
    public String getType() {
        return "Stock Market Share";
    }
    
}
