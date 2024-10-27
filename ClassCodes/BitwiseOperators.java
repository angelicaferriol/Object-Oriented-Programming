// Import the Scanner class
import java.util.Scanner;

// Start of the Program
public class BitwiseOperators {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for two integers
        System.out.print("Enter number 1: ");
        int numOne = scanner.nextInt();

        System.out.print("Enter number 2: ");
        int numTwo = scanner.nextInt();

        // Prompt the user to enter their choice
        System.out.println("BITWISE OPERATIONS \n1. AND\n2. OR\n3. XOR\n4. NOT\n5. LEFT SHIFT\n6. RIGHT SHIFT");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        // Perform bitwise operations based on user choice
        switch (choice) {
            case 1:
                int resultAnd = numOne & numTwo;
                System.out.println("AND Result: " + resultAnd);
                System.out.println("Explanation: Performs a bitwise AND operation, where each bit is 1 only if both corresponding bits of the operands are 1.");
                break;
            case 2:
                int resultOR = numOne | numTwo;
                System.out.println("OR Result: " + resultOR);
                System.out.println("Explanation: Performs a bitwise OR operation, where each bit is 1 if at least one of the corresponding bits of the operands is 1.");
                break;
            case 3:
                int resultXOR = numOne ^ numTwo;
                System.out.println("XOR Result: " + resultXOR);
                System.out.println("Explanation: Performs a bitwise XOR operation, where each bit is 1 only if one of the corresponding bits of the operands is 1.");
                break;
            case 4:
                int resultNOTnumOne = ~numOne;
                int resultNOTnumTwo = ~numTwo;
                System.out.println("NOT Result for Number 1: " + resultNOTnumOne);
                System.out.println("NOT Result for Number 2: " + resultNOTnumTwo);
                System.out.println("Explanation: Performs a bitwise NOT operation, flipping each bit of the operand.");
                break;
            case 5:
                int resultLeftShift = numOne << numTwo;
                System.out.println("Left Shift Result: " + resultLeftShift);
                System.out.println("Explanation: Performs a left shift operation, shifting the bits of the first operand to the left by the number of positions specified by the second operand.");
                break;
            case 6:
                int resultRightShift = numOne >> numTwo;
                System.out.println("Right Shift Result: " + resultRightShift);
                System.out.println("Explanation: Performs a right shift operation, shifting the bits of the first operand to the right by the number of positions specified by the second operand.");
                break;
            default:
                System.out.println("Invalid choice");
        }
  
        scanner.close();
    }
}