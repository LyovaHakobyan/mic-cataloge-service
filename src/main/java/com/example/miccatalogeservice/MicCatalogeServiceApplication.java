package com.example.miccatalogeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MicCatalogeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicCatalogeServiceApplication.class, args);
	}

}
