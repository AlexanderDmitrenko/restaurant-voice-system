package com.dmitrenko.restaurant.service;

import com.dmitrenko.restaurant.UserTestData;
import com.dmitrenko.restaurant.model.Role;
import com.dmitrenko.restaurant.model.User;
import com.dmitrenko.restaurant.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static com.dmitrenko.restaurant.UserTestData.*;
import static org.junit.Assert.assertThrows;

//TODO переделать с помощью AssertJ как в учебном проекте

public abstract class AbstractUserServiceTest extends AbstractServiceTest{

    @Autowired
    private UserService service;

    @Test
    public void create() {
        User newUser = getNew();
        User created = service.create(newUser);
        Integer newId = created.getId();
        newUser.setId(newId);
        assertMatch(created, newUser);
        assertMatch(service.get(newId), newUser);
    }

    @Test
    public void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                service.create(new User(null, "Duplicate", "user@gmail.com", "newPass", Role.USER)));
    }

    @Test
    public void delete() {
        service.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    public void get() {
        User user = service.get(USER_ID);
        assertMatch(UserTestData.user, user);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    public void getByEmail() {
        User user = service.getByEmail("admin@gmail.com");
        assertMatch(user, admin);
    }

    @Test
    public void getAll() {
        List<User> all = service.getAll();
        assertMatch(all, admin, user);
    }

    @Test
    public void update() {
        User updated = getUpdated();
        service.update(updated);
        assertMatch(service.get(USER_ID), updated);
    }
}