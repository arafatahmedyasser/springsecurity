package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMysqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}

	@Autowired
	UserRepository userRep;
	
	@Override
	public void run(String... args) throws Exception {
	
		userRep.findAll().stream().forEach(System.out::println);
		
		userRep.findById(2L).ifPresent(System.out::println);
		
		userRep.findByNameIgnoreCase("Arafat").stream().forEach(System.out::println);;
	}
}
