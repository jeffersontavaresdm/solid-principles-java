package com.solid.principles.isp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    @Test
    void worker_ImplementsOnlyWorkable() {
        Worker worker = new Worker("John");
        assertTrue(worker instanceof Workable);
        assertFalse(worker instanceof Manageable);
        assertFalse(worker instanceof Maintainable);
    }

    @Test
    void supervisor_ImplementsWorkableAndManageable() {
        Supervisor supervisor = new Supervisor("Mike");
        assertTrue(supervisor instanceof Workable);
        assertTrue(supervisor instanceof Manageable);
        assertFalse(supervisor instanceof Maintainable);
    }

    @Test
    void maintenanceWorker_ImplementsWorkableAndMaintainable() {
        MaintenanceWorker maintenanceWorker = new MaintenanceWorker("Bob");
        assertTrue(maintenanceWorker instanceof Workable);
        assertTrue(maintenanceWorker instanceof Maintainable);
        assertFalse(maintenanceWorker instanceof Manageable);
    }

    @Test
    void worker_WorkAndBreak_PrintsCorrectMessages() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Worker worker = new Worker("John");
        worker.work();
        worker.takeBreak();

        String output = outputStream.toString();
        assertTrue(output.contains("John is working"));
        assertTrue(output.contains("John is taking a break"));
    }

    @Test
    void supervisor_AllActions_PrintsCorrectMessages() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Supervisor supervisor = new Supervisor("Mike");
        supervisor.work();
        supervisor.takeBreak();
        supervisor.supervise();
        supervisor.evaluatePerformance();

        String output = outputStream.toString();
        assertTrue(output.contains("Mike is working on management tasks"));
        assertTrue(output.contains("Mike is taking a break"));
        assertTrue(output.contains("Mike is supervising workers"));
        assertTrue(output.contains("Mike is evaluating performance"));
    }

    @Test
    void maintenanceWorker_AllActions_PrintsCorrectMessages() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MaintenanceWorker worker = new MaintenanceWorker("Bob");
        worker.work();
        worker.takeBreak();
        worker.maintain();
        worker.checkSafety();

        String output = outputStream.toString();
        assertTrue(output.contains("Bob is working on maintenance tasks"));
        assertTrue(output.contains("Bob is taking a break"));
        assertTrue(output.contains("Bob is performing maintenance"));
        assertTrue(output.contains("Bob is checking safety measures"));
    }
} 