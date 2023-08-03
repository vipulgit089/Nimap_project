package com.nimap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication

public class NimapApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapApplication.class, args);
		System.out.println("System Started");
	}

}
