package com.marketsentinel;

import com.marketsentinel.service.Logger;

import com.marketsentinel.config.APIManager;

public class App {
    public static void main(String[] args) {
        APIManager manager = APIManager.getInstance();

        Logger.info("BTC Price: " + manager.getPrice("BTC"));
        Logger.info("ETH Price: " + manager.getPrice("ETH"));
        Logger.info("BTC Price: " + manager.getPrice("BTC"));
    }
}
