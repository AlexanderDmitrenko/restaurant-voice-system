package com.dmitrenko.restaurant.model;

import java.time.LocalDate;

public class Dish extends AbstractBaseEntity{
    private String name;
    private Integer price;
    private LocalDate date;

    public Dish() {
    }

    public Dish(Dish d){this(d.getId(), d.getName(), d.getPrice(), d.getDate());}

    public Dish(String name, Integer price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Dish(Integer id, String name, Integer price, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
