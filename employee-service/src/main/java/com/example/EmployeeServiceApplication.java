package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"entities"})
//@EnableJpaRepositories(basePackages = {"com.example.dept.repository", "com.example.employee.repository"})
@SpringBootApplication(scanBasePackages = {"com.example.config", "com.example.employee", "com.example.dept", "controller"})
public class EmployeeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
