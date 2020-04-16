package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SymptomParser {

    private TreeMap<String, Integer> symptomsMap;

    public SymptomParser() {
        this.symptomsMap = new TreeMap<>();
    }

    public TreeMap<String, Integer> createOrderedList(List<String> symptoms) {

        if (symptoms.isEmpty()) {
            throw new IllegalStateException("List of symptoms is empty!");
        }

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
