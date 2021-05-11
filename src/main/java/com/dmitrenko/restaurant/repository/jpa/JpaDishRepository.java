package com.dmitrenko.restaurant.repository.jpa;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class JpaDishRepository implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Dish save(Dish dish) {
        if (dish.isNew()){
            em.persist(dish);
            return dish;
        }else {
            return em.merge(dish);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .executeUpdate() !=0;
    }

    @Override
    public Dish get(int id) {
        return em.find(Dish.class, id);
    }

    @Override
    public List<Dish> getAll() {
        return em.createNamedQuery(Dish.ALL_SORTED, Dish.class).getResultList();
    }
}
