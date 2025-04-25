import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TravelBookingSystem {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Step 1: Create the frame
        JFrame frame = new JFrame("ABC Travels");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Step 2: Create components
        // Radio buttons for One Way / Round Trip
        JLabel tripLabel = new JLabel("Trip Type:");
        tripLabel.setBounds(30, 20, 100, 20);
        JRadioButton oneWay = new JRadioButton("One Way");
        JRadioButton roundTrip = new JRadioButton("Round Trip");
        ButtonGroup tripGroup = new ButtonGroup();
        tripGroup.add(oneWay);
        tripGroup.add(roundTrip);
        oneWay.setBounds(120, 20, 100, 20);
        roundTrip.setBounds(220, 20, 100, 20);

        // Depart and Return fields
        JLabel departLabel = new JLabel("DEPART:");
        departLabel.setBounds(30, 60, 100, 20);
        JTextField departField = new JTextField();
        departField.setBounds(120, 60, 150, 20);

        JLabel returnLabel = new JLabel("RETURN:");
        returnLabel.setBounds(30, 100, 100, 20);
        JTextField returnField = new JTextField();
        returnField.setBounds(120, 100, 150, 20);
        returnField.setEnabled(false);

        // Radio buttons for Domestic / International
        JLabel travelTypeLabel = new JLabel("Travel Type:");
        travelTypeLabel.setBounds(30, 140, 100, 20);
        JRadioButton domestic = new JRadioButton("Domestic");
        JRadioButton international = new JRadioButton("International");
        ButtonGroup travelTypeGroup = new ButtonGroup();
        travelTypeGroup.add(domestic);
        travelTypeGroup.add(international);
        domestic.setBounds(120, 140, 100, 20);
        international.setBounds(220, 140, 150, 20);

        // Combo boxes for FROM and TO
        JLabel fromLabel = new JLabel("FROM:");
        fromLabel.setBounds(30, 180, 100, 20);
        JComboBox<String> fromComboBox = new JComboBox<>();
        fromComboBox.setBounds(120, 180, 150, 20);

        JLabel toLabel = new JLabel("TO:");
        toLabel.setBounds(30, 220, 100, 20);
        JComboBox<String> toComboBox = new JComboBox<>();
        toComboBox.setBounds(120, 220, 150, 20);

        // Add-ons checkboxes
        JCheckBox baggage20kg = new JCheckBox("Additional 20kg Baggage (₱600)");
        JCheckBox baggage32kg = new JCheckBox("Additional 32kg Baggage (₱1200)");
        JCheckBox meal = new JCheckBox("Meal (₱300)");
        JCheckBox seat = new JCheckBox("Choose Seat (₱250)");
        baggage20kg.setBounds(30, 260, 300, 20);
        baggage32kg.setBounds(30, 290, 300, 20);
        meal.setBounds(30, 320, 300, 20);
        seat.setBounds(30, 350, 300, 20);

        // Discount radio button and voucher field
        JRadioButton pwdDiscount = new JRadioButton("PWD / Senior Citizen Discount");
        pwdDiscount.setBounds(30, 380, 300, 20);
        JLabel voucherLabel = new JLabel("Voucher:");
        voucherLabel.setBounds(30, 410, 100, 20);
        JTextField voucherField = new JTextField();
        voucherField.setBounds(120, 410, 150, 20);

        // Compute button and total fee label
        JButton computeButton = new JButton("Compute Total Fee");
        computeButton.setBounds(300, 60, 200, 40);
        JLabel totalFeeLabel = new JLabel("Total Fee: ");
        totalFeeLabel.setBounds(300, 120, 300, 20);

        // Add components to frame
        frame.add(tripLabel);
        frame.add(oneWay);
        frame.add(roundTrip);
        frame.add(departLabel);
        frame.add(departField);
        frame.add(returnLabel);
        frame.add(returnField);
        frame.add(travelTypeLabel);
        frame.add(domestic);
        frame.add(international);
        frame.add(fromLabel);
        frame.add(fromComboBox);
        frame.add(toLabel);
        frame.add(toComboBox);
        frame.add(baggage20kg);
        frame.add(baggage32kg);
        frame.add(meal);
        frame.add(seat);
        frame.add(pwdDiscount);
        frame.add(voucherLabel);
        frame.add(voucherField);
        frame.add(computeButton);
        frame.add(totalFeeLabel);

        // Step 3: Event handling
        // Enable / disable return field based on trip type
        oneWay.addActionListener(e -> returnField.setEnabled(false));
        roundTrip.addActionListener(e -> returnField.setEnabled(true));

        // Populate FROM and TO combo boxes based on travel type
        domestic.addActionListener(e -> {
            fromComboBox.removeAllItems();
            toComboBox.removeAllItems();
            fromComboBox.addItem("Manila");
            fromComboBox.addItem("Cebu");
            toComboBox.addItem("Manila");
            toComboBox.addItem("Cebu");
        });

        international.addActionListener(e -> {
            fromComboBox.removeAllItems();
            toComboBox.removeAllItems();
            fromComboBox.addItem("Manila");
            fromComboBox.addItem("Hong Kong");
            toComboBox.addItem("Manila");
            toComboBox.addItem("Hong Kong");
        });

        computeButton.addActionListener(e -> {
            try {
                // Base fare calculation
                int baseFare = 0;
                if (domestic.isSelected()) {
                    if (fromComboBox.getSelectedItem().equals("Manila") && toComboBox.getSelectedItem().equals("Cebu")) {
                        baseFare = 1500;
                    } else if (fromComboBox.getSelectedItem().equals("Cebu") && toComboBox.getSelectedItem().equals("Manila")) {
                        baseFare = 1600;
                    }
                } else if (international.isSelected()) {
                    if (fromComboBox.getSelectedItem().equals("Manila") && toComboBox.getSelectedItem().equals("Hong Kong")) {
                        baseFare = 2500;
                    } else if (fromComboBox.getSelectedItem().equals("Hong Kong") && toComboBox.getSelectedItem().equals("Manila")) {
                        baseFare = 3500;
                    }
                }

                // Add-ons calculation
                int addOns = 0;
                if (baggage20kg.isSelected()) addOns += 600;
                if (baggage32kg.isSelected()) addOns += 1200;
                if (meal.isSelected()) addOns += 300;
                if (seat.isSelected()) addOns += 250;

                // Discount calculation
                double discount = 0;
                if (pwdDiscount.isSelected()) discount = 0.05;
                if (voucherField.getText().equalsIgnoreCase("ABCPROMO50")) discount = 0.50;

                // Total fee calculation
                double totalFee = baseFare + addOns;
                totalFee -= totalFee * discount;

                // Display total fee
                totalFeeLabel.setText(String.format("Total Fee: ₱%.2f", totalFee));
            } catch (Exception ex) {
                totalFeeLabel.setText("Error in calculation.");
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
