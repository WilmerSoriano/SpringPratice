import javax.sql.DataSource;
/*
    This is how we are going to interact with SQL.
    Why do we need a templet?
    Since JDBC already handles connection, templet allowes us to create
    specefic query that are used reptative with Java.
    While JPA already handles simple java Query, this templet format 
    gives us coder more flexiblity in what we want a complex query 
    in quick code.
*/
@Configuration
public class databaseConfig {

    @Bean
    public JdbcTemplet jdbcTemplate(final DataSource dataSource){
        return new JdbcTemplate(dataSource)
    }
}
