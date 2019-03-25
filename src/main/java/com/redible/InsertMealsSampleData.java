package com.redible;

import com.redible.repository.DataSourceUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertMealsSampleData {


    public static void main(String[] args) throws SQLException {

        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        Connection connection = dataSource.getConnection();
        ScriptUtils.executeSqlScript(connection,
                new ClassPathResource("sql-scripts/sample-data.sql"));
    }
}
