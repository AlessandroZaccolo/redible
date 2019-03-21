package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Stores meals in a database
 */
@Repository
public class MealRepositoryJdbc {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MealRepositoryJdbc() {
        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    

}