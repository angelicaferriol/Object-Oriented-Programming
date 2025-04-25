import java.util.Scanner; // Import the Scanner class to read user input

public class WordCounter {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a sentence and store it in the sentence variable
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Split the sentence into an array of words using the split() method with the space character as the delimiter
        String[] words = sentence.split(" ");

        // Get the length of the words array, which represents the number of words in the sentence
        int wordCount = words.length;

        // Print the number of words in the sentence
        System.out.println("The sentence has " + wordCount + " words.");

        scanner.close();
    }
}