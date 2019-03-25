package com.redible.repository;

import com.redible.model.Meal;
import com.redible.model.MealSearch;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Stores meals in a database
 */
@Repository
public class MealRepositoryJdbc {

    private JdbcTemplate jdbcTemplate;


    public MealRepositoryJdbc() {
        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void add(Meal meal){
        jdbcTemplate.update("insert into meals (name, quantity, price)" +
                " values ('" + meal.getName() + "','"
                + meal.getQuantity() + "','"+ meal.getPrice()+"')");
    }

    public void update(Meal meal){

        String sql = "update meals set " +
                "name = '" + meal.getName() + "', " +
                "quantity = '" + meal.getQuantity() + "', " +
                "price = " + meal.getPrice() + " " +
                "where id = " + meal.getId();

        //System.out.println("SQL: " + sql);
        jdbcTemplate.update(sql);
    }



    public Meal getById(long id){
        return jdbcTemplate.queryForObject("select * from meals where id = " + id,
                (rs1, rowNum) -> getMeal(rs1));
    }


    private Meal getMeal(ResultSet rs) throws SQLException{

        long id = rs.getLong("id");
        String name = rs.getString("name");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");

        Meal meal = new Meal(name, price, quantity);
        meal.setId(id);

        return meal;
    }

    public Collection<Meal> getAllMeals(){

        return jdbcTemplate.query("select * from meals",
                (rs1, rowNum) -> getMeal(rs1));
    }


    public Collection<Meal> find(MealSearch mealSearch) {

        String sql = "select * from meals";

        sql += "where name = '"+ mealSearch.name + "'";

        return jdbcTemplate.query(sql, (rs1, rowNum) -> getMeal(rs1) );

    }
}