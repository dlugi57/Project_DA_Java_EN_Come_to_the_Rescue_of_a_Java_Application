package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple implementation of file reader
 */
public class SymptomDataFromFileReader implements ISymptomReader {
    //filepath of the symptoms list
    private final String filepath;
    private static final Logger logger = Logger.getLogger(SymptomDataToFileWriter.class.getName());

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public SymptomDataFromFileReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        //initialize reader
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        try {
            String line = reader.readLine();
            //loop threw every symptoms lines
            while (line != null) {
                //check if the line is empty to prevent empty symptoms in result Array list
                if (!line.isEmpty()) {
                    result.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            reader.close();
            logger.log(Level.WARNING, "Error when reading file: " + e);
        }
        return result;
    }
}
