import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CafeCashier {
    public static void main(String[] args) {
        // Step 1: Create the frame
        JFrame frame = new JFrame("Cafe Cashier System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new FlowLayout());

        // Step 2: Create the components
        JLabel itemLabel = new JLabel("Select Item:");
        String[] menuItems = {"Coffee - $5", "Tea - $3", "Sandwich - $7", "Cake - $6"};
        JComboBox<String> menuComboBox = new JComboBox<>(menuItems);

        JLabel quantityLabel = new JLabel("Enter Quantity:");
        JTextField quantityTextField = new JTextField(5);

        JCheckBox addonCheckBox1 = new JCheckBox("Add Dessert ($4)");
        JCheckBox addonCheckBox2 = new JCheckBox("Add Drink ($2)");

        JButton calculateButton = new JButton("Calculate Total");
        JLabel resultLabel = new JLabel("Total Amount: $0.00");

        // Step 3: Add the components to the frame
        frame.add(itemLabel);
        frame.add(menuComboBox);
        frame.add(quantityLabel);
        frame.add(quantityTextField);
        frame.add(addonCheckBox1);
        frame.add(addonCheckBox2);
        frame.add(calculateButton);
        frame.add(resultLabel);

        // Step 4: Add ActionListener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the selected item and quantity from the combo box and text field
                    int selectedIndex = menuComboBox.getSelectedIndex();
                    int[] prices = {5, 3, 7, 6}; // Corresponding prices for menu items
                    int basePrice = prices[selectedIndex];
                    int quantity = Integer.parseInt(quantityTextField.getText());

                    // Calculate the total amount
                    double total = basePrice * quantity;
                    if (addonCheckBox1.isSelected()) {
                        total += 4; // Add Dessert
                    }
                    if (addonCheckBox2.isSelected()) {
                        total += 2; // Add Drink
                    }

                    // Add tax (10%)
                    double tax = total * 0.10;
                    total += tax;

                    // Display the total amount
                    resultLabel.setText(String.format("Total Amount: $%.2f (incl. tax)", total));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid Quantity! Please enter a valid number.");
                }
            }
        });

        // Step 5: Display the frame
        frame.setVisible(true);
    }
}
