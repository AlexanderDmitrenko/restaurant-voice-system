package com.dmitrenko.restaurant.repository.datajpa;

import com.dmitrenko.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

}
