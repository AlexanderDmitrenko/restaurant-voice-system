package com.restaurant.model;

import java.util.Date;

public class Dish extends AbstractBaseEntity{
    private String name;
    private Integer price;
    private Date date;

    public Dish() {
    }

    public Dish(Integer id, String name, Integer price, Date date) {
        super(id);
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
