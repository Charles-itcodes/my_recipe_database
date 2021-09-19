package se.lexicon.my_recipe_database.data;
import se.lexicon.my_recipe_database.model.Recipe;
import java.util.Collection;

public interface RecipeDAO {

    Collection<Recipe> findByNameContainsIgnoreCase(String name);

    Collection<Recipe> findAllContainsIngredientName (String ingredientName);

    Collection<Recipe> findAll (String recipeCategory);

    Collection<Recipe> findAllContainsRecipeCategory(String recipeCategory);

}
