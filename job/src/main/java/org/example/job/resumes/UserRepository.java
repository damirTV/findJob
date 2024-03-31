package org.example.job.resumes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class UserRepository {
    private final Map<String, User> users = new LinkedHashMap<>();

    protected void add(User user) {
        users.put(user.getName(), user);
    }

    protected List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    protected User findUserByName(String name) {
        return users.get(name);
    }

    protected void deleteAll() {
        users.clear();
    }
}
