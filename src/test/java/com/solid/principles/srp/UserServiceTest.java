package com.solid.principles.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userValidator = new UserValidator();
        userService = new UserService(userRepository, userValidator);
    }

    @Test
    void createUser_ValidUser_ReturnsTrue() {
        assertTrue(userService.createUser("1", "John Doe", "john@example.com"));
        assertTrue(userRepository.exists("1"));
    }

    @Test
    void createUser_InvalidEmail_ReturnsFalse() {
        assertFalse(userService.createUser("1", "John Doe", "invalid-email"));
        assertFalse(userRepository.exists("1"));
    }

    @Test
    void createUser_InvalidName_ReturnsFalse() {
        assertFalse(userService.createUser("1", "", "john@example.com"));
        assertFalse(userRepository.exists("1"));
    }

    @Test
    void createUser_DuplicateId_ReturnsFalse() {
        assertTrue(userService.createUser("1", "John Doe", "john@example.com"));
        assertFalse(userService.createUser("1", "Jane Doe", "jane@example.com"));
    }

    @Test
    void updateUser_ValidUser_ReturnsTrue() {
        userService.createUser("1", "John Doe", "john@example.com");
        assertTrue(userService.updateUser("1", "John Smith", "john.smith@example.com"));
        
        var updatedUser = userRepository.findById("1").orElseThrow();
        assertEquals("John Smith", updatedUser.getName());
        assertEquals("john.smith@example.com", updatedUser.getEmail());
    }

    @Test
    void updateUser_NonexistentUser_ReturnsFalse() {
        assertFalse(userService.updateUser("1", "John Smith", "john@example.com"));
    }
} 