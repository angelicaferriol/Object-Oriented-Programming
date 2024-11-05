import java.util.Scanner;

public class MethodsR {

 // Method to add two numbers
 public int addNumbers(int num1, int num2) {
    return num1 + num2;  // Returns the sum of the two arguments passed
}

// Method to create a greeting message
public String greetUser(String name) {
    return "Hello, " + name + "!";  // Returns a greeting message with the name passed
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creating a Scanner object for user input
        MethodsR example = new MethodsR(); // Creating an instance of the Methods class

        // Prompting the user to enter values
        System.out.print("Enter the first number to add: ");
        int num1 = scanner.nextInt(); // Reads an integer from the user

        System.out.print("Enter the second number to add: ");
        int num2 = scanner.nextInt(); // Reads another integer from the user

        scanner.nextLine(); // Consume the newline left-over after nextDouble
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Reads a line of text (name) from the user

        // Calling methods with user-provided values and storing the results
        int sumResult = example.addNumbers(num1, num2); // Passing num1 and num2 to addNumbers
        String greetMessage = example.greetUser(name); // Passing name to greetUser

        // Displaying the results of the method calls
        System.out.println("\nResults:");
        System.out.println("Sum of numbers: " + sumResult);
        System.out.println("Greeting message: " + greetMessage);
        
        scanner.close(); // Closing the Scanner object
    }

}