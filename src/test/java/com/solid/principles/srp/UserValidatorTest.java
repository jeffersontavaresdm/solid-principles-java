package com.solid.principles.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @Test
    void validateEmail_ValidEmail_ReturnsTrue() {
        assertTrue(validator.validateEmail("test@example.com"));
    }

    @Test
    void validateEmail_InvalidEmail_ReturnsFalse() {
        assertFalse(validator.validateEmail("invalid-email"));
        assertFalse(validator.validateEmail(""));
        assertFalse(validator.validateEmail(null));
    }

    @Test
    void validateName_ValidName_ReturnsTrue() {
        assertTrue(validator.validateName("John"));
    }

    @Test
    void validateName_InvalidName_ReturnsFalse() {
        assertFalse(validator.validateName(""));
        assertFalse(validator.validateName(null));
        assertFalse(validator.validateName("A")); // Too short
    }
} 