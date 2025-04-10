package com.solid.principles.lsp;

public class Sparrow extends FlyingBird {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Chirp!";
    }

    @Override
    public double getFlightSpeed() {
        return 40.0; // km/h
    }
} 