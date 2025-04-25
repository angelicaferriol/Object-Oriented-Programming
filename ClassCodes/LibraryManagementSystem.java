import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Step 1: Create the frame
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Step 2: Components for entering book details
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(30, 30, 100, 20);
        JTextField titleField = new JTextField();
        titleField.setBounds(100, 30, 150, 20);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(30, 60, 100, 20);
        JTextField authorField = new JTextField();
        authorField.setBounds(100, 60, 150, 20);

        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setBounds(30, 90, 100, 20);
        JTextField isbnField = new JTextField();
        isbnField.setBounds(100, 90, 150, 20);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(30, 120, 100, 20);
        JComboBox<String> genreBox = new JComboBox<>(new String[] { "Fiction", "Non-Fiction", "Science", "History" });
        genreBox.setBounds(100, 120, 150, 20);

        // Step 3: Components for managing borrowed books
        JLabel borrowedLabel = new JLabel("Borrowed Books:");
        borrowedLabel.setBounds(300, 30, 150, 20);
        DefaultListModel<String> borrowedModel = new DefaultListModel<>();
        JList<String> borrowedList = new JList<>(borrowedModel);
        JScrollPane scrollPane = new JScrollPane(borrowedList);
        scrollPane.setBounds(300, 60, 250, 150);

        // Step 4: Buttons for actions
        JButton issueButton = new JButton("Issue Book");
        issueButton.setBounds(30, 180, 150, 30);

        JButton returnButton = new JButton("Return Book");
        returnButton.setBounds(300, 220, 150, 30);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(30, 220, 500, 30);

        // Step 5: Add components to the frame
        frame.add(titleLabel);
        frame.add(titleField);
        frame.add(authorLabel);
        frame.add(authorField);
        frame.add(isbnLabel);
        frame.add(isbnField);
        frame.add(genreLabel);
        frame.add(genreBox);
        frame.add(borrowedLabel);
        frame.add(scrollPane);
        frame.add(issueButton);
        frame.add(returnButton);
        frame.add(messageLabel);

        // Step 6: Backend logic
        Map<String, Date> borrowedBooks = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (borrowedBooks.size() >= 3) {
                    messageLabel.setText("Limit reached! Return a book to borrow a new one.");
                    return;
                }

                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String isbn = isbnField.getText().trim();
                String genre = (String) genreBox.getSelectedItem();

                if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                    messageLabel.setText("Please fill in all book details!");
                    return;
                }

                String bookDetails = title + " | " + author + " | " + isbn + " | " + genre;
                borrowedModel.addElement(bookDetails);

                // Add due date
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, 7);
                borrowedBooks.put(bookDetails, cal.getTime());
                messageLabel.setText("Book issued successfully! Due date: " + sdf.format(cal.getTime()));

                // Clear input fields
                titleField.setText("");
                authorField.setText("");
                isbnField.setText("");
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = borrowedList.getSelectedValue();
                if (selectedBook == null) {
                    messageLabel.setText("Please select a book to return!");
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

        // Step 7: Display the frame
        frame.setVisible(true);
    }
}
