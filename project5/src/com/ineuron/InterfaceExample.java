package com.ineuron;

/*Interface:
An interface in Java is a collection of abstract methods that defines a contract for classes to follow. 
It cannot contain variables or constructors. Here's an example:

*/

interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class InterfaceExample  {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
    }
}

/*
 * Key Points:
 * 
 * Interfaces cannot be instantiated directly. They are implemented by classes.
 * Interfaces can only contain abstract methods and constants (public static
 * final variables). All methods in an interface are implicitly public and
 * abstract. A class implementing an interface must provide an implementation
 * for all the methods declared in the interface. A class can implement multiple
 * interfaces. Summary:
 * 
 * Abstract classes are used to provide a common base for subclasses and can
 * contain both abstract and non-abstract methods, variables, and constructors.
 * Interfaces define a contract for classes to follow and can only contain
 * abstract methods and constants. Classes can extend only one abstract class,
 * but they can implement multiple interfaces. Abstract classes are used for
 * inheritance and code reusability, while interfaces are used for providing
 * common behavior among unrelated classes.
 */
