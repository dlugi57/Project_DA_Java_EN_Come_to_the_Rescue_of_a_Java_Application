package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void WriteSymptoms() {
        try{
            FileWriter writer = new FileWriter(filepath);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
