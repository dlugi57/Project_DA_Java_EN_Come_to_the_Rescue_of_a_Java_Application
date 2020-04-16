package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.io.IOException;
import java.lang.IllegalStateException;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * @param filepath a full or partial path to file where the symptoms need to be write
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void WriteSymptoms(Map<String, Integer> symptoms) {

        if (symptoms.isEmpty()) {
            throw new IllegalStateException("List of symptoms is empty!");
        }

        try {
            FileWriter writer = new FileWriter(filepath);

            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                String key = symptom.getKey();
                Integer value = symptom.getValue();
                writer.write(key + " = " + value + "\n");
                System.out.println("Symptom line written: " + key + " => " + value);
            }

            System.out.println("Write process success, check file: " + filepath + " to see the ordered symptom list with occurrences");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
