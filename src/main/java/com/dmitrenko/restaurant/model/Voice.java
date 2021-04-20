package com.dmitrenko.restaurant.model;

import java.time.LocalDate;

public class Voice extends AbstractBaseEntity{
    private User user;
    private Restaurant restaurant;
    private LocalDate date;

    public Voice() {
    }

    public Voice(Integer id, User user, Restaurant restaurant, LocalDate date) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
