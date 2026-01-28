package com.marketsentinel.observer;

import com.marketsentinel.model.Asset;
import com.marketsentinel.service.Logger;
import com.marketsentinel.strategy.AnalysisStrategy;

public class TradeBot implements Observer {

    private AnalysisStrategy strategy;

    public TradeBot(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Asset asset) {
        String signal = strategy.analyze(asset);
        if (signal.equals("BUY")) {
            Logger.success("[TradeBot] 🟢 BUY ORDER: " + asset.getSymbol());
        } else if (signal.equals("SELL")) {
            Logger.error("[TradeBot] 🔴 SELL ORDER: " + asset.getSymbol());
        } else {
            Logger.info("[TradeBot] ⏸️ HOLD...");
        }
    }

    public void setStrategy(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }
    
    
}
