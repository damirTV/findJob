package org.example.job.resumes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResumeServiceTest {
    @Autowired
    private ResumesServices resumesServices;

    @BeforeEach
    void init() {
        resumesServices.deleteAll();
    }

    @Test
    @DisplayName("Успешное создание нового пользователя")
    void createUserSuccess() {
        resumesServices.createUser("test", "test@email");
        Assertions.assertEquals(resumesServices.getAllUsers().size(), 1);
        Assertions.assertEquals(resumesServices.findUserByName("test").getName(), "test");
    }

    @Test
    @DisplayName("Успешное добавление резюме")
    void createResumeSuccess() {
        resumesServices.createUser("test", "test@email");
        resumesServices.createResume("test", 100, "Java Developer");
        Assertions.assertEquals(resumesServices.getResumeByUser("test").getSalary(), 100);
    }

    @Test
    @DisplayName("Успешное получение всех резюме")
    void getAllResumeSuccess() {
        resumesServices.createUser("test", "test@email");
        resumesServices.createUser("test2", "test2@email");
        resumesServices.createResume("test", 100, "Java Developer");
        resumesServices.createResume("test2", 200, "Java Spring Developer");
        Assertions.assertEquals(resumesServices.getAllResume().get(0).getSalary(), 100);
        Assertions.assertEquals(resumesServices.getAllResume().get(1).getSalary(), 200);
    }
}
