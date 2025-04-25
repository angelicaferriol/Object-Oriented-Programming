import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field, num2Field;
    private JComboBox<String> operationBox;
    private JLabel resultLabel;

    public SimpleCalculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create components
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        operationBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Number 1:"), gbc);

        gbc.gridx = 1;
        add(num1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Number 2:"), gbc);

        gbc.gridx = 1;
        add(num2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Operation:"), gbc);

        gbc.gridx = 1;
        add(operationBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(calculateButton, gbc);

        gbc.gridy = 4;
        add(resultLabel, gbc);

        // Add action listener to the calculate button
        calculateButton.addActionListener(e -> calculate());

        // Pack and center the frame
        pack();
        setLocationRelativeTo(null);
    }

    private void calculate() {
        try {
            // Parse input numbers
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            
            // Get selected operation
            String operation = (String) operationBox.getSelectedItem();
            double result = 0;

            // Perform calculation based on selected operation
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this,
                            "Cannot divide by zero!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // Display result
            resultLabel.setText(String.format("Result: %.2f", result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numbers!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}