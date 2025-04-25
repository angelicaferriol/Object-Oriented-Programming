import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class LibrarySystem {
    public static void main(String[] args) {
        // 1. CREATE THE FRAME
        JFrame frame = new JFrame("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        // 2. CREATE THE COMPONENTS
        // JLabel and JTextField for Title, Author, ISBN
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);
        frame.add(titleLabel);
        frame.add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField(20);
        frame.add(authorLabel);
        frame.add(authorField);

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField(20);
        frame.add(isbnLabel);
        frame.add(isbnField);

        //JLabel and JComboBox for Genre
        JLabel genreLabel = new JLabel("Genre:");
        String[] genres = {"Fiction", "Non-Fiction", "Science", "History"};
        JComboBox<String> genreBox = new JComboBox<>(genres);
        frame.add(genreLabel);
        frame.add(genreBox);

        // JList to display borrowed books and other components
        JLabel borrowedLabel = new JLabel("Borrowed Books:");
        DefaultListModel<String> borrowedModel = new DefaultListModel<>();
        JList<String> borrowedList = new JList<>(borrowedModel);
        JScrollPane scroll = new JScrollPane(borrowedList);
        frame.add(borrowedLabel);
        frame.add(scroll);

        // JButton for Isssue and Return
        JButton issueButton = new JButton("Issue Book");
        JButton returnButton = new JButton("Return Book");
        frame.add(issueButton);
        frame.add(returnButton);

        // JLabel for message
        JLabel messageLabel = new JLabel("");
        frame.add(messageLabel);

        // 3. EVENT HANDLING
        // Back end logic for issuing and returning books
        Map<String, Date> borrowedBooks = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        // Issue Button
        issueButton.addActionListener(new ActionListener() {
            @Override // Override the actionPerformed method
            public void actionPerformed(ActionEvent e) {
                    // Limit borrowing to 3 books add warning if exceeded
                    if (borrowedBooks.size() >= 3) {
                        messageLabel.setText("You have reached the borrowing limit.");
                        return;
                    }

                    // Get the book details from the fields 
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String isbn = isbnField.getText();
                    String genre = (String) genreBox.getSelectedItem();

                    // Make sure all fields are filled
                    if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                        messageLabel.setText("Please fill out all the fields.");
                        return;
                    }

                    // Add the book to the borrowed list
                    String bookDetails = title + " by " + author + " (" + isbn + ")" + genre;
                    borrowedModel.addElement(bookDetails);
               
                    // Assign a due date (7 days from the current date) to each book
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 7);
                    borrowedBooks.put(bookDetails, cal.getTime());
                    messageLabel.setText("Book issued successfully");

                    // Clear input fields
                    titleField.setText("");
                    authorField.setText("");
                    isbnField.setText("");
            }
        });

        // Return Button
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected book from the list
                String selectedBook = borrowedList.getSelectedValue();
                if (selectedBook == null) {
                    messageLabel.setText("Please select a book to return.");
                    return;
                }

                // Remove the book from the borrowed list
                Date dueDate = borrowedBooks.remove(selectedBook);
                borrowedModel.removeElement(selectedBook);

                // Calculate fine if book is returned late
                Date currentDate = new Date();
                long diff = currentDate.getTime() - dueDate.getTime();
                long daysLate = diff / (1000 * 60 * 60 * 24);

                if (daysLate > 0) {
                    long fine = daysLate * 5; // ₱5 per day late
                    messageLabel.setText("Book returned late! Fine: ₱" + fine);
                } else {
                    messageLabel.setText("Book returned on time! No fine.");
                }
            }
        });

        // 4. DISPLAY THE FRAME
        frame.setVisible(true);
    }
}
