package se.lexicon.my_recipe_database.data;

import se.lexicon.my_recipe_database.model.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO {

//CRUD

    RecipeIngredient persist (RecipeIngredient recipeIngredient);
    RecipeIngredient findById(String id);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    void delete(RecipeIngredient recipeIngredient);
}
