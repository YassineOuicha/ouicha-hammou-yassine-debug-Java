package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptoms and their occurrences to an output file.
 */

public interface ISymptomWriter {
    /**
     * @param symptoms A map containing symptoms as keys and occurrences as values
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
