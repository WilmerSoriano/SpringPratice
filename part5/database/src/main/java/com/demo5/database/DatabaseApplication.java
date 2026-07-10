package com.demo5.database;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;
/*
	This code is only used to test if the connection is for Spring to Mysql is Good.
	DOES NOT HANDLE:
	1. creating db
	2. creating schema
	3. inserting data

	Rememeber, Spring alone (without code) can already handle that, we just provide
	the proper information.
*/
@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner{

	private final DataSource dataSource; //A Spring's object that manages connections to your database. Uses The conifguration in application.properties

	public DatabaseApplication(final DataSource dataSource){ //Injects the info
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("IT WORKED LOOK LOOK, Datasource: " + dataSource.toString());//This does not actually test the database. It only proves Spring created the DataSource object.
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource); // This is how JDBC allows us to query stuff
		restTemplate.execute("select 1"); // We are querying to test connection to DB. Expect respond: 1
	}

}