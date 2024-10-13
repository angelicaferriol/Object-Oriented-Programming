// Create a class named Book
class Book {
    // Fields for the Book class
    String title;
    String author;
    int yearPublished;

    // Create a constructor to initialize the fields
    Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Method to display book information
    void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println(); // For better formatting
    }

    // Method to update the title of the book
    void updateTitle(String newTitle) {
        this.title = newTitle;
        System.out.println("Title updated to: " + newTitle);
    }

    // Method to update the author of the book
    void updateAuthor(String newAuthor) {
        this.author = newAuthor;
        System.out.println("Author updated to: " + newAuthor);
    }

    // Method to update the year published
    void updateYearPublished(int newYear) {
        this.yearPublished = newYear;
        System.out.println("Year Published updated to: " + newYear);
    }
}

// Main class
public class ExampleClass {
    
    // Main method
    public static void main(String[] args) {
        // Create an object of the Book class
        Book myBook = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Call the method to display book information
        myBook.displayBookInfo();

        // Call methods to update book details
        myBook.updateTitle("To Kill a Mockingbird (Updated Edition)");
        myBook.updateAuthor("Harper Lee and Others");
        myBook.updateYearPublished(2021);

        // Display updated book information
        myBook.displayBookInfo();
    }
}
