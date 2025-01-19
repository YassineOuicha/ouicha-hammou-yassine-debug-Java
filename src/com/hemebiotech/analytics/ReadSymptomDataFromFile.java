package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ISymptomReader interface that reads symptoms from a text file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath; // Path to the file containing symptoms

	/**
	 * Constructor for the implementation of ReadSymptomDataFromFile class
	 *
	 * @param filepath The path to the file containing symptoms
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads the symptoms from the specified file and returns a list of strings (symptoms)
	 * @return A list of strings representing symptoms
	 */

	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

		} catch (IOException e) {
				e.printStackTrace();
		}

		System.out.println("Read symptoms: " + result);  // Check point to debug

		return result;
	}

}
