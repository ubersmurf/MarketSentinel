package com.marketsentinel.observer;

import com.marketsentinel.service.Logger;

import com.marketsentinel.model.Asset;

public class ConsoleLogger implements Observer {
    
    @Override
    public void update(Asset asset) {
        Logger.info("[ConsoleLogger] Price Change Detected: " + asset.getSymbol() + "->" + asset.getPrice());
    }
}
