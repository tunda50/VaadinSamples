package com.vib.vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaadinApplication {

	public static void main(String[] args) {
		System.out.println("==========Calling Pre");
		SpringApplication.run(VaadinApplication.class, args);
		
	}

}
