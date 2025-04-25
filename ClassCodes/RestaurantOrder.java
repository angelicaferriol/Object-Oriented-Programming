import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestaurantOrder {
    public static void main (String[] args) {
        // 1. CREATE THE FRAME
        JFrame frame = new JFrame("ABC Restaurant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new FlowLayout());

        // 2. CREATE THE COMPONENTS
        // Checkboxes for menu items
        JLabel menuLabel = new JLabel("MENU:");
        JCheckBox burger = new JCheckBox("Burger");
        JCheckBox pizza = new JCheckBox("Pizza");
        JCheckBox pasta = new JCheckBox("Pasta");
        frame.add(menuLabel);
        frame.add(burger);
        frame.add(pizza);
        frame.add(pasta);
 
        // ComboBoxes for drinks
        JComboBox<String> drinks = new JComboBox<>();
        drinks.addItem("Select Drink");
        drinks.addItem("Coke");
        drinks.addItem("Sprite");
        drinks.addItem("Water");
        frame.add(drinks);

        // Radio buttons for Dine/TakeOut
        JLabel orderType = new JLabel("ORDER TYPE:");
        JRadioButton dineIn = new JRadioButton("Dine In");
        JRadioButton takeOut = new JRadioButton("Take Out");
        ButtonGroup orderGroup = new ButtonGroup();
        orderGroup.add(dineIn);
        orderGroup.add(takeOut);
        frame.add(orderType);
        frame.add(dineIn);
        frame.add(takeOut);

        // JTextField for costumer name
        JLabel nameLabel = new JLabel("NAME:");
        JTextField nameTextField = new JTextField(20);
        frame.add(nameLabel);
        frame.add(nameTextField);

        // Radio  buttons for discounts
        JLabel discountLabel = new JLabel("DISCOUNTS:");
        JRadioButton seniorCitizen = new JRadioButton("Senior Citizen");
        JRadioButton pwd = new JRadioButton("PWD");
        JRadioButton student = new JRadioButton("Student");
        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(seniorCitizen);
        discountGroup.add(pwd);
        discountGroup.add(student);
        frame.add(discountLabel);
        frame.add(seniorCitizen);
        frame.add(pwd);
        frame.add(student);

        // JTextField for promo codes
        JLabel promoLabel = new JLabel("PROMO CODE:");
        JTextField promoTextField = new JTextField(20);
        frame.add(promoLabel);
        frame.add(promoTextField);

        // JButton to compute the total bill
        JButton computeButton = new JButton("COMPUTE TOTAL");
        frame.add(computeButton);

        // JLabel to display the totall bill 
        JLabel totalLabel = new JLabel("TOTAL:");
        frame.add(totalLabel);

        // JLabel to display the confirmation message
        JLabel confirmationLabel = new JLabel("");
        frame.add(confirmationLabel);
        
        // 3. EVENT HANDLING
        // Disable drinks if takeout
        dineIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drinks.setEnabled(true);
            }
        });

        takeOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drinks.setEnabled(false);
            }
        });

        // Compute the total bill
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected menu items
                    int menuPrice = 0;
                    if(burger.isSelected()) menuPrice += 50;
                    if(pizza.isSelected()) menuPrice += 100;
                    if(pasta.isSelected()) menuPrice += 80;

                    // Get the selected drink
                    int drinkPrice = 0;
                    if(drinks.getSelectedItem().equals("Coke")) drinkPrice = 40;
                    if(drinks.getSelectedItem().equals("Sprite")) drinkPrice = 50;
                    if(drinks.getSelectedItem().equals("Water")) drinkPrice = 10;

                    // Set discounts for senior citizen, pwd, and student
                    double discount = 0;
                    if(seniorCitizen.isSelected()) discount = 0.20;
                    if(pwd.isSelected()) discount = 0.15;
                    if(student.isSelected()) discount = 0.10;

                    // Set promo codes
                    double promoDiscount = 0;
                    if(promoTextField.getText().equals("ABC123")) promoDiscount = 0.30;

                    // Calculate the total bill
                    int totalPrice = menuPrice + drinkPrice;
                    totalPrice -= totalPrice * discount;
                    totalPrice -= totalPrice * promoDiscount;

                    // Display the total bill
                    totalLabel.setText("TOTAL: PHP " + totalPrice);

                    // Display confirmation message
                    String username = nameTextField.getText();
                    if(nameTextField.getText().isEmpty()) {
                        confirmationLabel.setText("Please enter costumer's name!");
                    } else {
                        confirmationLabel.setText("Order confirmed for " + username + ". Please wait for 5 minutes.");
                    }
                    

                } catch (Exception ex) {
                    // Display error message
                    totalLabel.setText("An error occured. Try again");

            }
        }
    });
        
        // 4. DISPLAY THE FRAME
        frame.setVisible(true);
    }
    
}
