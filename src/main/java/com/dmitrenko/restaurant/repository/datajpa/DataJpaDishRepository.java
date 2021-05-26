package com.dmitrenko.restaurant.repository.datajpa;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {

    private static final Sort SORT_BY_DATE = Sort.by(Sort.Direction.DESC, "date");
    private final CrudDishRepository crudDishRepository;

    public DataJpaDishRepository(CrudDishRepository crudDishRepository) {
        this.crudDishRepository = crudDishRepository;
    }


    @Override
    public Dish save(Dish dish) {
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return crudDishRepository.delete(id) != 0;
    }

    @Override
    public Dish get(int id) {
        return crudDishRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return crudDishRepository.findAll(SORT_BY_DATE);
    }
}
