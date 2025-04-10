package com.solid.principles.isp;

public class Supervisor implements Workable, Manageable {
    private String name;

    public Supervisor(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working on management tasks");
    }

    @Override
    public void takeBreak() {
        System.out.println(name + " is taking a break");
    }

    @Override
    public void supervise() {
        System.out.println(name + " is supervising workers");
    }

    @Override
    public void evaluatePerformance() {
        System.out.println(name + " is evaluating performance");
    }
} 