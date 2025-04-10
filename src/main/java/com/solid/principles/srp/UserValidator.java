package com.solid.principles.srp;

public class UserValidator {
    public boolean validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean validateName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }
} 