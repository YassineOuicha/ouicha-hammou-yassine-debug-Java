package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            List<String> symptoms = analyticsCounter.getSymptoms();

            Map<String, Integer> symptomsMap = analyticsCounter.countSymptoms(symptoms);

            System.out.println("Symptoms Map: " + symptomsMap);  // Check

            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsMap);

            System.out.println("Sorted symptoms Map: " + sortedSymptoms);  // Check

            analyticsCounter.writeSymptoms(sortedSymptoms);

            System.out.println("Process terminated");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
