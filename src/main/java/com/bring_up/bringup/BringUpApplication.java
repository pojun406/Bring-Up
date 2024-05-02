package com.bring_up.bringup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BringUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BringUpApplication.class, args);
	}

}
