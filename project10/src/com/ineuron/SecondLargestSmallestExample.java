package com.ineuron;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondLargestSmallestExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int num = scanner.nextInt();
            numbers.add(num);
        }

        if (n < 2) {
            System.out.println("Insufficient number of elements in the list.");
        } else {
            // Find the second largest and second smallest elements
            Collections.sort(numbers);
            int secondSmallest = numbers.get(1);
            int secondLargest = numbers.get(numbers.size() - 2);

            System.out.println("Second Smallest: " + secondSmallest);
            System.out.println("Second Largest: " + secondLargest);
        }
    }
}
