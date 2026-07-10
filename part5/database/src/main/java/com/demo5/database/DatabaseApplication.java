package com.demo5.database;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner{

	private final DataSource dataSource; //Injecting a DATA source object as seen by constructor

	public DatabaseApplication(final DataSource dataSource){
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource); // This is how JDBC allows us to query stuff
		restTemplate.execute("select 1"); // We are query
	}

}