package com.payrollsystem.project;

import org.springframework.stereotype.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@SpringBootApplication(scanBasePackages = "com.payrollsystem.project")
public class PayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}
}
