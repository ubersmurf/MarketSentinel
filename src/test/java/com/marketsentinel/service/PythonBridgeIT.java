package com.marketsentinel.service;

import org.junit.jupiter.api.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PythonBridgeIT {

    private static final File CHART_FILE =
            new File("data/chart.png");

    @BeforeEach
    void cleanUp() {
        if (CHART_FILE.exists()) {
            CHART_FILE.delete();
        }
    }

    @Test
    void generateGraph_createsChartFile() {
        PythonBridge bridge = new PythonBridge();

        int exitCode = bridge.generateGraph();

        assertEquals(0, exitCode, "Python script should exit with 0");
        assertTrue(CHART_FILE.exists(), "chart.png should be created");
        assertTrue(CHART_FILE.length() > 0, "chart.png should not be empty");
    }
}