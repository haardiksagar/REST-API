package com.ApiCreation.Haardik.ApiCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCreationApplication implements CommandLineRunner {
	@Autowired // This will inject the DB bean defined in the AppConfig class
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(ApiCreationApplication.class, args);
	}
	@Override
	//This is like you have two main methods, one in the class and one in the SpringApplication class.
	public void run(String... args) throws Exception {
		System.out.println(db.getData());
	}
}
