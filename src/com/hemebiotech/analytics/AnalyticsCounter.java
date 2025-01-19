package com.hemebiotech.analytics;


import java.util.*;


public class AnalyticsCounter {


	private static String filepath = "symptoms.txt";
	private ISymptomReader reader;
	private	ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms){

		Map<String, Integer> symptomsMap = new HashMap<>();
		List<String> visitedSymptoms = new ArrayList<>();

		for (int i = 0; i < symptoms.size(); i++) {
			String symptom = symptoms.get(i);

			if (!visitedSymptoms.contains(symptom)) {
				int count = 0;

				for (int j = 0; j < symptoms.size(); j++) {
					if (symptom.equals(symptoms.get(j))) {
						count++;
					}
				}
				visitedSymptoms.add(symptom);
				symptomsMap.put(symptom, count);
			}
		}

		return symptomsMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms (Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}

}
