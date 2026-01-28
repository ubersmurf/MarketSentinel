package com.marketsentinel.service;

import java.time.LocalTime;

public final class Logger {

    // Singleton
    private Logger() {}

    // ANSI colors
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String GRAY = "\u001B[90m";

    // ---- Public API ----
    public static void info(String msg) {
        log("INFO", BLUE, msg);
    }

    public static void success(String msg) {
        log("SUCCESS", GREEN, msg);
    }

    public static void warn(String msg) {
        log("WARN", YELLOW, msg);
    }

    public static void error(String msg) {
        log("ERROR", RED, msg);
    }

    public static void debug(String msg) {
        log("DEBUG", CYAN, msg);
    }

    // ---- Core ----
    private static void log(String level, String color, String msg) {
        String time = LocalTime.now().toString();
        System.out.println(
                GRAY + "[" + time + "] " +
                color + level +
                RESET + " - " + msg
        );
    }
}