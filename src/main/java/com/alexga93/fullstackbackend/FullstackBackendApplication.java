package com.alexga93.fullstackbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullstackBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// We can allow to front end access to any endpoints if we declare in the line below
				/*
				* example to allow only any service with the '/api/~' like http://localhost:4200/api/users
				* http://localhost:4200/aws/users Won't be allowed to connect
				* */

				// global configuration
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
