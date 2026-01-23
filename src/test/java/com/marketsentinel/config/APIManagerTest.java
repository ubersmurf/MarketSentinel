package com.marketsentinel.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

public class APIManagerTest {

    @AfterEach
    void reset() {
        APIManager.resetInstance();
    }

    @Test
    void shouldReturnSameInstance() {
        APIManager instance1 = APIManager.getInstance();
        APIManager instance2 = APIManager.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    void shouldReturnDifferentPrice() {
        APIManager instance = APIManager.getInstance();
        double price1 = instance.getPrice("BTC");
        double price2 = instance.getPrice("BTC");

        assertNotEquals(price1, price2);
    }
}
