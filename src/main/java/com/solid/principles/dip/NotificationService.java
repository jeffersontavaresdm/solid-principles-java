package com.solid.principles.dip;

public interface NotificationService {
    void sendNotification(String message);
    boolean isServiceAvailable();
} 