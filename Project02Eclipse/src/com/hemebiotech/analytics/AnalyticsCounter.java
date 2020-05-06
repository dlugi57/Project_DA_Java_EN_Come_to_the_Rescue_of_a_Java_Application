package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * @author Dlugosz Piotr
 * @version 0.0.1
 */
public class AnalyticsCounter {

    //init of input and output file paths
    private static final String readerFilePath = "symptoms.txt";
    private static final String writerFilePath = "result.out";

    public static void main(String[] args) {
        AnalyticsCounter ac = new AnalyticsCounter();
        List<String> symptomList = ac.readFile(readerFilePath);
        Map<String, Integer> symptomsMap = ac.parseSymptoms(symptomList);
        ac.writeFile(writerFilePath, symptomsMap);
    }

    /**
     * Read data from file
     * @param readerFilePath path for file with symptoms data
     * @return list of not ordered symptoms
     */
    public List<String> readFile(String readerFilePath) {
        ISymptomReader reader = new SymptomDataFromFileReader(readerFilePath);
        return reader.getSymptoms();
    }

    /**
     * Order symptoms and list the occurrences
     * @param symptomList not ordered list of symptoms
     * @return ordered map of symptoms with right number of occurrences
     */
    public Map<String, Integer> parseSymptoms(List<String> symptomList) {
        SymptomsParser symptomsPars = new SymptomsParser();
        return symptomsPars.createOrderedMap(symptomList);
    }

    /**
     * Write ordered map of symptoms to external file
     * @param writerFilePath path to the output data
     * @param symptomsMap ordered map of symptoms with right number of occurrences
     */
    public void writeFile(String writerFilePath, Map<String, Integer> symptomsMap) {
        ISymptomWriter writer = new SymptomDataToFileWriter(writerFilePath);
        writer.writeSymptoms(symptomsMap);
    }
}
