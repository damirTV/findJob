package org.example.job.vacancies;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class CompanyRepository {
    private final Map<String, Company> companies = new LinkedHashMap<>();

    protected void add(Company company) {
        companies.put(company.getName(), company);
    }

    protected List<Company> getAll() {
        return new ArrayList<>(companies.values());
    }

    protected Company findCompanyByName(String name) {
        return companies.get(name);
    }

    protected void deleteAll() {
        companies.clear();
    }
}
