package com.restaurant.model;

import java.util.Date;
import java.util.Set;

public class Menu extends AbstractBaseEntity{
    private Restaurant restaurant;
    private Set<Dish> dishes;
    private Date date;

    public Menu() {
    }

    public Menu(Integer id, Restaurant restaurant, Set<Dish> dishes, Date date) {
        super(id);
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
