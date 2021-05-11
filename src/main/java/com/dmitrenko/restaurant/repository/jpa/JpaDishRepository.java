package com.dmitrenko.restaurant.repository.jpa;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JpaDishRepository implements DishRepository {
    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Dish get(int id) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }
}
