package se.lexicon.my_recipe_database.data;

import org.springframework.stereotype.Repository;
import se.lexicon.my_recipe_database.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeIngredientDAORepository implements RecipeIngredientDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeIngredient persist(RecipeIngredient recipeIngredient) {

        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient findById(String recipeIngredientId) {
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional
    public Collection<RecipeIngredient> findAll() {
        Query query=entityManager.createQuery("SELECT r FROM RecipeIngredient r");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return entityManager.merge(recipeIngredient);
    }

    @Override
    @Transactional
    public void delete(RecipeIngredient recipeIngredient) {
entityManager.remove(recipeIngredient);
    }
}
