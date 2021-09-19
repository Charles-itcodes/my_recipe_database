package se.lexicon.my_recipe_database.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.my_recipe_database.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class RecipeDAORepository implements RecipeDAO{


    @PersistenceContext
    private EntityManager ent;

    @Override
    @Transactional
    public Collection<Recipe> findByNameContainsIgnoreCase(String name) {
        return ent.createQuery(
                        "SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:name,'%')) " +
                                "OR " +
                                "UPPER(r.recipeName) LIKE UPPER(CONCAT('%', :name, '%')) ", Recipe.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllContainsIngredientName(String ingredientName) {
        return null;
    }

    @Override
    @Transactional
    public Collection<Recipe> findAll(String recipeCategory) {
        return ent.createQuery("SELECT r FROM Recipe r",Recipe.class).getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllContainsRecipeCategory(String recipeCategory) {
        return null;
    }
}
