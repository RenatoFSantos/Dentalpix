package com.midilabs.dentech.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.midilabs.dentech.api.config.property.DentechApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(DentechApiProperty.class)
public class DentechApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentechApiApplication.class, args);
	}

}
