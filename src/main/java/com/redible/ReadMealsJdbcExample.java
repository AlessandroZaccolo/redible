package com.redible;

import com.redible.repository.DataSourceUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadMealsJdbcExample {


    public static void main(String... args) throws SQLException {

        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from meals");


        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");

            System.out.println(id + ", Dish: " + name + ", Qty: " + quantity + ", Price: " + price);
        }



        rs.close();
        statement.close();
        connection.close();
    }
}
