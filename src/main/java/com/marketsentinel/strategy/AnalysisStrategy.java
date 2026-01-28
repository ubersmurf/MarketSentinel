package com.marketsentinel.strategy;

import com.marketsentinel.model.Asset;

public interface AnalysisStrategy {
    public Signal analyze(Asset asset);
    public String getName();
}
