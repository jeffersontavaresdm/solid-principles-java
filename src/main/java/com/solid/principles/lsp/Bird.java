package com.solid.principles.lsp;

public abstract class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeSound();
}