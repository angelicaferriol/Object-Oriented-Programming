import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 1.	Design a window with:
        Two JTextField components for inputting numbers.
    	A JComboBox with operation options: "+", "-", "*", and "/".
    	A JButton labeled "Calculate".
    	A JLabel to display the result.
2.	Add an ActionListener to the button so that:
	    It reads the numbers and the selected operation, performs the calculation, and displays the result.
3.	Include error handling to:
	    Show an error message if the user tries to divide by zero.
	    Notify the user of invalid input.
 */

public class Assignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

        
        JTextField num1 = new JTextField(10);
        JTextField num2 = new JTextField(10);
    }
}