package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backend.db.UserRepo;

@SpringBootApplication
public class BackendApplication {

	UserRepo storageService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
