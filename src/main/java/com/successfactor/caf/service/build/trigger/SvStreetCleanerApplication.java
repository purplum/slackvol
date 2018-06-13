package com.successfactor.caf.service.build.trigger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SvStreetCleanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvStreetCleanerApplication.class, args);
	}
}
