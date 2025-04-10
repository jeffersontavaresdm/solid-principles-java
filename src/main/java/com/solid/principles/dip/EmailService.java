package com.solid.principles.dip;

public class EmailService implements NotificationService {
    private boolean serviceAvailable;

    public EmailService() {
        this.serviceAvailable = true;
    }

    @Override
    public void sendNotification(String message) {
        if (!serviceAvailable) {
            throw new IllegalStateException("Email service is not available");
        }
        System.out.println("Sending email: " + message);
    }

    @Override
    public boolean isServiceAvailable() {
        return serviceAvailable;
    }

    public void setServiceAvailable(boolean serviceAvailable) {
        this.serviceAvailable = serviceAvailable;
    }
} 