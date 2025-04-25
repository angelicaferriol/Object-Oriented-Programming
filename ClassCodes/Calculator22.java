import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator22 {
    public static void main (String[] args) {
        // Step 1 - Create the frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for placing components

        // Step 2 - Create a text field to display input and results
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);

        // Step 3 - Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // 5x4 grid for buttons

        // Step 4 - Add buttons for numbers, operators, and functionality
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "Clr", "=", "+",
            "Del"
        };

        // Add action listeners for buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);

            // Define action for each button
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Get the button that was clicked
                    String buttonText = button.getText();
                    String currentText = textField.getText();

                    // Clear the text field
                    if (buttonText.equals("Clr")) {
                        textField.setText("");
                    } else if (buttonText.equals("=")) {
                        try {
                            double result = evaluateExpression(currentText);
                            textField.setText(Double.toString(result));
                        } catch (Exception ex) {
                            textField.setText("Error");
                        }
                    } else if (buttonText.equals("Del")) {
                        if (!currentText.isEmpty()) {
                            textField.setText(currentText.substring(0, currentText.length() - 1));
                        }
                    } else { // Append the button text to the input
                        textField.setText(currentText + buttonText);
                    }
                }
            });
        }

        // Step 5 - Add components to the frame
        frame.add(textField, BorderLayout.NORTH); // Add the text field at the top
        frame.add(buttonPanel, BorderLayout.CENTER); // Add the button panel in the center

        // Make sure the frame is visible
        frame.setVisible(true);
    }

    // Helper method to evaluate mathematical expressions
    public static double evaluateExpression(String expression) throws Exception {
        double result = 0;
        char operator = ' ';
        String[] parts = expression.split("(?<=[-+*/])|(?=[-+*/])"); // Split by operators

        if (parts.length < 3) {
            throw new Exception("Invalid Expression");
        }

        result = Double.parseDouble(parts[0].trim()); // First number
        for (int i = 1; i < parts.length; i += 2) {
            operator = parts[i].trim().charAt(0); // Operator
            double num = Double.parseDouble(parts[i + 1].trim()); // Next number

            switch (operator) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                case '/':
                    if (num == 0) throw new ArithmeticException("Cannot divide by zero");
                    result /= num;
                    break;
                default:
                    throw new Exception("Unknown operator");
            }
        }
        return result;
    }
}