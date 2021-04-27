package com.dmitrenko.restaurant.repository.jdbc;

import com.dmitrenko.restaurant.model.Dish;
import com.dmitrenko.restaurant.repository.DishRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO доделать с учетом структуры проекта:
//  -учесть Menu
//  -учесть Restaurant

@Repository
public class JdbcDishRepository implements DishRepository {
    public static final BeanPropertyRowMapper ROW_MAPPER = BeanPropertyRowMapper.newInstance(Dish.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertDish;

    public JdbcDishRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insertDish = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("dishes")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Dish save(Dish dish) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", dish.getId())
                .addValue("name", dish.getName())
                .addValue("price", dish.getPrice())
                .addValue("date", dish.getDate());

        if (dish.isNew()){
            Number newKey = insertDish.executeAndReturnKey(map);
            dish.setId(newKey.intValue());
        }else if (namedParameterJdbcTemplate.update("UPDATE dishes SET name =:name, price =:price, date=:date" +
                " WHERE id=:id", map) == 0){
            return null;
        }

        return dish;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM dishes WHERE id=?", id) !=0 ;
    }

    @Override
    public Dish get(int id) {
        List<Dish> dishes = jdbcTemplate.query("SELECT * FROM dishes WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(dishes);
    }

    @Override
    public List<Dish> getAll() {
        return jdbcTemplate.query("SELECT * FROM dishes ORDER BY date DESC ", ROW_MAPPER);
    }
}
