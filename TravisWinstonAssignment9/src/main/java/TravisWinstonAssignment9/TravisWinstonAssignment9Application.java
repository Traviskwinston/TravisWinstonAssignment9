package TravisWinstonAssignment9;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import TravisWinstonAssignment9.domain.Recipe;

@SpringBootApplication
@ComponentScan("TravisWinstonAssignment9")
public class TravisWinstonAssignment9Application {
	
	public static ArrayList<Recipe> recipeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TravisWinstonAssignment9Application.class, args);
		
		//POJO
		Recipe recipe = new Recipe();
		//Full list Organized of Recipes
		
		
		//Taking in the Lines from the File
		Reader in = new FileReader("recipes.txt");
		
		//The Format for the Apache Commons to Parse the txt/csv file
		CSVFormat csvFormat = CSVFormat	.DEFAULT
										.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", 
												"Preparation Minutes", "Price Per Serving", "Ready In Minutes", 
												"Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
										.withSkipHeaderRecord(true)
										.withIgnoreSurroundingSpaces()
										.withEscape('\\');
		
		//Parse(File_To_Parse, Format_To_Parse_With)
		CSVParser csvParser = CSVParser.parse(in, csvFormat);
		
		Iterable<CSVRecord> records = csvParser;
		//
		for (CSVRecord record : records) {
			recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
			recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
			recipe.setInstructions(record.get("Instructions"));
			recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
			recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
			recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
			recipe.setServings(Integer.parseInt(record.get("Servings")));
			recipe.setSpoonacularScore(Double.parseDouble( record.get("Spoonacular Score")));
			recipe.setTitle(record.get("Title"));
			recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
			recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
			
			recipeList.add(new Recipe(	recipe.getCookingMinutes(),recipe.getDairyFree(),recipe.getGlutenFree(),
										recipe.getInstructions(),recipe.getPreparationMinutes(),recipe.getPricePerServing(),
										recipe.getReadyInMinutes(),recipe.getServings(),recipe.getSpoonacularScore(),
										recipe.getTitle(),recipe.getVegan(),recipe.getVegetarian()));
		}
		
		
		
		
	}
	public ArrayList<Recipe> getRecipeList() {
		return(recipeList);
	}
}
