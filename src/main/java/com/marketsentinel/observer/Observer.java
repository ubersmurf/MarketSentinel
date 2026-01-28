package com.marketsentinel.observer;

import com.marketsentinel.model.Asset;

public interface Observer {
    public void update(Asset asset);
}
