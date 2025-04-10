package com.solid.principles.isp;

public class Worker implements Workable {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working");
    }

    @Override
    public void takeBreak() {
        System.out.println(name + " is taking a break");
    }
} 