package se.lexicon.my_recipe_database.data;

import se.lexicon.my_recipe_database.model.Ingredient;

public interface IngredientDAO {

    Ingredient findByName (String ingredientName);

    Ingredient findIngredientByName (String ingredient);
}
