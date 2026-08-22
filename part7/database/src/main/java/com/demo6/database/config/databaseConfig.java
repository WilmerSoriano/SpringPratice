package com.demo6.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
/*
    This is how we are going to interact with SQL.
    Why do we need a templet?
    Since JDBC already handles connection, templet allowes us to create
    specefic query that are used reptative with Java.
    While JPA already handles simple java Query, this templet format 
    gives us coder more flexiblity in what we want as a complex query 
    in quick code.
*/


/*
The section below is simplie a jdbc template bean so it can be injected
and reused throughout our application
*/

@Configuration
public class databaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
