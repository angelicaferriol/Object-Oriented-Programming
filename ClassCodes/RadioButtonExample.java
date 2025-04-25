import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonExample extends JFrame implements ActionListener {

    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JLabel genderLabel;

    public RadioButtonExample() {
        setTitle("Radio Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        // Create button group to ensure only one radio button can be selected
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Create label to display selected gender
        genderLabel = new JLabel("Selected Gender:");

        // Add action listener to radio buttons
        maleRadioButton.addActionListener(this);
        femaleRadioButton.addActionListener(this);

        // Add components to the frame
        add(maleRadioButton);
        add(femaleRadioButton);
        add(genderLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == maleRadioButton) {
            genderLabel.setText("Selected Gender: Male");
        } else if (e.getSource() == femaleRadioButton) {
            genderLabel.setText("Selected Gender: Female");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonExample());
    }
}