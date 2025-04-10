package com.solid.principles.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {
    private AreaCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new AreaCalculator();
    }

    @Test
    void calculateTotalArea_EmptyList_ReturnsZero() {
        assertEquals(0, calculator.calculateTotalArea(Collections.emptyList()));
    }

    @Test
    void calculateTotalArea_SingleRectangle_ReturnsArea() {
        Shape rectangle = new Rectangle(5, 4);
        assertEquals(20, calculator.calculateTotalArea(Collections.singletonList(rectangle)));
    }

    @Test
    void calculateTotalArea_SingleCircle_ReturnsArea() {
        Shape circle = new Circle(3);
        assertEquals(Math.PI * 9, calculator.calculateTotalArea(Collections.singletonList(circle)));
    }

    @Test
    void calculateTotalArea_MultipleShapes_ReturnsTotalArea() {
        Shape rectangle = new Rectangle(5, 4);
        Shape circle = new Circle(3);
        
        double expectedArea = 20 + (Math.PI * 9); // Rectangle area + Circle area
        assertEquals(expectedArea, calculator.calculateTotalArea(Arrays.asList(rectangle, circle)));
    }

    @Test
    void rectangle_CalculateArea_ReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(6, 4);
        assertEquals(24, rectangle.calculateArea());
    }

    @Test
    void circle_CalculateArea_ReturnsCorrectArea() {
        Circle circle = new Circle(2);
        assertEquals(Math.PI * 4, circle.calculateArea());
    }
} 