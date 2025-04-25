import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class AssignmentIndividual extends JFrame {
    // Input fields and components
    private JTextField num1Field, num2Field;
    private JComboBox<String> operationBox;
    private JLabel resultLabel;
    
    // Color scheme constants for ocean theme
    private final Color DEEP_BLUE = new Color(0, 48, 73);      
    private final Color OCEAN_BLUE = new Color(0, 95, 115);    
    private final Color WAVE_BLUE = new Color(100, 204, 240); 
    private final Color FOAM_WHITE = new Color(235, 245, 251); 

    public AssignmentIndividual() {
        setTitle("Angelica Ferriol's Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(FOAM_WHITE);
        
        // Create main panel with custom wave background
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Enable antialiasing for smoother curves
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw wave pattern in background
                for (int i = 0; i < getHeight(); i += 20) {
                    g2d.setColor(new Color(0, 95, 115, 20)); 
                    Path2D path = new Path2D.Double();
                    path.moveTo(0, i);
                    
                    // Create wave effect using curved lines
                    for (int x = 0; x < getWidth(); x += 50) {
                        path.curveTo(
                            x + 25, i - 10,  
                            x + 25, i + 10,  
                            x + 50, i        
                        );
                    }
                    g2d.draw(path);
                }
            }
        };
        mainPanel.setBackground(FOAM_WHITE);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Configure layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); 

        // Initialize UI components with custom styling
        num1Field = createStyledTextField();
        num2Field = createStyledTextField();
        operationBox = createStyledComboBox();
        JButton calculateButton = createStyledButton();
        resultLabel = createStyledResultLabel();

        // Add components to the panel with proper positioning
        // First row - Number 1 input
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(createStyledLabel("Number 1:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(num1Field, gbc);

        // Second row - Number 2 input
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(createStyledLabel("Number 2:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(num2Field, gbc);

        // Third row - Operation selector
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(createStyledLabel("Operation:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(operationBox, gbc);

        // Fourth row - Calculate button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(calculateButton, gbc);

        // Fifth row - Result display
        gbc.gridy = 4;
        mainPanel.add(resultLabel, gbc);

        // Add the main panel to the frame
        add(mainPanel);

        // Set up the calculate button's action
        calculateButton.addActionListener(e -> calculate());

        // Configure final window settings
        pack();
        setSize(400, 350);
        setLocationRelativeTo(null); 
    }

    /**
     * Creates a styled text field 
     */
    private JTextField createStyledTextField() {
        JTextField field = new JTextField(10);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setForeground(DEEP_BLUE);
        field.setBackground(FOAM_WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(OCEAN_BLUE, 2, true),
            new EmptyBorder(5, 5, 5, 5)));
        return field;
    }

    /**
     * Creates a styled combo box for selecting arithmetic operations
     */
    private JComboBox<String> createStyledComboBox() {
        JComboBox<String> box = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        box.setFont(new Font("Arial", Font.BOLD, 14));
        box.setForeground(DEEP_BLUE);
        box.setBackground(FOAM_WHITE);
        box.setBorder(new LineBorder(OCEAN_BLUE, 2, true));
        return box;
    }

    /**
     * Creates a styled button with gradient background and wave-like appearance
     */
    private JButton createStyledButton() {
        JButton button = new JButton("Calculate") {
            @Override
            protected void paintComponent(Graphics g) {
                // Create gradient effect for button
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, OCEAN_BLUE, 0, getHeight(), WAVE_BLUE);
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(FOAM_WHITE);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    /**
     * Creates a styled label with ocean-themed colors
     */
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(DEEP_BLUE);
        return label;
    }

    /**
     * Creates a styled result label with border and padding
     */
    private JLabel createStyledResultLabel() {
        JLabel label = new JLabel("Result: ");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(DEEP_BLUE);
        label.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(OCEAN_BLUE, 2, true),
            new EmptyBorder(10, 10, 10, 10)));
        return label;
    }

    /**
     * Performs the calculation based on user input and selected operation
     * Handles input validation and division by zero errors
     */
    private void calculate() {
        try {
            // Parse input values
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operation = (String) operationBox.getSelectedItem();
            double result = 0;

            // Perform selected operation
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
                    // Check for division by zero
                    if (num2 == 0) {
                        showErrorMessage("Cannot divide by zero!");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // Display formatted result
            resultLabel.setText(String.format("Result: %.2f", result));

        } catch (NumberFormatException ex) {
            showErrorMessage("Please enter valid numbers!");
        }
    }

    /**
     * Displays an error message dialog
     * @param message The error message to display
     */
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new AssignmentIndividual().setVisible(true);
        });
    }
}