package com.marketsentinel.observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.marketsentinel.model.Asset;
import com.marketsentinel.service.Logger;
import com.opencsv.CSVWriter;

public class DataLogger implements Observer {

    private static DataLogger instance;

    private DataLogger() {}

    public static synchronized DataLogger getInstance() {
        if (DataLogger.instance == null) {
            DataLogger.instance = new DataLogger();
        }
        return DataLogger.instance;
    }

    public static void writeDataLineByLine(String filePath, String[] data) {
        File file = new File(filePath);
        boolean fileExists = file.exists();

        try (FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile)) {

            if (!fileExists || file.length() == 0) {
                String[] header = { "Timestamp", "Price" };
                writer.writeNext(header);
            }

            writer.writeNext(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Asset asset) {
        String[] data = { asset.getTimeStamp().toString(), String.valueOf(asset.getPrice()) };
        writeDataLineByLine("data/market_data.csv", data);
        Logger.info("[DataLogger] Logging data to csv");
    }
    
}
