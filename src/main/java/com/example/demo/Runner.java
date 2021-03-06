package com.example.demo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(getClass());

	private final HelloService helloService;
	private final TodoJpaRepository todoRepository;

	@Override
	public void run(String... args) {
		helloService.greet();

		LocalDate nextWeek = LocalDate.now().plus(7, ChronoUnit.DAYS);

		todoRepository
				.save(Todo.builder().title("Shop").description("Go shopping ahead of trip").dueDate(nextWeek).build());
		todoRepository.save(
				Todo.builder().title("Pack").description("Be sure to pack your things").dueDate(nextWeek).build());
		todoRepository
				.save(Todo.builder().title("Drive").description("Drive to the airport").dueDate(nextWeek).build());
		todoRepository.save(Todo.builder().title("Fly").description("Fly to some mysterious destination")
				.dueDate(nextWeek).build());
		logger.debug("exiting run method...");
	}

	public Runner(HelloService helloService, TodoJpaRepository todoRepository) {
		this.helloService = helloService;
		this.todoRepository = todoRepository;
		logger.debug("exiting constructor method...");
	}

}
