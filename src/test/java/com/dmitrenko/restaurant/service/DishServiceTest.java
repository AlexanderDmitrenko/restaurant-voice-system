package com.dmitrenko.restaurant.service;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.dmitrenko.restaurant.DishTestData.*;
import static org.junit.Assert.*;

//TODO переделать с помощью AssertJ как в учебном проекте

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:/db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DishServiceTest {


    @Autowired
    private DishService service;

    @Test
    public void create() {
        Dish expected = getNew();
        Dish actual = service.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        service.delete(DISH1_ID);
        assertThrows(NotFoundException.class, () -> service.get(DISH1_ID));
    }

    @Test
    public void get() {
        Dish actual = service.get(DISH1_ID);
        assertEquals(dish_1, actual);
    }

    @Test
    public void getAll() {
        List<Dish> dishes = service.getAll();
        assertArrayEquals(new Dish[]{dish_1, dish_2, dish_3}, dishes.toArray());
    }

    @Test
    public void update() {
        service.update(getUpdated());
        assertEquals(service.get(DISH1_ID), getUpdated());
    }
}