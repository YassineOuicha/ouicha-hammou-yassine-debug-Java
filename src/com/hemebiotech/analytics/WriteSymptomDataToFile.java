package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of the ISymptomWriter interface that writes symptoms into a file.
 * Symptoms as keys and the occurrences as values
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String fileName; // Path to the result file so wa can change it from the main program

    /**
     * Constructor for the implementation of WriteSymptomsDataFile Class
     *
     * @param fileName Path to the result file
     */
    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes a map of symptoms with their occurrences to the specified file
     *
     * @param symptoms A map containing symptoms as keys and occurrences as values
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                // Adding each symptom with occurrences
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine(); // Adding a new line after each symptom
            }
            System.out.println("Symptoms has been written to " + fileName + " with the associated occurrences"); // check point to debug

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
