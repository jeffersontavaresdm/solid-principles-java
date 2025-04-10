package com.solid.principles.dip;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<NotificationService> services;

    public NotificationManager() {
        this.services = new ArrayList<>();
    }

    public void addNotificationService(NotificationService service) {
        services.add(service);
    }

    public void sendNotification(String message) {
        boolean sent = false;
        for (NotificationService service : services) {
            if (service.isServiceAvailable()) {
                service.sendNotification(message);
                sent = true;
                break;
            }
        }
        if (!sent) {
            throw new IllegalStateException("No notification service available");
        }
    }

    public int getAvailableServicesCount() {
        return (int) services.stream()
                .filter(NotificationService::isServiceAvailable)
                .count();
    }
} 