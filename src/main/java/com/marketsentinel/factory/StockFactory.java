package com.marketsentinel.factory;

import com.marketsentinel.model.Asset;
import com.marketsentinel.model.Stock;

public class StockFactory extends AssetFactory {
    @Override
    public Asset create(String symbol, double price) {
        return new Stock(symbol, price);
    }
    
}
