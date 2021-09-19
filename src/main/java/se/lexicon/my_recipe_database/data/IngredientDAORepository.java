package se.lexicon.my_recipe_database.data;
import org.springframework.stereotype.Repository;
import se.lexicon.my_recipe_database.model.Ingredient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Repository
public class IngredientDAORepository implements IngredientDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Ingredient findByName(String ingredientName) {

        return entityManager.find(Ingredient.class,ingredientName);
    }

    @Override
    @Transactional
    public Ingredient findIngredientByName(String ingredient) {
        return entityManager.find(Ingredient.class,ingredient);
    }
}
