package com.focus.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FocusAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusAssignmentApplication.class, args);
	}

}
