package org.example.job;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.job.resumes.Resume;
import org.example.job.resumes.ResumesServices;
import org.example.job.vacancies.VacanciesService;
import org.example.job.vacancies.Vacancy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class JobFindService {
    private final VacanciesService vacanciesService;
    protected final ResumesServices resumesServices;

    public void createCompany(@NonNull String name) {
        vacanciesService.createCompany(name);
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String position,
                              @NonNull String description,
                              int salary) {
        vacanciesService.createVacancy(companyName, position, description, salary);
    }

    public List<Vacancy> getAllVacanciesByCompany(@NonNull String companyName) {
        return vacanciesService.getAllVacanciesByCompany(companyName);
    }

    public void createUser(@NonNull String name, @NonNull String email) {
        resumesServices.createUser(name, email);
    }

    public void createResume(@NonNull String userName, int salary, @NonNull String skills) {
        resumesServices.createResume(userName, salary, skills);
    }

    public List<Resume> getAllResume() {
        return resumesServices.getAllResume();
    }

    public void deleteAll() {
        vacanciesService.deleteAll();
        resumesServices.deleteAll();
    }
}
