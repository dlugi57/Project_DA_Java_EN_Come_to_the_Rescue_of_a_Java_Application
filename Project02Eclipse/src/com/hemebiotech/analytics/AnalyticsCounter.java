package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	private static String filePath = "symptoms.txt";

	public static void main(String args[]) throws Exception {


		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(filePath);
		List<String> symptomList = reader.GetSymptoms();

		SymptomParser symptoms = new SymptomParser(symptomList);


		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
