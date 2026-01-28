package com.marketsentinel;

import com.marketsentinel.service.MarketService;
import com.marketsentinel.factory.AssetFactory;
import com.marketsentinel.factory.CryptoFactory;
import com.marketsentinel.factory.StockFactory;
import com.marketsentinel.model.Asset;
import com.marketsentinel.observer.ConsoleLogger;

public class App {
    public static void main(String[] args) {
        
        MarketService service = new MarketService();

        AssetFactory cryptoFactory = new CryptoFactory();
        AssetFactory stockFactory = new StockFactory();

        Asset myBitcoin = service.createAndTrackAsset(cryptoFactory, "BTC");
        Asset myAppleStock = service.createAndTrackAsset(stockFactory, "AAPL");

        ConsoleLogger logger = new ConsoleLogger();

        myBitcoin.addObserver(logger);
        System.out.println("*** Price change simulation ***");
        myBitcoin.setPrice(46000.0);
        myBitcoin.setPrice(45500.0);
    }
}
