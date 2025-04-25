import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class WhaleExplorer {

    public static void main(String[] args) {
        // Create main JFrame
        JFrame frame = new JFrame("Whale Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Whale Explorer - Learn About Whales!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 102, 153));
        titleLabel.setPreferredSize(new Dimension(frame.getWidth(), 50));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Background Panel
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Ocean-themed background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(102, 178, 255);
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Panel for Whale Buttons
        JPanel whaleButtonsPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        whaleButtonsPanel.setOpaque(false);
        whaleButtonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add margin

        // Define whale species, image URLs, and their detailed information
        String[][] whales = {
            {"Blue Whale", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Anim1754_-_Flickr_-_NOAA_Photo_Library.jpg/800px-Anim1754_-_Flickr_-_NOAA_Photo_Library.jpg", 
             "The blue whale is the largest animal ever known to have lived. It can grow up to 98 feet long and weigh up to 199 tons."},
            {"Humpback Whale", "https://upload.wikimedia.org/wikipedia/commons/5/52/Humpback_whale_underwater_shot.jpg", 
             "Humpback whales are known for their acrobatics and complex songs. They migrate thousands of miles annually."},
            {"Sperm Whale", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Sperm_whale.jpg/800px-Sperm_whale.jpg", 
             "Sperm whales are the largest toothed predators. They dive up to 7,380 feet deep to hunt for squid."},
            {"Beluga Whale", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Beluga_Whale.jpg/800px-Beluga_Whale.jpg", 
             "Beluga whales are called 'canaries of the sea' because of their varied vocalizations."},
            {"Orca (Killer Whale)", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Killerwhales_jumping.jpg/800px-Killerwhales_jumping.jpg", 
             "Orcas are apex predators and highly intelligent social animals. They are found in every ocean."},
            {"Gray Whale", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Gray_whale_%28Eschrichtius_robustus%29_-_underwater.jpg/800px-Gray_whale_%28Eschrichtius_robustus%29_-_underwater.jpg", 
             "Gray whales undertake the longest migration of any mammal, traveling up to 14,000 miles annually."}
        };

        // Create buttons for each whale
        for (String[] whale : whales) {
            String name = whale[0];
            String imageURL = whale[1];
            String description = whale[2];

            JButton whaleButton = new JButton(name);
            try {
                // Use URL to load the image from the web
                URL imageUrl = new URL(imageURL);
                whaleButton.setIcon(new ImageIcon(imageUrl));
            } catch (Exception e) {
                e.printStackTrace();
            }

            whaleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            whaleButton.setHorizontalTextPosition(SwingConstants.CENTER);
            whaleButton.setFont(new Font("Arial", Font.PLAIN, 14));
            whaleButton.setBackground(Color.WHITE);
            whaleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            whaleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showWhaleInfo(mainPanel, name, imageURL, description, whaleButtonsPanel);
                }
            });

            whaleButtonsPanel.add(whaleButton);
        }

        // Add whale buttons to a scroll pane for scrolling functionality
        JScrollPane whaleScrollPane = new JScrollPane(whaleButtonsPanel);
        whaleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        whaleScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Center the whale buttons panel with scroll
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.add(whaleScrollPane);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add JComboBox for additional options
        String[] options = {"View Creator", "About Whale Explorer"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            if (selected.equals("View Creator")) {
                JOptionPane.showMessageDialog(frame, "Created by [Your Name Here]!", "Creator Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (selected.equals("About Whale Explorer")) {
                JOptionPane.showMessageDialog(frame, "Whale Explorer is an educational tool to learn about whales.", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setOpaque(false);
        topPanel.add(comboBox);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Add everything to the frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }

    private static void showWhaleInfo(JPanel mainPanel, String name, String imageURL, String description, JPanel whaleButtonsPanel) {
        mainPanel.removeAll();

        // Create a panel for whale details
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);

        // Add whale image
        try {
            URL imageUrl = new URL(imageURL);
            JLabel imageLabel = new JLabel(new ImageIcon(imageUrl));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            infoPanel.add(imageLabel, BorderLayout.NORTH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add whale description
        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        infoPanel.add(scrollPane, BorderLayout.CENTER);

        // Add Back button
        JButton backButton = new JButton("Back to Whale List");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(e -> {
            mainPanel.removeAll();
            mainPanel.add(whaleButtonsPanel, BorderLayout.CENTER);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        infoPanel.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
