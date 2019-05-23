package com.redible.repository;

import com.mongodb.client.FindIterable;
import com.redible.model.Meal;
import com.redible.model.MealSearch;
import org.bson.Document;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Stores meals in a database
 */

public class MealRepositoryJdbc implements MealRepository {

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
                "where id = " + meal.getMealId();

        //System.out.println("SQL: " + sql);
        jdbcTemplate.update(sql);
    }

    public void addOrUpdate(Meal meal){

    }

    public void remove(Meal meal){

    }



    public Meal getMealById(String id){
        return jdbcTemplate.queryForObject("select * from meals where id = " + id,
                (rs1, rowNum) -> getMeal(rs1));
    }


    private Meal getMeal(ResultSet rs) throws SQLException{

        String name = rs.getString("name");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");
        double discount = rs.getDouble("discount");

        Meal meal = new Meal (name, price, quantity, discount);
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
