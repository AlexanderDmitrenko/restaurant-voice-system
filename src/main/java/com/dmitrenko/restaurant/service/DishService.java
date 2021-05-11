package com.dmitrenko.restaurant.service;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.dmitrenko.restaurant.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish create(Dish dish) {
        Objects.requireNonNull(dish, "dish must not be null");
        return repository.save(dish);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Dish get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Dish> getAll() {
        return repository.getAll();
    }

    public void update(Dish dish) {
        Objects.requireNonNull(dish, "dish must not be null");
        checkNotFoundWithId(repository.save(dish), dish.getId());
    }
}
