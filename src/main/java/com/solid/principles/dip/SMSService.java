package com.solid.principles.dip;

public class SMSService implements NotificationService {
    private boolean serviceAvailable;

    public SMSService() {
        this.serviceAvailable = true;
    }

    @Override
    public void sendNotification(String message) {
        if (!serviceAvailable) {
            throw new IllegalStateException("SMS service is not available");
        }
        System.out.println("Sending SMS: " + message);
    }

    @Override
    public boolean isServiceAvailable() {
        return serviceAvailable;
    }

    public void setServiceAvailable(boolean serviceAvailable) {
        this.serviceAvailable = serviceAvailable;
    }
} 