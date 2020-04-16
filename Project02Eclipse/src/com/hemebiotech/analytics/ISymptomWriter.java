package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data in a file
 * The important part is, the result from the operation, which is a file with list of strings.
 */
public interface ISymptomWriter {
    /**
     * @param symptoms the map list of ordered symptoms
     * @exception  IllegalStateException  if the list of symptoms is empty
     */
    void WriteSymptoms(Map<String, Integer> symptoms);
}
