package com.coderscampus.assignment9.B.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.coderscampus.Assignment9B.Assignment.B.Recipe;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;



@Service
public class FileService {
	
	public List<String> readFile (String filename) throws IOException{
		return Files.readAllLines(Paths.get(filename));
	}
	
	public List<Recipe> getAllRecipes() throws IOException, CsvException {
		List<Recipe> recipes = new ArrayList<>();
		Reader in = new FileReader("recipes.txt");
		com.opencsv.CSVParser parser = new CSVParserBuilder().withQuoteChar('"').build();
		CSVReader csvReader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
		List<String[]> records = csvReader.readAll();
		for (String[] record : records) {
			Recipe recipe = new Recipe();

			System.out.println("$" + record[5]);

			recipes.add(recipe);

		}
		csvReader.close();

		return recipes;
	}
}