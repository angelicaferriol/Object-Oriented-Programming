import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        // Prompting the user to enter a score
        System.out.print("Enter the student's score (0-100): ");
        int score = scanner.nextInt();

        // Determine the grade based on the score
        String grade;
        if (score >= 90 && score <= 100) {
            grade = "A";
        } else if (score >= 80 && score < 90) {
            grade = "B";
        } else if (score >= 70 && score < 80) {
            grade = "C";
        } else if (score >= 60 && score < 70) {
            grade = "D";
        } else if (score >= 0 && score < 60) {
            grade = "F";
        } else {
            grade = "Invalid score"; 
        }

        // Display the letter grade
        System.out.println("The student's grade is: " + grade);
        System.out.println("\n");
        scanner.close(); // Close the scanner
    }
}