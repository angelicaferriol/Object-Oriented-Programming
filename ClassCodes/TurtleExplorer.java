import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TurtleExplorer {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Turtle Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Turtle Explorer - Learn About Sea Turtles!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(34, 139, 34));
        titleLabel.setPreferredSize(new Dimension(frame.getWidth(), 50));

        // Background Panel
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw an ocean-like gradient background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 102, 102);
                Color color2 = new Color(102, 178, 255);
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Panel for Turtle Image Buttons
        JPanel turtleButtonsPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        turtleButtonsPanel.setOpaque(false);
        turtleButtonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add margin around the grid

        // Define turtle species and their image URLs
        String[][] turtles = {
                {"Green Turtle", "https://upload.wikimedia.org/wikipedia/commons/8/88/Green_turtle_swimming_over_coral_reefs_in_Kona.jpg", "Green turtles are named for the green color of their body fat, not their shells!"},
                {"Loggerhead", "https://upload.wikimedia.org/wikipedia/commons/a/a4/Loggerhead_sea_turtle.jpg", "Loggerheads are known for their large heads and powerful jaws!"},
                {"Hawksbill", "https://upload.wikimedia.org/wikipedia/commons/0/03/Hawksbill_turtle.jpg", "Hawksbills have beautiful shells that were once used for jewelry."},
                {"Leatherback", "https://upload.wikimedia.org/wikipedia/commons/f/f3/Leatherback_turtle.jpg", "Leatherbacks are the largest sea turtles and can dive deeper than 1,000 meters!"},
                {"Olive Ridley", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Olive_ridley_sea_turtle.jpg", "Olive Ridleys are known for their synchronized mass nesting events, called arribadas."}
        };

        // Create buttons for each turtle
        for (String[] turtle : turtles) {
            String name = turtle[0];
            String imageURL = turtle[1];
            String fact = turtle[2];

            // Create a button with an image and name below it
            JButton turtleButton = new JButton(name);
            try {
                // Fetch the image from the URL
                Image image = ImageIO.read(new URL(imageURL));
                turtleButton.setIcon(new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                System.out.println("Failed to load image for " + name + ": " + e.getMessage());
            }
            turtleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            turtleButton.setHorizontalTextPosition(SwingConstants.CENTER);
            turtleButton.setFont(new Font("Arial", Font.PLAIN, 14));
            turtleButton.setPreferredSize(new Dimension(150, 150));
            turtleButton.setBackground(Color.WHITE);
            turtleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // ActionListener for button click
            turtleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // When a turtle button is clicked, display information in the main panel
                    showTurtleFacts(mainPanel, name, imageURL, fact, turtleButtonsPanel);
                }
            });

            turtleButtonsPanel.add(turtleButton);
        }

        // Center the turtle buttons panel inside the main panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(turtleButtonsPanel, BorderLayout.CENTER);

        // Add the center panel to the main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add title label and background to the frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }

    // Function to update the main panel with turtle facts and add a back button
    private static void showTurtleFacts(JPanel mainPanel, String name, String imageURL, String fact, JPanel turtleButtonsPanel) {
        // Clear the current content of the main panel
        mainPanel.removeAll();

        // Create a new panel for displaying the turtle's facts
        JPanel factPanel = new JPanel();
        factPanel.setLayout(new BorderLayout());
        factPanel.setOpaque(false);

        // Turtle image
        JLabel turtleImageLabel = new JLabel();
        try {
            // Fetch the image from the URL
            Image image = ImageIO.read(new URL(imageURL));
            turtleImageLabel.setIcon(new ImageIcon(image.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            System.out.println("Failed to load image for " + name + ": " + e.getMessage());
        }
        turtleImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Turtle name and fact
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setOpaque(false);

        JLabel turtleNameLabel = new JLabel(name, SwingConstants.CENTER);
        turtleNameLabel.setFont(new Font("Serif", Font.BOLD, 24));
        turtleNameLabel.setForeground(Color.WHITE);

        JTextArea factText = new JTextArea(fact);
        factText.setFont(new Font("Arial", Font.PLAIN, 16));
        factText.setWrapStyleWord(true);
        factText.setLineWrap(true);
        factText.setBackground(new Color(0, 102, 102));
        factText.setForeground(Color.WHITE);
        factText.setEditable(false);

        textPanel.add(turtleNameLabel, BorderLayout.NORTH);
        textPanel.add(factText, BorderLayout.CENTER);

        // Add a Back button
        JButton backButton = new JButton("Back to Turtle List");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);

        // ActionListener for back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the back button is clicked, return to the main turtle buttons
                mainPanel.removeAll();
                JPanel centerPanel = new JPanel();
                centerPanel.setLayout(new BorderLayout());
                centerPanel.setOpaque(false);
                centerPanel.add(turtleButtonsPanel, BorderLayout.CENTER);
                mainPanel.add(centerPanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        // Add the components to the factPanel
        factPanel.add(turtleImageLabel, BorderLayout.NORTH);
        factPanel.add(textPanel, BorderLayout.CENTER);
        factPanel.add(backButton, BorderLayout.SOUTH);

        // Add the new panel to the main panel and refresh the UI
        mainPanel.add(factPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
