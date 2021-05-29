package com.dmitrenko.restaurant.service.datajpa;

import com.dmitrenko.restaurant.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.dmitrenko.restaurant.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractUserServiceTest {
}
