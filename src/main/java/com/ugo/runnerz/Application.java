package com.ugo.runnerz;



import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ugo.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ugo.runnerz.run.Location;
import com.ugo.runnerz.run.Run;



@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run = new Run(
//				1,
//				"First run",
//				LocalDateTime.now(),
//				LocalDateTime.now().plus(1, ChronoUnit.HOURS),
//				5,
//				Location.OUTDOOR
//			);
//			runRepository.create(run);
//		};
//	}



}
