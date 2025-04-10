package com.solid.principles.lsp;

public abstract class FlyingBird extends Bird {
    public FlyingBird(String name) {
        super(name);
    }

    public abstract double getFlightSpeed();
} 