package com.dmitrenko.restaurant.repository;

import com.dmitrenko.restaurant.model.Dish;

import java.util.List;

public interface DishRepository {

    // null if not found, when updated
    Dish save(Dish dish);

    // false if not found
    boolean delete(int id);

    // null if not found
    Dish get(int id);

    List<Dish> getAll();
}
