package se.lexicon.my_recipe_database.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.my_recipe_database.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class RecipeDAORepository implements RecipeDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Collection<Recipe> findByNameContainsIgnoreCase(String name) {
        return entityManager.createQuery(
                        "SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:name,'%')) " ,
                         Recipe.class).setParameter("name", name).getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllContainsIngredientName(String ingredientName) {
        return null;
    }

    @Override
    @Transactional
    public Collection<Recipe> findAll(String recipeCategory) {
        return entityManager.createQuery("SELECT r FROM Recipe r",Recipe.class).getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllContainsRecipeCategory(String recipeCategory) {
        return null;
    }

    @Override
    @Transactional
    public Recipe persist(Recipe recipe) {

       entityManager.persist(recipe);

        return recipe;
    }

    @Override
    @Transactional
    public Recipe findById(int id) {
        return entityManager.find(Recipe.class,id);
    }

    @Override
    @Transactional
    public Collection<Recipe> findAll() {
        Query query= entityManager.createQuery("SELECT r FROM Recipe r");

        return query.getResultList();
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional
    public void delete(Recipe recipe) { entityManager.remove(recipe);

    }
}
