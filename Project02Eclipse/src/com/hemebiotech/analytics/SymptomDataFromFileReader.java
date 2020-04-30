package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class SymptomDataFromFileReader implements ISymptomReader {
    //filepath of the symptoms list
    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public SymptomDataFromFileReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        //check if filepath exist
        if (filepath != null) {
            //initialize reader
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            try {
                String line = reader.readLine();
                //loop threw every symptoms lines
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                      reader.close();
                e.printStackTrace();
            }
        }
        return result;
    }

}
