package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * @author Dlugosz Piotr
 * @version 0.0.1
 */
public class AnalyticsCounter {

    //init of input and output file paths
    private static String readerFilePath = "symptoms.txt";
    private static String writerFilePath = "result.out";

    public static void main(String args[]) {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(readerFilePath);
        List<String> symptomList = reader.GetSymptoms();

        SymptomsParser symptomsPars = new SymptomsParser();
        Map<String, Integer> symptomsMap = symptomsPars.createOrderedList(symptomList);

        WriteSymptomDataToFile writer = new WriteSymptomDataToFile(writerFilePath);
        writer.WriteSymptoms(symptomsMap);
    }
}
