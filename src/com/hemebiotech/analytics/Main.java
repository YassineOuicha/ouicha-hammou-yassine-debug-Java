package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The main class that executes the program to read the data from a symptoms text file
 * then writes the sorted symptoms with their occurrences into an output file
 */

public class Main {

    /**
     * Main program to read, sort, and write the sorted symptoms with their occurrences
     *
     * @throws Exception In case of an error
     */
    public static void main(String[] args) throws Exception {

        try {
            // Creates the reader and the writer objects
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            // Creates the analyticsCounter object to get, count, sort and write the symptoms result file
            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            // Retrieve symptoms list data
            List<String> symptoms = analyticsCounter.getSymptoms();

            // Counts the symptoms occurrences into a map collection
            Map<String, Integer> symptomsMap = analyticsCounter.countSymptoms(symptoms);

            System.out.println("Symptoms Map: " + symptomsMap);  // Check point to debug

            // Sorts the map collection
            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsMap);

            System.out.println("Sorted symptoms Map: " + sortedSymptoms);  // Check point to debug

            // Writes sorted symptoms into the result output file
            analyticsCounter.writeSymptoms(sortedSymptoms);

            System.out.println("Process terminated"); // Check point to debug

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
