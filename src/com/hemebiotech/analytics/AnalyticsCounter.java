package com.hemebiotech.analytics;


import java.lang.reflect.Array;
import java.util.*;

/**
 * This class reads from symptoms from a text file ("symptoms.txt" ) then count & sort the symptoms with their occurrences
 * The sorted symptoms are written into a text file ("result.out")
 *
 */

public class AnalyticsCounter {

	 // path to the data file containing symptoms
	private ISymptomReader reader; //
	private	ISymptomWriter writer;

	/**
	 * Constructor for AnalyticsCounter class
	 *
	 * @param reader The implementation of the interface ISymptomReader to read the given file
	 * @param writer The implementation of the interface ISymptomWriter to write an output file
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves a list of symptoms from the reader object
	 * @return A list of strings representing the symptoms
	 */

	public List<String> getSymptoms(){
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom and save data into a map Collection
	 *
	 * @param symptoms The list of symptoms retrieved from the reader object
	 * @return A map collection containing symptoms as keys and occurrences as values
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){

		Map<String, Integer> symptomsMap = new HashMap<>();

		for (int i = 0; i < symptoms.size(); i++) {
			String symptom = symptoms.get(i);
			List<String> findOccurrent = symptoms.stream().filter(s -> s.equals(symptom)).toList();
			symptomsMap.put(symptom, findOccurrent.size()); // Add the pair symptom with occurrences into the map collection
		}
		return symptomsMap;
	}

	/**
	 * Sorts alphabetically a given map of symptoms as keys and occurrences as values
	 *
	 * @param symptoms A map collection to be sorted
	 * @return A sorted map of symptoms with occurrences
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes the sorted map of symptoms into an output file
	 *
	 * @param symptoms A map collection of symptoms and occurrences
	 */
	public void writeSymptoms (Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}
}
