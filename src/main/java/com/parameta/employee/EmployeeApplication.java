package com.parameta.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot entry point (main class).
 * */
@SpringBootApplication
public class EmployeeApplication {

	/**
	 * The main method (entry point).
	 * @param args String[] the arguments used to execute the program.
	 * */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
