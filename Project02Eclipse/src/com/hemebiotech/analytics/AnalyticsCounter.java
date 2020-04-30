package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dlugosz Piotr
 * @version 0.0.1
 */
public class AnalyticsCounter {

    private static final Logger logger = Logger.getLogger(SymptomDataToFileWriter.class.getName());

    //init of input and output file paths
    private static final String readerFilePath = "symptoms.txt";
    private static final String writerFilePath = "result.out";

    public static void main(String[] args) {
        try {
            ISymptomReader reader = new SymptomDataFromFileReader(readerFilePath);
            List<String> symptomList = reader.getSymptoms();

            SymptomsParser symptomsPars = new SymptomsParser();
            Map<String, Integer> symptomsMap = symptomsPars.createOrderedList(symptomList);

            ISymptomWriter writer = new SymptomDataToFileWriter(writerFilePath);
            writer.writeSymptoms(symptomsMap);
        } catch (IOException | IllegalStateException e) {
            logger.log(Level.WARNING, "AnalyticsCounter found an error: " + e);
        }
    }
}
