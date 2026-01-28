package com.marketsentinel.observer;

import com.marketsentinel.model.Asset;
import com.marketsentinel.service.Logger;
import com.marketsentinel.strategy.AnalysisStrategy;
import com.marketsentinel.strategy.Signal;

public class TradeBot implements Observer {

    private AnalysisStrategy strategy;

    public TradeBot(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Asset asset) {
        Signal signal = strategy.analyze(asset);
        Logger.info("[TradeBot] " + signal.getLabel() + " ORDER: " + asset.getSymbol());
    }

    public void setStrategy(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }
    
    
}
