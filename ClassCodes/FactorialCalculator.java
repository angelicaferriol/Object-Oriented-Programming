import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                // Get input from user
                System.out.print("Enter a non-negative integer to calculate factorial (or -1 to exit): ");
                int number = scanner.nextInt();
                
                // Check for exit condition
                if (number == -1) {
                    System.out.println("Exiting program. Goodbye!");
                    break;
                }
                
                // Calculate and display results
                System.out.println("\nCalculating factorial for: " + number);
                System.out.println("Iterative Factorial: " + calculateFactorialIterative(number));
                System.out.println("Recursive Factorial: " + calculateFactorialRecursive(number));
                System.out.println(); // Empty line for better readability
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                System.out.println();
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        scanner.close();
    }
    
    // Iterative method using for loop
    public static long calculateFactorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    // Recursive method
    public static long calculateFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Recursive case
        return n * calculateFactorialRecursive(n - 1);
    }
}