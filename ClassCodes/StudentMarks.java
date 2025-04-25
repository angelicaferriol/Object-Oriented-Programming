import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a 2D array to store the marks
        int[][] marks = new int[5][3];

        // Accept marks for each student and subject
        System.out.println("Enter marks for 5 students in 3 subjects:");
        for (int student = 0; student < 5; student++) {
            System.out.println("Student " + (student + 1) + ":");
            for (int subject = 0; subject < 3; subject++) {
                System.out.print("Subject " + (subject + 1) + ": ");
                marks[student][subject] = scanner.nextInt();
            }
        }

        // Calculate and display the total marks for each student
        System.out.println("\nTotal marks for each student:");
        for (int student = 0; student < 5; student++) {
            int total = 0;
            for (int subject = 0; subject < 3; subject++) {
                total += marks[student][subject];
            }
            System.out.println("Student " + (student + 1) + ": " + total);
        }

        scanner.close();
    }
}