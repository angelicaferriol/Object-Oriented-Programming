import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class ContactBook {
    public static void main(String[] args) {
        // 1. CREATE THE FRAME
        JFrame frame = new JFrame("Contact Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        // 2. CREATE THE COMPONENTS
        // JLabl and JTextField for Name, email, and phone number
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        frame.add(nameLabel);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        frame.add(emailLabel);
        frame.add(emailField);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JTextField phoneNumberField = new JTextField(20);
        frame.add(phoneNumberLabel);
        frame.add(phoneNumberField);

        // JButton for actions(add, view, search, delete)
        JButton addButton = new JButton("Add");
        frame.add(addButton);
        JButton viewButton = new JButton("View");
        frame.add(viewButton);
        JButton searchButton = new JButton("Search");
        frame.add(searchButton);
        JButton deleteButton = new JButton("Delete");
        frame.add(deleteButton);

        // JList to display contacts and DefaultListModel and JScrollPane
        JLabel contactsLabel = new JLabel("Contacts:");


        // HashMap to store contacts

        // 3. EVENT HANDLING
        // ADD

        // VIEW

        // SEARCH

        // DELETE

        // 4. DISPLAY THE FRAME
        frame.setVisible(true);
    }
}