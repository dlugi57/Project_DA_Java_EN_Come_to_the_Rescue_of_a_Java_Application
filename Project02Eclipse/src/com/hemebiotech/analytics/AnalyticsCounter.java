package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private static String readerFilePath = "symptoms.txt";
	private static String writerFilePath = "result.out";

	public static void main(String args[]) {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(readerFilePath);
		List<String> symptomList =  reader.GetSymptoms();

		SymptomParser symptomsPars = new SymptomParser();
		Map<String, Integer> symptomsMap = symptomsPars.createOrderedList(symptomList);

		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(writerFilePath);
		writer.WriteSymptoms(symptomsMap);
	}
}
