package com.marketsentinel.strategy;

import com.marketsentinel.model.Asset;

public class RSIStrategy implements AnalysisStrategy {
    @Override
    public Signal analyze(Asset asset) {
        double price = asset.getPrice();
        Signal signal = Signal.HOLD;

        if (price < 40000) {
            signal = Signal.BUY;
        }
        if (price > 50000) {
            signal = Signal.SELL;
        }
        return signal;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
