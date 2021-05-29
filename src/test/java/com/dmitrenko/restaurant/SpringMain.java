package com.dmitrenko.restaurant;

import com.dmitrenko.restaurant.model.Role;
import com.dmitrenko.restaurant.model.User;
import com.dmitrenko.restaurant.web.user.AdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static com.dmitrenko.restaurant.Profiles.REPOSITORY_IMPLEMENTATION;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[]{"spring/spring-app.xml", "spring/spring-db.xml"}, false)) {
            appCtx.getEnvironment().setActiveProfiles(REPOSITORY_IMPLEMENTATION);
            appCtx.refresh();
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));
        }
    }
}
