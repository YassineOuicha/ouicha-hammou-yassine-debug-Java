package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.List;



public class AnalyticsCounter {

	/**
	 * File path to the "symptoms.txt" file
	 * and extraction of the list of symptoms from the file.
	 */
	private static String filepath = "symptoms.txt";
	private static List<String> symptomsList = new ReadSymptomDataFromFile(filepath).GetSymptoms();

	public static void main(String[] args) throws Exception {

		// An array to track visited symptoms so we don't count the sale symptom more than one time
		List<String> visitedSymptoms = new ArrayList<>();

		// Iterate through the symptomsList to count occurrences
		for (int i = 0; i < symptomsList.size(); i++) {
			// The current symptom in the list
			String symptom = symptomsList.get(i);

			/**
			 * If the symptom doesn't appear on the visited list we continue the counting of this new element,
			 * Otherways we move to the next symptom
			 */

			if (!visitedSymptoms.contains(symptom)) {
				int count = 0;
				// Count how many times this symptom appears
				for (int j = 0; j < symptomsList.size(); j++) {
					if (symptom.equals(symptomsList.get(j))) {
						count++;
					}
				}

				// Print the symptom and its count
				System.out.println(symptom + " : " + count);

				// Add the symptom to the visited list to avoid counting it again
				visitedSymptoms.add(symptom);
			}
		}

	}
}
