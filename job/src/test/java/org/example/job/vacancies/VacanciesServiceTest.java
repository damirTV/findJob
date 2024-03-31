package org.example.job.vacancies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class VacanciesServiceTest {
    @Autowired
    private VacanciesService vacanciesService;

    @BeforeEach
    void init() {
        vacanciesService.deleteAll();
    }

    @Test
    @DisplayName("Успешное создание новой компании")
    void createCompanySuccess() {
        vacanciesService.createCompany("test");
        Assertions.assertEquals("test", vacanciesService.findCompanyByName("test").getName());
        Assertions.assertEquals(1, vacanciesService.getAllCompanies().size());
    }

    @Test
    @DisplayName("Успешное добавление новой вакансии")
    void createVacancySuccess() {
        vacanciesService.createCompany("test");
        vacanciesService.createVacancy("test",
                "manager", "Work is hard", 100);
        List<Vacancy> vacancies = vacanciesService.getAllVacanciesByCompany("test");
        Assertions.assertEquals(vacancies.size(), 1);
        Assertions.assertEquals(vacancies.get(0).getPosition(), "manager");
    }
}
