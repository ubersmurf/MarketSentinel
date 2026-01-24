package com.marketsentinel.model;

public class Crypto extends Asset {

    public Crypto(String symbol) {
        super(symbol);
    }

    @Override
    public String getType() {
        return "Cryptocurrency";
    }    
}
