package com.restaurant.model;

import java.util.Date;

public class Voice extends AbstractBaseEntity{
    private User user;
    private Restaurant restaurant;
    private Date date;

    public Voice() {
    }

    public Voice(Integer id, User user, Restaurant restaurant, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
