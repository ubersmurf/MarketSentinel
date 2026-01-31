package com.marketsentinel.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class PythonBridge {

    private final String pythonCommand;
    private final File workingDir;

    public PythonBridge(String pythonCommand, File workingDir) {
        this.pythonCommand = pythonCommand;
        this.workingDir = workingDir;
    }

    public PythonBridge() {
        this("python", new File(System.getProperty("user.dir")));
    }

    public int generateGraph() {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    pythonCommand,
                    "python_scripts/plotter.py"
            );

            pb.directory(workingDir);
            pb.redirectErrorStream(true);

            Process process = pb.start();

            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Logger.error("[PYTHON] " + line);
                }
            }

            return process.waitFor();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
