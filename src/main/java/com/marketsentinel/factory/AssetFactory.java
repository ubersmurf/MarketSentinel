package com.marketsentinel.factory;

import com.marketsentinel.model.Asset;

public abstract class AssetFactory {
    public abstract Asset create(String symbol, double price);
}
