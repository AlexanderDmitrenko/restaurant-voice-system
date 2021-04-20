package com.dmitrenko.restaurant.web.dish;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.service.DishService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.dmitrenko.restaurant.util.ValidationUtil.checkNew;
import static org.slf4j.LoggerFactory.getLogger;


@Controller
public class DishRestController {
    private static final Logger log = getLogger(DishRestController.class);

    private final DishService service;

    public DishRestController(DishService service) {
        this.service = service;
    }

    public Dish get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Dish create(Dish dish) {
        log.info("create {}", dish);
        checkNew(dish);
        return service.create(dish);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Dish dish) {
        log.info("update {}", dish);
        service.update(dish);
    }

    public List<Dish> getAll() {
        log.info("getAll");
        return service.getAll();
    }


}
