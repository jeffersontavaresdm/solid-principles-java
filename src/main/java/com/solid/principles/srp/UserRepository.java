package com.solid.principles.srp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    public void delete(String id) {
        users.remove(id);
    }

    public boolean exists(String id) {
        return users.containsKey(id);
    }
} 