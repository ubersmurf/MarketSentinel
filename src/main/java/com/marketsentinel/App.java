package com.marketsentinel;

import com.marketsentinel.service.PythonBridge;
import com.marketsentinel.service.MarketService;
import com.marketsentinel.strategy.AnalysisStrategy;
import com.marketsentinel.strategy.MovingAverageStrategy;
import com.marketsentinel.strategy.RSIStrategy;
import com.marketsentinel.factory.AssetFactory;
import com.marketsentinel.factory.CryptoFactory;
import com.marketsentinel.model.Asset;
import com.marketsentinel.observer.ConsoleLogger;
import com.marketsentinel.observer.DataLogger;
import com.marketsentinel.observer.TradeBot;

public class App {
    public static void main(String[] args) throws InterruptedException {
        
        MarketService service = new MarketService();
        PythonBridge pythonBridge = new PythonBridge();
        AssetFactory cryptoFactory = new CryptoFactory();

        Asset btc = service.createAndTrackAsset(cryptoFactory, "BTC");

        btc.addObserver(new ConsoleLogger());
        btc.addObserver(DataLogger.getInstance()); 
        btc.addObserver(new TradeBot(new RSIStrategy()));

        double[] simulatedPrices = {42000, 43000, 41000, 39000, 38000, 45000, 48000, 51000, 52000, 49000};

        for (double price : simulatedPrices) {
            btc.setPrice(price); 
            Thread.sleep(1000);  
        }

        pythonBridge.generateGraph();        
    }
}