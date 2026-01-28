package com.marketsentinel;

import com.marketsentinel.service.MarketService;
import com.marketsentinel.strategy.AnalysisStrategy;
import com.marketsentinel.strategy.RSIStrategy;
import com.marketsentinel.factory.AssetFactory;
import com.marketsentinel.factory.CryptoFactory;
import com.marketsentinel.model.Asset;
import com.marketsentinel.observer.ConsoleLogger;
import com.marketsentinel.observer.TradeBot;

public class App {
    public static void main(String[] args) {
        
        MarketService service = new MarketService();

        AssetFactory cryptoFactory = new CryptoFactory();

        Asset crypto = service.createAndTrackAsset(cryptoFactory, "BTC");

        ConsoleLogger consoleLogger = new ConsoleLogger();
        crypto.addObserver(consoleLogger);

        AnalysisStrategy strategy = new RSIStrategy();
        TradeBot tradeBot = new TradeBot(strategy);
        crypto.addObserver(tradeBot);

        crypto.setPrice(30000.0);
        crypto.setPrice(45000.0);
        crypto.setPrice(60000.0);


    }
}
