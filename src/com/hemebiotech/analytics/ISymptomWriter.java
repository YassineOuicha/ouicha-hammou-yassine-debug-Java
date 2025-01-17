package com.hemebiotech.analytics;

import java.util.Map;

/**
 *
 * The return value from the operation is a collection of key-values ( symptoms, occurrences)
 *
 */

public interface ISymptomWriter {
    /**
     * If no data is available, return an empty List
     *
     * @return a collection of unique Symptoms obtained from a data source, with the associated occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
