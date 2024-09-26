package com.thigas.quack.application.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

	private final FakerService fakerService;

	public DataInitializer(FakerService fakerService) {
		this.fakerService = fakerService;
	}

	@Override
	public void run(String... args) throws Exception {
		fakerService.generateAllFakeData(10);
	}
}
