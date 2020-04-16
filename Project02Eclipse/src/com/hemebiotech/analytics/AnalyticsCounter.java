package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {

	private static String readerFilePath = "symptoms.txt";
	private static String writerFilePath = "result.out";

	public static void main(String args[]) throws Exception {


		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(readerFilePath);
		List<String> symptomList =  reader.GetSymptoms();

		SymptomParser symptomsPars = new SymptomParser();
		Map<String, Integer> symptomsMap = symptomsPars.createOrderedList(symptomList);

		//Map<String, Integer> symptomsMap1 = new TreeMap<String,Integer>();

		System.out.println("symptomsMap");
		System.out.println(symptomsMap+ "\n\n");

		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(writerFilePath);
		writer.WriteSymptoms(symptomsMap);


		// next generate output
		//FileWriter writer = new FileWriter ("result.out");
		//writer.write("headache: " + headacheCount + "\n");
		//writer.write("rash: " + rashCount + "\n");
		//writer.write("dialated pupils: " + pupilCount + "\n");
		//writer.close();
	}
}
