package se.lexicon.my_recipe_database.data;
import org.springframework.stereotype.Repository;
import se.lexicon.my_recipe_database.model.Ingredient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;


@Repository
public class IngredientDAORepository implements IngredientDAO{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Collection<Ingredient> findByName(String ingredientName) {

        return entityManager.createQuery
                 ("SELECT i FROM Ingredient i WHERE i.ingredientName = :ingredientName",
                 Ingredient.class)
                .setParameter("ingredientName", ingredientName).getResultList();

    }

    @Override
    @Transactional
    public Collection<Ingredient> findIngredientByNameContain(String name) {

        return entityManager.createQuery
                ("SELECT i FROM Ingredient i WHERE UPPER(i.ingredientName) LIKE UPPER(CONCAT('%', :ingredientName, '%') )",
                Ingredient.class)
                .setParameter("ingredientName", name).getResultList();
    }

    @Override
    @Transactional
    public Ingredient persist(Ingredient ingredient) {

       entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient findById(int id) {
        return entityManager.find(Ingredient.class,id);
    }

    @Override
    @Transactional
    public Collection<Ingredient> findAll() {

        Query query= entityManager.createQuery("SELECT i FROM Ingredient i");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void delete(Ingredient ingredient) {
    entityManager.remove(ingredient);
    }
}
