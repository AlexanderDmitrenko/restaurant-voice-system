package com.dmitrenko.restaurant.util;

import com.dmitrenko.restaurant.model.Dish;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class DishUtils {

    public static final List<Dish> dishes = Arrays.asList(
            new Dish("Жаркое", 100, LocalDate.of(2021, Month.APRIL, 16)),
            new Dish("Плов", 150, LocalDate.of(2021, Month.APRIL, 16)),
            new Dish("Котлета по киевски", 200, LocalDate.of(2021, Month.APRIL, 16))
    );
}
