package com.ineuron;

/*Abstract Class:
An abstract class in Java is a class that cannot be instantiated and is typically used as a base class for other classes. 
It can contain both abstract and non-abstract methods, as well as variables. Here's an example:
*/

abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void sound();
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void sound() {
        System.out.println("Dog barks");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        dog.sound();
    }
}

/*
 * Key Points:
 * 
 * Abstract classes cannot be instantiated directly. They are meant to be
 * extended by other classes. Abstract classes can have both abstract and
 * non-abstract methods. Abstract methods are declared without a body and must
 * be implemented by the subclasses. Abstract classes can have variables and
 * constructors. Subclasses of an abstract class must either implement all the
 * abstract methods or be declared as abstract themselves.
 */