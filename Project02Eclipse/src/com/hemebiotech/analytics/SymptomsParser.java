package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Parse unordered list of symptoms
 */
public class SymptomsParser {
    //to order symptoms and store theirs occurrences
    private TreeMap<String, Integer> symptomsMap;

    public SymptomsParser() {
        this.symptomsMap = new TreeMap<>();
    }

    /**
     * @param symptoms unordered list of symptoms
     * @return sorted symptomsMap list of : key - symptom, value - occurrences
     */
    public TreeMap<String, Integer> createOrderedList(List<String> symptoms) {

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
