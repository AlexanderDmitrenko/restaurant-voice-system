package com.dmitrenko.restaurant.web;

import com.dmitrenko.restaurant.model.Dish;

import java.time.LocalDate;

import static com.dmitrenko.restaurant.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {

    public static final int DISH1_ID = START_SEQ + 2;
    public static final int DISH2_ID = START_SEQ + 3;
    public static final int DISH3_ID = START_SEQ + 4;

    public static Dish dish_1 = new Dish(DISH1_ID,"Котлета по киевски", 150000, LocalDate.now());
    public static Dish dish_2 = new Dish(DISH2_ID, "Кролик в сметанном соусе", 30000, LocalDate.now());
    public static Dish dish_3 = new Dish(DISH3_ID, "Салат греческий", 10000, LocalDate.now());


    public static Dish getNew(){
        return new Dish("newDish", 20000, LocalDate.now());
    }

    public static Dish getUpdated(){
        Dish updated = new Dish(dish_1);
        updated.setName("New Name");
        updated.setPrice(100);

        return updated;
    }
}
