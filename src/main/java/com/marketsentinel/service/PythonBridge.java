package com.marketsentinel.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class PythonBridge {

    public void generateGraph() {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "python",
                    "python_scripts/plotter.py"
            );

            pb.directory(new File(System.getProperty("user.dir")));

            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                Logger.error("[PYTHON] " + line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                Logger.success("[PythonBridge] Created graph at: data/chart.png");
            } else {
                Logger.error("[PythonBridge] Python failed! EXIT CODE: " + exitCode);
            }

        } catch (Exception e) {
            Logger.error("[PythonBridge] Exception while running Python");
            e.printStackTrace();
        }
    }
}
