package com.solid.principles.lsp;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Squawk!";
    }

    public double getSwimmingSpeed() {
        return 8.0; // km/h
    }
} 