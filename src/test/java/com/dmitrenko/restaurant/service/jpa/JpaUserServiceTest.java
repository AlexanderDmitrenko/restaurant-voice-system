package com.dmitrenko.restaurant.service.jpa;

import com.dmitrenko.restaurant.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.dmitrenko.restaurant.Profiles.JPA;

@ActiveProfiles(JPA)
public class JpaUserServiceTest extends AbstractUserServiceTest {
}
