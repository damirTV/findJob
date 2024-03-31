package org.example.job;

import org.example.job.vacancies.VacanciesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Runner.class, args);
		VacanciesService appJobService = context.getBean(VacanciesService.class);
		appJobService.createCompany("Рога и Копыта");
	}

}
