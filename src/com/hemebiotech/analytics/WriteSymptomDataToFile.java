package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileName;

    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                // Adding each symptom with occurrences
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine(); // Adding a new line after each symptom
            }
            System.out.println("Symptoms has been written to " + fileName + " with the associated occurrences");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
