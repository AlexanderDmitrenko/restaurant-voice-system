package com.dmitrenko.restaurant.model;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

public class User extends AbstractBaseEntity{
    private String name;
    private String email;
    private String password;
    private LocalDate registered;
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String email, String password,Role role, Role... roles) {
        this(id, name, email, password, LocalDate.now(), EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, LocalDate registered, Set<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", roles=" + roles +
                '}';
    }
}
