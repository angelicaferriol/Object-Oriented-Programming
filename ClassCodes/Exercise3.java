import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise3 extends JFrame {
    private JLabel sampleText;
    private JSlider fontSizeSlider;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;
    
    public Exercise3() {
        // Set up the frame
        setTitle("Font Control System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create the sample text label
        sampleText = new JLabel("This is a text sample.");
        sampleText.setHorizontalAlignment(JLabel.CENTER);
        sampleText.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // Create the font size slider
        fontSizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 50, 20);
        fontSizeSlider.setMajorTickSpacing(10);
        fontSizeSlider.setMinorTickSpacing(2);
        fontSizeSlider.setPaintTicks(true);
        fontSizeSlider.setPaintLabels(true);
        
        // Create checkboxes
        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");
        
        // Create a panel for controls
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(boldCheckBox);
        controlPanel.add(italicCheckBox);
        
        // Add components to the frame
        add(sampleText, BorderLayout.CENTER);
        add(fontSizeSlider, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        
        // Add change listener for the slider
        fontSizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateFont();
            }
        });
        
        // Add item listeners for checkboxes
        ItemListener styleListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateFont();
            }
        };
        
        boldCheckBox.addItemListener(styleListener);
        italicCheckBox.addItemListener(styleListener);
        
        // Set frame size and make it visible
        setSize(400, 200);
        setLocationRelativeTo(null);
    }
    
    private void updateFont() {
        // Calculate font style
        int style = Font.PLAIN;
        if (boldCheckBox.isSelected()) style |= Font.BOLD;
        if (italicCheckBox.isSelected()) style |= Font.ITALIC;
        
        // Create and set new font
        Font newFont = new Font("Arial", style, fontSizeSlider.getValue());
        sampleText.setFont(newFont);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Exercise3().setVisible(true);
            }
        });
    }
}