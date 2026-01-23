package com.marketsentinel.model;

public class Crypto extends Asset {

    public Crypto(String symbol, double price) {
        super(symbol, price);
    }

    @Override
    public String getType() {
        return "Cryptocurrency";
    }    
}
