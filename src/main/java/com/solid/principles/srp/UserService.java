package com.solid.principles.srp;

public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public boolean createUser(String id, String name, String email) {
        if (!userValidator.validateName(name) || !userValidator.validateEmail(email)) {
            return false;
        }

        if (userRepository.exists(id)) {
            return false;
        }

        User user = new User(id, name, email);
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(String id, String name, String email) {
        return userRepository.findById(id)
                .filter(user -> userValidator.validateName(name) && userValidator.validateEmail(email))
                .map(user -> {
                    user.setName(name);
                    user.setEmail(email);
                    userRepository.save(user);
                    return true;
                })
                .orElse(false);
    }
} 