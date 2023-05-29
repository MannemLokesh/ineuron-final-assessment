package in.ineuron;

import java.util.Scanner;

public class NegativeIntegerExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            
            if (number < 0) {
                throw new IllegalArgumentException("Negative integers are not allowed.");
            }
            
            System.out.println("Entered number: " + number);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        
        scanner.close();
    }
}
