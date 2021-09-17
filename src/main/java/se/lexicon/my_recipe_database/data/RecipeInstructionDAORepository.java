package se.lexicon.my_recipe_database.data;

import org.springframework.stereotype.Repository;
import se.lexicon.my_recipe_database.model.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeInstructionDAORepository implements RecipeInstructionDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction findById(String id) {
        return entityManager.find(RecipeInstruction.class,id);
    }

    @Override
    @Transactional
    public Collection<RecipeInstruction> findAll() {
        Query query=entityManager.createQuery("SELECT rec FROM RecipeInstruction rec");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional
    public void delete(RecipeInstruction recipeInstruction) {
        entityManager.remove(recipeInstruction);

    }
}
