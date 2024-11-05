import java.util.Scanner;

public class Relational {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter the first integer: ");
        int num1 = s.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = s.nextInt();

        // compare the two integers using relational operators
        if (num1 > num2) {
            System.out.println("The first number is greater than the second.");
        } else if (num1 < num2) {
            System.out.println("The first number is less than the second.");
        } else if (num1 == num2) {
            System.out.println("Both numbers are equal.");
        }

        s.close();
    }
}
