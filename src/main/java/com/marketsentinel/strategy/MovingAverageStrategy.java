package com.marketsentinel.strategy;

import com.marketsentinel.model.Asset;

public class MovingAverageStrategy implements AnalysisStrategy {

    private final double movingAverage;

    public MovingAverageStrategy(double movingAverage) {
        this.movingAverage = movingAverage;
    }

    @Override
    public Signal analyze(Asset asset) {
        double price = asset.getPrice();

        if (price > movingAverage) {
            return Signal.BUY;
        }
        if (price < movingAverage) {
            return Signal.SELL;
        }
        return Signal.HOLD;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
