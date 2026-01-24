package com.marketsentinel.model;

public class Stock extends Asset {

    public Stock(String symbol) {
        super(symbol);
    }

    @Override
    public String getType() {
        return "Stock Market Share";
    }
    
}
