package com.marketsentinel.strategy;

public enum Signal {
    BUY("BUY", "Buy signal"),
    SELL("SELL", "Sell signal"),
    HOLD("HOLD", "Hold position");

    private final String label;
    private final String description;

    Signal(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDescription() {
        return this.description;
    }

    
}
