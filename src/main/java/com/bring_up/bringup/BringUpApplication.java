package com.bring_up.bringup;

import com.bring_up.bringup.company.jwt.filter.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackageClasses = { JwtAuthenticationFilter.class })

public class BringUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BringUpApplication.class, args);
	}

}
