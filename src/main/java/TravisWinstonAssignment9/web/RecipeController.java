package TravisWinstonAssignment9.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import TravisWinstonAssignment9.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	public RecipeController (RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/all-recipes")
	public List<String> getAllRecipes() {	
		return recipeService.getAllRecipes();
	}
	
	@GetMapping("/gluten-free")
	public List<String> getGlutenFree() {
		return recipeService.getGlutenFree();
	}
	
	@GetMapping("/vegan")
	public List<String> getVegan() {
		return recipeService.getVegan();
	}
	@GetMapping("/vegan-and-gluten-free")
	public List<String> getVeganAndGlutenFree() {
		return recipeService.getVeganAndGlutenFreee();
	}
	
	@GetMapping("/vegetarian")
	public List<String> getVegetarian() {
		return recipeService.getVegetarian();
	}

	
}
