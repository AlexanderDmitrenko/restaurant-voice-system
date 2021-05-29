package com.dmitrenko.restaurant.service.jdbc;

import com.dmitrenko.restaurant.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.dmitrenko.restaurant.Profiles.JDBC;

@ActiveProfiles(JDBC)
public class JdbcUserServiceTest extends AbstractUserServiceTest {
}
