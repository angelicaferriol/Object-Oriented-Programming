import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketingSystem2 {
    public static void main (String[] args) {
        // Step 1: Create the frame
        JFrame frame = new JFrame("Ticketing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new FlowLayout());

        // Step 2: Create the components
        JLabel eventLabel = new JLabel("Select Event:");
        String events[] = {"Option 1 - $10", "Option 2 - $20", "Option 3 - $30"};
        JComboBox<String> eventComboBox = new JComboBox(events);

        JLabel seatLabel = new JLabel("Select SEat:");
        JRadioButton vipSeat = new JRadioButton("VIP (+$10)");
        JRadioButton regularSeat = new JRadioButton("Regular");
        ButtonGroup seatGroup = new ButtonGroup();
        seatGroup.add(vipSeat);
        seatGroup.add(regularSeat);

        JLabel detailsLabel = new JLabel("Enter Name:");
        JTextField detailsTextField = new JTextField(20);

        JButton bookButton = new JButton("Book Ticket");
        JLabel totalPriceLabel = new JLabel("Total Price: $0");
        JLabel confirmationLabel = new JLabel("");

        // Step 3: Add the components to the frame
        frame.add(eventLabel);
        frame.add(eventComboBox);
        frame.add(seatLabel);
        frame.add(vipSeat);
        frame.add(regularSeat);
        frame.add(detailsLabel);
        frame.add(detailsTextField);
        frame.add(bookButton);
        frame.add(totalPriceLabel);
        frame.add(confirmationLabel);

        // Step 4: Add action listener to the buttons (main button is book button)
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected event and seat from the combobox and radio button
                    int selectedIndex = eventComboBox.getSelectedIndex();
                    int basePrice[] = {10, 20, 30}; 
                    
                    // Determine the seat type (Radio button uses name.isSelected() to check if selected)
                    int seatPrice = 0;
                    if (vipSeat.isSelected()) {
                        seatPrice = 10;
                    } else if (regularSeat.isSelected()) {
                        seatPrice = 0;
                    } else {
                        confirmationLabel.setText("Please select your seat.");
                    }

                    // Calculate the total price
                    int totalPrice = basePrice[selectedIndex] + seatPrice;
                    totalPriceLabel.setText("Total Price: $" + totalPrice);

                    // Display the confirmation message
                    String username = detailsTextField.getText();
                    if (detailsTextField.getText().isEmpty()) {
                        confirmationLabel.setText("Please enter your name.");
                    } else {
                        confirmationLabel.setText("Ticked book for " + username + ".");
                    }

                } catch (Exception ex) {
                    confirmationLabel.setText("An error occured.");
                }
            }
        });


        // Step 5: Display the frame
        frame.setVisible(true);
    }
}
