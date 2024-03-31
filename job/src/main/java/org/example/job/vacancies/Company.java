package org.example.job.vacancies;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class Company {
    private final String name;
    private final Set<Vacancy> vacancies = new HashSet<>();
}
