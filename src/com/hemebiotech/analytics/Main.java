package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> symptomsMap = analyticsCounter.countSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsMap);

        analyticsCounter.writeSymptoms(sortedSymptoms);


    }
}
