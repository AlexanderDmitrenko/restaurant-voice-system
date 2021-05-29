package com.dmitrenko.restaurant.service.jpa;

import com.dmitrenko.restaurant.service.AbstractDishServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.dmitrenko.restaurant.Profiles.JPA;

@ActiveProfiles(JPA)
public class JpaDishServiceTest extends AbstractDishServiceTest {
}
