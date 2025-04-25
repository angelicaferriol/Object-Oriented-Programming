import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketingSystem {
    public static void main (String[] args) {
    // Step 1: Create the frame
    JFrame frame = new JFrame("Ticketing System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLayout(new FlowLayout());

    // Step 2: Create the components
    JLabel eventLabel = new JLabel("Select Event:");
    String[] events = {"Movie - $12", "Concert - $50", "Play - $30"};
    JComboBox<String> eventComboBox = new JComboBox(events);
    
    JLabel seatLabel = new JLabel("Select Seat:");
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
    
    // Step 4: Add ActionListener to the buttons
    bookButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the selected event and seat from the combo box and radio buttns
                int selectedIndex = eventComboBox.getSelectedIndex();
                int basePrice[] = {12, 50, 30}; // Corresponding prices for events
                
                // Determine the seat type
                int seatPrice = 0;
                if (vipSeat.isSelected()) {
                    seatPrice = 10; // VIP seat adds $10
                } else if (regularSeat.isSelected()) {
                    seatPrice = 0; // Regular adds no extra cost
                } else {
                    confirmationLabel.setText("Please select a seat type.");
                    return;
                }

                // Calculation total price
                int totalPrice = basePrice[selectedIndex] + seatPrice;

                // Display the total price
                totalPriceLabel.setText("Total Price: $" + totalPrice);

                // Check if user has enetered details
                String userName = detailsTextField.getText();
                if (userName.isEmpty()) {
                    confirmationLabel.setText("Please enter your name.");
                } else {
                    confirmationLabel.setText("Booking confirmed for " + userName + ". Enjoy the event!");
                }
            } catch (Exception ex) {
                confirmationLabel.setText("An error occured. Try again.");

            }
        }
    });

    // Step 5: Display the framE
    frame.setVisible(true);
    }
}