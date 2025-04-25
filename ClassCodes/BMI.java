import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMI {
    public static void main(String[] args) {
        // S1: Create the frame
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // S2: Create the components
        JLabel weightLabel = new JLabel("Enter your weight (kg): ");
        JTextField weightField = new JTextField(10);

        JLabel heightLabel = new JLabel("Enter your height (m): ");
        JTextField heightField = new JTextField(10);

        JButton calculateButton = new JButton("Get BMI");
        JLabel resultLabel = new JLabel("Your BMI is: ");
        JLabel categoryLabel = new JLabel("Category: ");

        // S3: Add the components to the frame
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(resultLabel);
        frame.add(categoryLabel);

        // S4: Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input from the user
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());

                    // Calculate the BMI
                    double bmi = weight / (height * height);

                    // Display the BMI
                    resultLabel.setText("Your BMIS is: " + String.format("%.2f", bmi));

                    // Determine the category and update the categoryLabel
                    String category = "";
                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        category = "Normal weight";
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                }
 
                categoryLabel.setText("Category: " + category);
                } catch (NumberFormatException ex) {
                    //If input is invalid, display an error message
                    resultLabel.setText("Invalid input.");
                    categoryLabel.setText("Invalid input.");
                }
            }
        });

        frame.setVisible(true);

    }
}
