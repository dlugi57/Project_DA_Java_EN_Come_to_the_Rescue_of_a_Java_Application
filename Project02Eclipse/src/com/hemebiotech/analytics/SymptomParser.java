package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SymptomParser {

    private TreeMap<String, Integer> symptomsMap;

    public SymptomParser() {
        this.symptomsMap = new TreeMap<String, Integer>();
    }

    public TreeMap<String, Integer> createOrderedList(List<String> symptoms) {

        for(String symptom : symptoms){

            if (symptomsMap.containsKey(symptom)) {
                symptomsMap.put(symptom, symptomsMap.get(symptom)+1);
            }else{
                symptomsMap.put(symptom, 1);
            }
        };
        System.out.println(symptomsMap+ "\n\n");
        return symptomsMap;
    }


}
