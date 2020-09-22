package com.marketo.conversions.csvtojson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvToJson {

	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		
		 	File input = new File(System.getProperty("user.dir")+"//src//main//resources//input//Marketo-demo-data.csv");
	        File output = new File(System.getProperty("user.dir")+"//src//main//resources//input//output.json");
	 
	        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
	        CsvMapper csvMapper = new CsvMapper();
	 
	        // Read data from CSV file
	        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
	 
	        ObjectMapper mapper = new ObjectMapper();
	 
	        // Write JSON formated data to output.json file
	        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
	 
	        // Write JSON formated data to stdout
	        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
	}
}
