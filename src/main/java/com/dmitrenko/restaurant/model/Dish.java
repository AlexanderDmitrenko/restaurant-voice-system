package com.dmitrenko.restaurant.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id"),
        @NamedQuery(name = Dish.ALL_SORTED, query = "SELECT d FROM Dish d ORDER BY d.date, d.name")
})
@Entity
@Table(name = "dishes")
public class Dish extends AbstractBaseEntity{

    public static final String DELETE = "Dish.delete";
    public static final String ALL_SORTED ="Dish.getAllSorted" ;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "date", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
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
