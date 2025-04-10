# Understanding SOLID Principles with Java Examples

This project demonstrates the SOLID principles of object-oriented design through practical Java examples and tests. Each principle is illustrated with real-world scenarios and includes both implementation and tests.

## Table of Contents
- [What are SOLID Principles?](#what-are-solid-principles)
- [Project Structure](#project-structure)
- [Examples and Explanations](#examples-and-explanations)
- [Running the Tests](#running-the-tests)
- [Contributing](#contributing)

## What are SOLID Principles?

SOLID is an acronym for five design principles intended to make software designs more maintainable, flexible, and easy to understand.

### 1. Single Responsibility Principle (SRP)
> "A class should have one, and only one, reason to change."

#### Our Example: User Management System
- `UserService`: Handles user operations
- `UserValidator`: Validates user data
- `UserRepository`: Manages user persistence

This separation ensures that each class has a single responsibility:
```java
// UserService focuses only on coordinating user operations
public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    // ...
}

// UserValidator focuses only on validation
public class UserValidator {
    public boolean validateEmail(String email) { ... }
    public boolean validateName(String name) { ... }
}

// UserRepository focuses only on data persistence
public class UserRepository {
    public void save(User user) { ... }
    public Optional<User> findById(String id) { ... }
}
```

### 2. Open/Closed Principle (OCP)
> "Software entities should be open for extension, but closed for modification."

#### Our Example: Shape Area Calculator
- Base `Shape` interface
- Different shape implementations
- Area calculation without modifying existing code

```java
public interface Shape {
    double calculateArea();
}

public class Rectangle implements Shape {
    private final double width;
    private final double height;
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class Circle implements Shape {
    private final double radius;
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Adding new shapes doesn't require modifying existing code
public class AreaCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream()
                .mapToDouble(Shape::calculateArea)
                .sum();
    }
}
```

### 3. Liskov Substitution Principle (LSP)
> "Derived classes must be substitutable for their base classes."

#### Our Example: Bird Hierarchy
- Base `Bird` class with common behavior
- `FlyingBird` abstraction for flying capabilities
- Proper inheritance hierarchy preventing invalid operations

```java
public abstract class Bird {
    public abstract String makeSound();
}

public abstract class FlyingBird extends Bird {
    public abstract double getFlightSpeed();
}

// Penguin doesn't need to implement flying
public class Penguin extends Bird {
    @Override
    public String makeSound() {
        return "Squawk!";
    }
    
    public double getSwimmingSpeed() {
        return 8.0;
    }
}
```

### 4. Interface Segregation Principle (ISP)
> "Clients should not be forced to depend upon interfaces they do not use."

#### Our Example: Worker Interfaces
- Separate interfaces for different worker responsibilities
- Classes implement only the interfaces they need

```java
public interface Workable {
    void work();
    void takeBreak();
}

public interface Manageable {
    void supervise();
    void evaluatePerformance();
}

public interface Maintainable {
    void maintain();
    void checkSafety();
}

// Workers only implement what they need
public class Worker implements Workable { ... }
public class Supervisor implements Workable, Manageable { ... }
public class MaintenanceWorker implements Workable, Maintainable { ... }
```

### 5. Dependency Inversion Principle (DIP)
> "High-level modules should not depend upon low-level modules. Both should depend upon abstractions."

#### Our Example: Notification System
- Abstract `NotificationService` interface
- Multiple implementations (Email, SMS)
- High-level `NotificationManager` depending on abstraction

```java
public interface NotificationService {
    void sendNotification(String message);
    boolean isServiceAvailable();
}

public class EmailService implements NotificationService { ... }
public class SMSService implements NotificationService { ... }

// NotificationManager depends on abstraction, not concrete implementations
public class NotificationManager {
    private List<NotificationService> services;
    
    public void sendNotification(String message) {
        // Uses abstraction, not specific implementation
    }
}
```

## Project Structure
```
src/
├── main/java/com/solid/principles/
│   ├── srp/       # Single Responsibility Principle
│   ├── ocp/       # Open/Closed Principle
│   ├── lsp/       # Liskov Substitution Principle
│   ├── isp/       # Interface Segregation Principle
│   └── dip/       # Dependency Inversion Principle
└── test/
    ├── java/...   # Unit tests for each principle
    └── resources/features/  # BDD feature files
```

## Running the Tests

This project uses Maven and includes both unit tests and BDD-style tests with Cucumber.

```bash
# Run all tests
mvnd test

# Run tests for a specific principle
mvnd test -Dtest=UserServiceTest,UserValidatorTest  # SRP tests
mvnd test -Dtest=AreaCalculatorTest                 # OCP tests
mvnd test -Dtest=BirdTest                          # LSP tests
mvnd test -Dtest=WorkerTest                        # ISP tests
mvnd test -Dtest=NotificationManagerTest           # DIP tests
```

## Contributing

Feel free to contribute to this project by:
1. Adding more examples
2. Improving existing implementations
3. Adding more test cases
4. Enhancing documentation

Please ensure that any contributions follow the SOLID principles and include appropriate tests. 

#

<br>

<div align="center">
  <a  href="https://github.com/jeffersontavaresdm">
    <img width="30%" src="https://github.com/jeffersontavaresdm/jeffersontavaresdm/blob/main/images/call-me-shaq.gif" width="25"/>
  </a>
</div>