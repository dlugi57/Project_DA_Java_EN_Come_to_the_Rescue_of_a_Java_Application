package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Simple implementation of file writer
 */
public class SymptomDataToFileWriter implements ISymptomWriter {

    private static final Logger logger = Logger.getLogger(SymptomDataToFileWriter.class.getName());
    //filepath of the symptoms ordered list
    private String filepath;

    /**
     * @param filepath a full or partial path to file where the symptoms need to be write
     */
    public SymptomDataToFileWriter(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IllegalStateException, IOException {
        //check if list of symptoms is not empty
        if (symptoms.isEmpty()) {
            throw new IllegalStateException("List of symptoms is empty!");
        }
        //initialize writer
        FileWriter writer = null;

        //try to write symptoms from list to the external file
        try {
            writer = new FileWriter(filepath);

            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                String key = symptom.getKey();
                Integer value = symptom.getValue();
                writer.write(key + " = " + value + "\n");

                logger.info("Symptom line written: " + key + " => " + value);
            }

            logger.info("Write process success, check file: " + filepath + " to see the ordered symptom list with occurrences");
            writer.close();

        } catch (IOException e) {
            if (writer != null) {
                writer.close();
            }
            e.printStackTrace();
        }
    }
}
