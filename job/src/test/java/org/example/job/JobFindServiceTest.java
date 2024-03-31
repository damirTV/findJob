package org.example.job;

import org.example.job.resumes.ResumesServices;
import org.example.job.vacancies.VacanciesService;
import org.example.job.vacancies.Vacancy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class JobFindServiceTest {
	@Autowired
	private JobFindService jobFindService;
	@Autowired
	private VacanciesService vacanciesService;
	@Autowired
	private ResumesServices resumesServices;

	@BeforeEach
	void init() {
		jobFindService.deleteAll();
	}

	@Test
	@DisplayName("Успешное создание новой компании")
	void createCompanySuccess() {
		jobFindService.createCompany("test");
		Assertions.assertEquals("test", vacanciesService.findCompanyByName("test").getName());
		Assertions.assertEquals(1, vacanciesService.getAllCompanies().size());
	}

	@Test
	@DisplayName("Успешное добавление новой вакансии")
	void createVacancySuccess() {
		jobFindService.createCompany("test");
		jobFindService.createVacancy("test",
				"manager", "Work is hard", 100);
		List<Vacancy> vacancies = jobFindService.getAllVacanciesByCompany("test");
		Assertions.assertEquals(vacancies.size(), 1);
		Assertions.assertEquals(vacancies.get(0).getPosition(), "manager");
	}

	@Test
	@DisplayName("Успешное создание нового пользователя")
	void createUserSuccess() {
		jobFindService.createUser("test", "test@email");
		Assertions.assertEquals(resumesServices.getAllUsers().size(), 1);
		Assertions.assertEquals(resumesServices.findUserByName("test").getName(), "test");
	}

	@Test
	@DisplayName("Успешное добавление резюме")
	void createResumeSuccess() {
		jobFindService.createUser("test", "test@email");
		jobFindService.createResume("test", 100, "Java Developer");
		Assertions.assertEquals(resumesServices.getResumeByUser("test").getSalary(), 100);
	}

	@Test
	@DisplayName("Успешное получение всех резюме")
	void getAllResumeSuccess() {
		jobFindService.createUser("test", "test@email");
		jobFindService.createUser("test2", "test2@email");
		jobFindService.createResume("test", 100, "Java Developer");
		jobFindService.createResume("test2", 200, "Java Spring Developer");
		Assertions.assertEquals(jobFindService.getAllResume().get(0).getSalary(), 100);
		Assertions.assertEquals(jobFindService.getAllResume().get(1).getSalary(), 200);
	}
}
