package org.example.job.resumes;

import lombok.Data;

@Data
public class User {
    private final String name;
    private final String email;
    private Resume resume;

}
