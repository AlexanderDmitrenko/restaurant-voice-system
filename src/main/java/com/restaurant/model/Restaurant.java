package com.restaurant.model;

import java.util.Set;

public class Restaurant extends AbstractBaseEntity{
    private String name;
    private Set<Menu> menus;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, Set<Menu> menus) {
        super(id);
        this.name = name;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
