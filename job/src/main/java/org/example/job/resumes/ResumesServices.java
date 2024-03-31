package org.example.job.resumes;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ResumesServices {
    private final UserRepository userRepository;

    public void createUser(@NonNull String name, @NonNull String email) {
        userRepository.add(new User(name, email));
    }

    public User findUserByName(@NonNull String name) {
        return userRepository.findUserByName(name);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public void createResume(@NonNull String userName, int salary, @NonNull String skills) {
        User user = this.findUserByName(userName);
        user.setResume(new Resume(salary, skills));
    }

    public Resume getResumeByUser(@NonNull String userName) {
        return this.findUserByName(userName).getResume();
    }

    public List<Resume> getAllResume() {
        return this.getAllUsers()
                .stream()
                .map(User::getResume)
                .filter(Objects::nonNull)
                .toList();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
