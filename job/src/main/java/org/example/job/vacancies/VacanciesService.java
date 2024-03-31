package org.example.job.vacancies;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacanciesService {
    @Value("${currency}")
    private String currency;
    private final CompanyRepository companyRepository;

    public void createCompany(@NonNull String name) {
        companyRepository.add(new Company(name));
    }

    public Company findCompanyByName(String name) {
        return companyRepository.findCompanyByName(name);
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String position,
                              @NonNull String description,
                              int salary) {
        Company company = this.findCompanyByName(companyName);
        company.getVacancies().add(new Vacancy(position, description, salary, currency));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getAll();
    }

    public List<Vacancy> getAllVacanciesByCompany(String companyName) {
        return this.findCompanyByName(companyName).getVacancies().stream().toList();
    }

    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
