package se.lexicon.my_recipe_database.data;
import se.lexicon.my_recipe_database.model.Recipe;
import se.lexicon.my_recipe_database.model.RecipeIngredient;

import java.util.Collection;

public interface RecipeDAO {

    Collection<Recipe> findByNameContainsIgnoreCase(String name);

    Collection<Recipe> findAllContainsIngredientName (String ingredientName);

    Collection<Recipe> findAll (String recipeCategory);

    Collection<Recipe> findAllContainsRecipeCategory(String recipeCategory);


//CRUD FUNCTIONALITIES

    Recipe persist (Recipe recipe);
    Recipe findById(int id);
    Collection<Recipe> findAll();
    Recipe update(Recipe recipe);
    void delete(Recipe recipe);

}
