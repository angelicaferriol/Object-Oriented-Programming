import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first and second string
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Compare the two strings using the equals() method and print the result
        System.out.println("equals(): " + str1.equals(str2));

        // Compare the two strings using the equalsIgnoreCase() method and print the result
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase(str2));

        scanner.close();
    }
}