package com.marketsentinel.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.marketsentinel.factory.CryptoFactory;
import com.marketsentinel.model.Asset;

public class RSIStrategyTest {
    
    @Test
    void shouldReturnBuy_WhenPriceIsLow() {
        AnalysisStrategy strategy = new RSIStrategy();

        Asset btc = new CryptoFactory().create("BTC");
        btc.setPrice(30000.0);

        Signal signal = strategy.analyze(btc);

        assertEquals("BUY", signal.getLabel());
    }

    @Test
    void shouldReturnSell_WhenPriceIsHigh() {
        AnalysisStrategy strategy = new RSIStrategy();

        Asset btc = new CryptoFactory().create("BTC");
        btc.setPrice(60000.0);
        
        Signal signal = strategy.analyze(btc);

        assertEquals("SELL", signal.getLabel());
    }

    @Test
    void shouldReturnHold_WhenPriceIsInBetween() {
        AnalysisStrategy strategy = new RSIStrategy();
        Asset btc = new CryptoFactory().create("BTC");
        btc.setPrice(45000.0);

        Signal signal = strategy.analyze(btc);

        assertEquals("HOLD", signal.getLabel());
    }
}
