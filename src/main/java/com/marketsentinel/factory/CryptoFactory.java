package com.marketsentinel.factory;

import com.marketsentinel.model.Asset;
import com.marketsentinel.model.Crypto;

public class CryptoFactory extends AssetFactory {

    @Override
    public Asset create(String symbol, double price) {
        return new Crypto(symbol, price);
    }
    
}
