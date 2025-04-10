package com.solid.principles.isp;

public class MaintenanceWorker implements Workable, Maintainable {
    private String name;

    public MaintenanceWorker(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working on maintenance tasks");
    }

    @Override
    public void takeBreak() {
        System.out.println(name + " is taking a break");
    }

    @Override
    public void maintain() {
        System.out.println(name + " is performing maintenance");
    }

    @Override
    public void checkSafety() {
        System.out.println(name + " is checking safety measures");
    }
} 