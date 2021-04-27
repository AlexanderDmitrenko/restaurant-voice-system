package com.dmitrenko.restaurant.repository.inmemory;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import com.dmitrenko.restaurant.util.DishUtils;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class InMemoryDishRepository implements DishRepository {
    private final Map<Integer, Dish> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        DishUtils.dishes.forEach(this::save);
    }

    @Override
    public Dish save(Dish dish) {
        if (dish.isNew()) {
            dish.setId(counter.incrementAndGet());
            repository.put(dish.getId(), dish);
            return dish;
        }
        // handle case: update, but not present in storage
        return repository.computeIfPresent(dish.getId(), (id, oldDish) -> dish);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Dish get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Dish> getAll() {
        return  filterByPredicate(dish -> true);
    }

    private List<Dish> filterByPredicate(Predicate<Dish> filter) {
        return repository.values().stream()
                        .filter(filter)
                        .sorted(Comparator.comparing(Dish::getDate).reversed())
                        .collect(Collectors.toList());
    }
}
