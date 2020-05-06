package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Parse unordered list of symptoms
 */
public class SymptomsParser {

    //to order symptoms and store theirs occurrences
    private final Map<String, Integer> symptomsMap;

    public SymptomsParser() {
        //put case insensitive order option to prevent character differences
        this.symptomsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * @param symptoms unordered list of symptoms
     * @return sorted symptomsMap list of : key - symptom, value - occurrences
     */
    public Map<String, Integer> createOrderedMap(List<String> symptoms) throws IllegalStateException {

        if (symptoms.isEmpty()) {
            throw new IllegalStateException("List of symptoms is empty!");
        }
        //loop threw unordered symptoms list to find occurrences and count them
        for (String symptom : symptoms) {
            if (symptomsMap.containsKey(symptom)) {
                symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);
            } else {
                symptomsMap.put(symptom, 1);
            }
        }
        return symptomsMap;
    }
}
