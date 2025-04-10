package com.solid.principles.lsp;

public class Eagle extends FlyingBird {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Screech!";
    }

    @Override
    public double getFlightSpeed() {
        return 160.0; // km/h
    }
} 