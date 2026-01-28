package com.marketsentinel.service;

import com.marketsentinel.config.APIManager;
import com.marketsentinel.factory.AssetFactory;
import com.marketsentinel.model.Asset;

public class MarketService {

    private final APIManager apiManager;

    public MarketService() {
        this.apiManager = APIManager.getInstance();
    }

    public Asset createAndTrackAsset(AssetFactory factory, String symbol) {
        Asset asset = factory.create(symbol);

        double currentPrice = apiManager.getPrice(symbol);

        asset.setPrice(currentPrice);

        Logger.info("[SERVICE] " + asset.getType() + " (" + symbol + ") created at price: $" + currentPrice);

        return asset;
    }


}
