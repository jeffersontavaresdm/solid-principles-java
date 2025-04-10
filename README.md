# SOLID Principles in Java

This project demonstrates the SOLID principles of object-oriented design with practical examples and unit tests.

## SOLID Principles

### 1. Single Responsibility Principle (SRP)
- A class should have only one reason to change
- Each class should be responsible for a single part of the functionality
- Example: `UserService` class handles only user-related operations

### 2. Open/Closed Principle (OCP)
- Software entities should be open for extension but closed for modification
- Extend functionality by adding new code rather than changing existing code
- Example: Shape hierarchy with area calculations

### 3. Liskov Substitution Principle (LSP)
- Objects of a superclass should be replaceable with objects of its subclasses without breaking the application
- Subtypes must be substitutable for their base types
- Example: Bird hierarchy demonstrating proper inheritance

### 4. Interface Segregation Principle (ISP)
- Clients should not be forced to depend on interfaces they do not use
- Many client-specific interfaces are better than one general-purpose interface
- Example: Worker interfaces split into specific responsibilities

### 5. Dependency Inversion Principle (DIP)
- High-level modules should not depend on low-level modules; both should depend on abstractions
- Abstractions should not depend on details; details should depend on abstractions
- Example: Notification system with different implementations

## Project Structure

```
src/
├── main/java/com/solid/principles/
│   ├── srp/       # Single Responsibility Principle examples
│   ├── ocp/       # Open/Closed Principle examples
│   ├── lsp/       # Liskov Substitution Principle examples
│   ├── isp/       # Interface Segregation Principle examples
│   └── dip/       # Dependency Inversion Principle examples
└── test/java/com/solid/principles/
    ├── srp/       # SRP tests
    ├── ocp/       # OCP tests
    ├── lsp/       # LSP tests
    ├── isp/       # ISP tests
    └── dip/       # DIP tests
```

## Running Tests

To run the tests, use Maven:

```bash
mvn test
``` 