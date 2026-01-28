package com.marketsentinel.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.marketsentinel.factory.CryptoFactory;
import com.marketsentinel.model.Asset;

public class MovingAverageStrategyTest {
    
    @Test
    void shouldReturnBuy_WhenMovingAverageIsLow() {
        AnalysisStrategy strategy = new MovingAverageStrategy(30000.0);

        Asset btc = new CryptoFactory().create("BTC");
        btc.setPrice(40000.0);

        Signal signal = strategy.analyze(btc);

        assertEquals("BUY", signal.getLabel());
    }

    @Test
    void shouldReturnSell_WhenMovingAverageIsHigh() {
        AnalysisStrategy strategy = new MovingAverageStrategy(60000.0);

        Asset btc = new CryptoFactory().create("BTC");
        btc.setPrice(40000.0);
        
        Signal signal = strategy.analyze(btc);

        assertEquals("SELL", signal.getLabel());
    }

    
}
