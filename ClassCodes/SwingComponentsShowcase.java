import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SwingComponentsShowcase {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Swing Components Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(6, 2));

        // JButton
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked"));

        // JLabel
        JLabel label = new JLabel("This is a JLabel");

        // JTextField
        JTextField textField = new JTextField("Enter text here");

        // JPasswordField
        JPasswordField passwordField = new JPasswordField("password");

        // JTextArea
        JTextArea textArea = new JTextArea("This is a JTextArea\nwith multiple lines");
        textArea.setRows(3);
        textArea.setColumns(20);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);

        // JComboBox
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});

        // JList
        JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});
        JScrollPane listScrollPane = new JScrollPane(list);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Accept Terms");

        // JRadioButton
        JRadioButton radioButton1 = new JRadioButton("Option A");
        JRadioButton radioButton2 = new JRadioButton("Option B");
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);

        // JSpinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        // JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);

        // JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open");
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // JToolBar
        JToolBar toolBar = new JToolBar();
        JButton toolButton = new JButton("Tool Button");
        toolBar.add(toolButton);

        // JTree
        JTree tree = new JTree();
        JScrollPane treeScrollPane = new JScrollPane(tree);

        // Add components to the frame
        frame.add(button);
        frame.add(label);
        frame.add(textField);
        frame.add(passwordField);
        frame.add(textAreaScrollPane);
        frame.add(comboBox);
        frame.add(listScrollPane);
        frame.add(checkBox);
        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(spinner);
        frame.add(progressBar);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(treeScrollPane);

        // Show the frame
        frame.setVisible(true);
    }
}
