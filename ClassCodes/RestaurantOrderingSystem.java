import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        // Step 1: Create the frame
        JFrame frame = new JFrame("Restaurant Ordering System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Step 2: Create components
        // Menu Items
        JCheckBox burger = new JCheckBox("Burger (₱100)");
        JCheckBox pizza = new JCheckBox("Pizza (₱200)");
        JCheckBox pasta = new JCheckBox("Pasta (₱150)");
        JCheckBox soda = new JCheckBox("Soda (₱50)");
        JCheckBox water = new JCheckBox("Water (₱20)");

        burger.setBounds(50, 50, 200, 20);
        pizza.setBounds(50, 80, 200, 20);
        pasta.setBounds(50, 110, 200, 20);
        soda.setBounds(50, 140, 200, 20);
        water.setBounds(50, 170, 200, 20);

        // Discount Field
        JLabel discountLabel = new JLabel("Discount Code:");
        discountLabel.setBounds(50, 210, 150, 20);
        JTextField discountField = new JTextField();
        discountField.setBounds(150, 210, 100, 20);

        // Compute Button and Total Label
        JButton computeButton = new JButton("Compute Total");
        computeButton.setBounds(50, 250, 150, 30);
        JLabel totalLabel = new JLabel("Total: ₱0.00");
        totalLabel.setBounds(50, 300, 300, 20);

        // Add components to frame
        frame.add(burger);
        frame.add(pizza);
        frame.add(pasta);
        frame.add(soda);
        frame.add(water);
        frame.add(discountLabel);
        frame.add(discountField);
        frame.add(computeButton);
        frame.add(totalLabel);

        // Step 3: Add functionality to compute button
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0;

                // Calculate cost based on selected items
                if (burger.isSelected()) total += 100;
                if (pizza.isSelected()) total += 200;
                if (pasta.isSelected()) total += 150;
                if (soda.isSelected()) total += 50;
                if (water.isSelected()) total += 20;

                // Apply discount if valid code is entered
                String discountCode = discountField.getText();
                double discount = 0;
                if (discountCode.equalsIgnoreCase("SAVE10")) {
                    discount = 0.10; // 10% discount
                } else if (discountCode.equalsIgnoreCase("SAVE20")) {
                    discount = 0.20; // 20% discount
                }

                // Calculate final total
                double finalTotal = total - (total * discount);

                // Display total
                totalLabel.setText(String.format("Total: ₱%.2f", finalTotal));
            }
        });

        // Step 4: Display the frame
        frame.setVisible(true);
    }
}
