import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TravelTicket {
    public static void main (String[] args) {
        // 1. Create the frame
        JFrame frame = new JFrame("ABC Travels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        // 2. CREATE COMPONTENTS
        // Radio buttons for type of trip
        JLabel tripLabel = new JLabel("Trip Type:");
        JRadioButton oneWay = new JRadioButton("One Way");
        JRadioButton roundTrip = new JRadioButton("Round Trip");
        ButtonGroup tripGroup = new ButtonGroup();
        tripGroup.add(oneWay);
        tripGroup.add(roundTrip);
        frame.add(tripLabel);
        frame.add(oneWay);
        frame.add(roundTrip);

        // Radio buttons for travel type
        JLabel travelType = new JLabel("\nTravel Type:");
        JRadioButton domestic = new JRadioButton("Domestic");
        JRadioButton international = new JRadioButton("International");
        ButtonGroup travelGroup = new ButtonGroup();
        travelGroup.add(domestic);
        travelGroup.add(international);
        frame.add(travelType);
        frame.add(domestic);
        frame.add(international);

        // Depart and Return fields
        JLabel departLabel = new JLabel("DEPART:");
        JTextField departTextField = new JTextField(20);
        JLabel returnLabel = new JLabel("RETURN:");
        JTextField returnTextField = new JTextField(20);
        frame.add(departLabel);
        frame.add(departTextField);
        frame.add(returnLabel);
        frame.add(returnTextField);

        // Combo boxes for FROM and TO
        JLabel fromLabel = new JLabel("FROM:");
        JComboBox<String> fromComboBox = new JComboBox<>();
        JLabel toLabel = new JLabel("TO:");
        JComboBox<String> toComboBox = new JComboBox<>();
        frame.add(fromLabel);
        frame.add(fromComboBox);
        frame.add(toLabel);
        frame.add(toComboBox);

        // Add-ons checboxes
        JLabel addonsLabel = new JLabel("ADD ONS:");
        JCheckBox baggage20kg = new JCheckBox("Additional 20kg Baggage");
        JCheckBox baggage32kg = new JCheckBox("Additional 32kg Baggage");
        JCheckBox meal = new JCheckBox("Meal");
        JCheckBox chooseSeat = new JCheckBox("Choose Seat");
        frame.add(addonsLabel);
        frame.add(baggage20kg);
        frame.add(baggage32kg);
        frame.add(meal);
        frame.add(chooseSeat);

        // Discount field
        JLabel discountLabel = new JLabel("DISCOUNT:");
        JRadioButton pwdDiscount = new JRadioButton("PWD / Senior Citizen");
        frame.add(discountLabel);
        frame.add(pwdDiscount);

        // Voucher field
        JLabel voucherLabel = new JLabel("VOUCHER:");
        JTextField voucherTextField = new JTextField(10);
        frame.add(voucherLabel);
        frame.add(voucherTextField);

        // Compute button
        JButton computeButton = new JButton("COMPUTE TOTAL FEE");
        frame.add(computeButton);

        // Total price label
        JLabel totalPriceLabel = new JLabel("TOTAL FEE: PHP");
        frame.add(totalPriceLabel);

        // 3. EVENT HANDLING
        // Enable / Disable return field based on trip type
        oneWay.addActionListener(e -> returnTextField.setEnabled(false));
        roundTrip.addActionListener(e -> returnTextField.setEnabled(true));

        // Populate the FROM and TO combo boxes based on travel type
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

        // Disable radio button if voucher is available
        // Disable PWD discount if a voucher is entered
        voucherTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!voucherTextField.getText().isEmpty()) {
                    pwdDiscount.setSelected(false);
                    pwdDiscount.setEnabled(false);
                } else {
                    pwdDiscount.setEnabled(true);
                }
            }
        });
        // Compute the total fee
        computeButton.addActionListener(e -> { 
            try {
                // Base fare calculation
                int baseFare = 0;
                if (domestic.isSelected()) {
                    if (fromComboBox.getSelectedItem().equals("Manila") && toComboBox.getSelectedItem().equals("Cebu")) {
                        baseFare = 1500;
                    } 
                    else if (fromComboBox.getSelectedItem().equals("Cebu") && toComboBox.getSelectedItem().equals("Manila")) {
                        baseFare = 1600;
                    } 
                } 
                else if (international.isSelected()) {
                    if (fromComboBox.getSelectedItem().equals("Manila") && toComboBox.getSelectedItem().equals("Hong Kong")) {
                        baseFare = 2500;
                    } 
                    else if (fromComboBox.getSelectedItem().equals("Hong Kong") && toComboBox.getSelectedItem().equals("Manila")) {
                        baseFare = 3500;
                     }
                } 

                // Add-ons calculation
                int addOns = 0;
                if(baggage20kg.isSelected()) addOns += 600;
                if(baggage32kg.isSelected()) addOns += 1200;
                if(meal.isSelected()) addOns += 300;
                if(chooseSeat.isSelected()) addOns += 250;

                // Discount and voucher calculation
                double discount = 0;
                if(pwdDiscount.isSelected()) discount = 0.05;
                if(voucherTextField.getText().equals("ABCPROMO50")) discount = 0.50;

                // Total fee calculations
                double totalFee = baseFare + addOns;
                totalFee -= totalFee * discount;

                // Display the total fee
                totalPriceLabel.setText("TOTAL FEE: PHP" + totalFee);

            } catch (Exception ex) {   
                totalPriceLabel.setText("ERROR IN CALCULATION");
             }

        });

        // 5. DISPLAY THE FRAME
        frame.setVisible(true);
    }
}