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
	
	public List<Recipe> getAllRecipes() {
		List<Recipe> allRecipes = fullList.stream()
										  .toList();
		
		return allRecipes;
	}

	public List<Recipe> getGlutenFree() {
		List<Recipe> glutenFreeRecipes = fullList.stream()
												 .filter(x -> x.getGlutenFree().equals(true))
												 .toList();
		
		return glutenFreeRecipes;
	}

	public List<Recipe> getVegan() {
		List<Recipe> VeganRecipes = fullList.stream()
				 .filter(x -> x.getVegan().equals(true))
				 .toList();

		return VeganRecipes;
	}

	public List<Recipe> getVeganAndGlutenFreee() {
		List<Recipe> veganAndGlutenFreeRecipes = fullList.stream()
				 .filter(x -> x.getGlutenFree().equals(true))
				 .filter(x -> x.getVegan().equals(true))
				 .toList();

		return veganAndGlutenFreeRecipes;
	}

	public List<Recipe> getVegetarian() {
		List<Recipe> vegetarianRecipes = fullList.stream()
				 .filter(x -> x.getVegetarian().equals(true))
				 .toList();

		return vegetarianRecipes;
	}
}
