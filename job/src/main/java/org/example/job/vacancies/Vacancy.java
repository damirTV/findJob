package org.example.job.vacancies;

import lombok.Data;

@Data
public class Vacancy {
    private final String position;
    private final String description;
    private final int salary;
    private final String currency;
}
