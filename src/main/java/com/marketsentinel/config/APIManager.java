package com.marketsentinel.config;

import com.marketsentinel.service.Logger;
import java.util.Random;

public class APIManager {
    private static APIManager instance;
    private Random random;
    
    private APIManager() {
        // Some initialization code such as actually connecting to the server
        Logger.success("APIManager initialized in MOCKMODE");
        this.random = new Random();
    }

    // Ensures everyone gets the same instance of this class
    public static synchronized APIManager getInstance() {
        if (APIManager.instance == null) {
            APIManager.instance = new APIManager();
        }
        return APIManager.instance;
    }

    // Mock API data
    public double getPrice(String symbol) {
        double price = 0.0;

        switch (symbol) {
            case "BTC":
                price = 45000.0;
                break;
            case "ETH":
                price = 3000.0;
                break;
            default:
                price = 100.0;
        }

        double fluctuation = (random.nextDouble()-0.5) * 2;
        double changeAmount = price * (fluctuation / 100);

        return price + changeAmount;
    }
    


    // For testing purposes only
    static void resetInstance() {
        instance = null;
    }
}
