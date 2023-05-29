package com.ineuron;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}

public class StreamExample {
    public static void main(String[] args) {
        // Create a large dataset of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, 3.5));
        students.add(new Student("Bob", 21, 3.8));
        students.add(new Student("Charlie", 19, 3.2));
        students.add(new Student("David", 22, 3.6));
        // ... add more students

        // Sorting the students by GPA in descending order
        List<Student> sortedStudents = students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .collect(Collectors.toList());

        System.out.println("Students sorted by GPA in descending order:");
        sortedStudents.forEach(student -> System.out.println(student.getName() + " - GPA: " + student.getGpa()));

        // Filtering the students based on age
        int ageThreshold = 20;
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getAge() >= ageThreshold)
                .collect(Collectors.toList());

        System.out.println("\nStudents above or equal to " + ageThreshold + " years old:");
        filteredStudents.forEach(student -> System.out.println(student.getName() + " - Age: " + student.getAge()));
    }
}
