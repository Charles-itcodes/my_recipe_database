package se.lexicon.my_recipe_database.data;

import se.lexicon.my_recipe_database.model.Ingredient;
import se.lexicon.my_recipe_database.model.Recipe;
import se.lexicon.my_recipe_database.model.RecipeIngredient;

import java.util.Collection;

public interface IngredientDAO {

    Collection<Ingredient>  findByName (String ingredientName);

    Collection<Ingredient> findIngredientByNameContain(String name);

//CRUD

    Ingredient persist (Ingredient ingredient);
    Ingredient findById(int id);
    Collection<Ingredient> findAll();
    Ingredient update(Ingredient ingredient);
    void delete(Ingredient ingredient);
}
