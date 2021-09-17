package se.lexicon.my_recipe_database.data;

import se.lexicon.my_recipe_database.model.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {

    //CRUD

    RecipeInstruction create(RecipeInstruction recipeInstruction);
    RecipeInstruction findById(String id);
    Collection<RecipeInstruction> findAll();
    RecipeInstruction update(RecipeInstruction recipeInstruction);
    void delete(RecipeInstruction recipeInstruction);
}
