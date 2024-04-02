package TravisWinstonAssignment9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import TravisWinstonAssignment9.TravisWinstonAssignment9Application;
import TravisWinstonAssignment9.domain.Recipe;

@Service
public class RecipeService {

	private TravisWinstonAssignment9Application assignment9= new TravisWinstonAssignment9Application();
	ArrayList<Recipe> fullList = assignment9.getRecipeList();
	
	public List<String> getAllRecipes() {
		List<String> allRecipes = fullList.stream()
										  .map(Recipe::getTitle)
										  .toList();
		
		return allRecipes;
	}

	public List<String> getGlutenFree() {
		List<String> glutenFreeRecipes = fullList.stream()
												 .filter(x -> x.getGlutenFree().equals(true))
												 .map(Recipe::getTitle)
												 .toList();
		
		return glutenFreeRecipes;
	}

	public List<String> getVegan() {
		List<String> VeganRecipes = fullList.stream()
				 .filter(x -> x.getVegan().equals(true))
				 .map(Recipe::getTitle)
				 .toList();

		return VeganRecipes;
	}

	public List<String> getVeganAndGlutenFreee() {
		List<String> veganAndGlutenFreeRecipes = fullList.stream()
				 .filter(x -> x.getGlutenFree().equals(true))
				 .filter(x -> x.getVegan().equals(true))
				 .map(Recipe::getTitle)
				 .toList();

		return veganAndGlutenFreeRecipes;
	}

	public List<String> getVegetarian() {
		List<String> vegetarianRecipes = fullList.stream()
				 .filter(x -> x.getVegetarian().equals(true))
				 .map(Recipe::getTitle)
				 .toList();

		return vegetarianRecipes;
	}
}
