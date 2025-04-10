package com.solid.principles.dip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    private NotificationManager manager;
    private EmailService emailService;
    private SMSService smsService;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        manager = new NotificationManager();
        emailService = new EmailService();
        smsService = new SMSService();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void sendNotification_WithEmailService_SendsEmail() {
        manager.addNotificationService(emailService);
        manager.sendNotification("Test message");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending email: Test message"));
    }

    @Test
    void sendNotification_WithSMSService_SendsSMS() {
        manager.addNotificationService(smsService);
        manager.sendNotification("Test message");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending SMS: Test message"));
    }

    @Test
    void sendNotification_NoAvailableServices_ThrowsException() {
        emailService.setServiceAvailable(false);
        smsService.setServiceAvailable(false);
        manager.addNotificationService(emailService);
        manager.addNotificationService(smsService);

        assertThrows(IllegalStateException.class, () -> 
            manager.sendNotification("Test message")
        );
    }

    @Test
    void sendNotification_FirstServiceUnavailable_UseSecondService() {
        emailService.setServiceAvailable(false);
        manager.addNotificationService(emailService);
        manager.addNotificationService(smsService);

        manager.sendNotification("Test message");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending SMS: Test message"));
        assertFalse(output.contains("Sending email: Test message"));
    }

    @Test
    void getAvailableServicesCount_ReturnsCorrectCount() {
        manager.addNotificationService(emailService);
        manager.addNotificationService(smsService);
        assertEquals(2, manager.getAvailableServicesCount());

        emailService.setServiceAvailable(false);
        assertEquals(1, manager.getAvailableServicesCount());

        smsService.setServiceAvailable(false);
        assertEquals(0, manager.getAvailableServicesCount());
    }

    @Test
    void serviceAvailability_CanBeToggled() {
        assertTrue(emailService.isServiceAvailable());
        emailService.setServiceAvailable(false);
        assertFalse(emailService.isServiceAvailable());
        emailService.setServiceAvailable(true);
        assertTrue(emailService.isServiceAvailable());
    }
} 