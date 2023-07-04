package com.martins.helina.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.martins.helina.util.DBService;

@Configuration
@Profile("local")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	
}
