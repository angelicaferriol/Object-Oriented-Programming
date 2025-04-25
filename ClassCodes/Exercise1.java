import javax.swing.*;  
import java.awt.*;    
import java.awt.event.*;  
import javax.swing.border.EmptyBorder;

/**
 * Enhanced login application with modern UI and attempt tracking
 * Implements ActionListener to handle button clicks
 */
public class Exercise1 implements ActionListener {

    private static JLabel userLabel, passwordLabel, success, attemptsLabel;        
    private static JTextField userText;      
    private static JPasswordField passwordText;  
    private static JButton button, resetButton;         
    private static int loginAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static Timer lockoutTimer;

    public static void main(String[] args) {
        // Create and configure the main window
        JFrame frame = new JFrame("BSCS 2-1N Workspace");        
        frame.setSize(400, 300);           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        // Create main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(70, 130, 180); // Steel blue
                Color color2 = new Color(135, 206, 235); // Sky blue
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        // Create login panel with solid background and shadow
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Create shadow effect
                g2d.setColor(new Color(0, 0, 0, 50));
                g2d.fillRoundRect(3, 3, getWidth()-4, getHeight()-4, 20, 20);
                
                // Fill panel with solid color
                g2d.setColor(new Color(248, 249, 250)); // Light gray-white background
                g2d.fillRoundRect(0, 0, getWidth()-4, getHeight()-4, 20, 20);
                
                // Add subtle border
                g2d.setColor(new Color(222, 226, 230));
                g2d.drawRoundRect(0, 0, getWidth()-4, getHeight()-4, 20, 20);
            }
        };

        mainPanel.setLayout(new GridBagLayout());
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        loginPanel.setOpaque(false); // Make panel non-opaque to show custom painting
        
        // Configure GridBagConstraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create title label with custom font
        JLabel titleLabel = new JLabel("Hello, Student!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(44, 62, 80));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);

        // Username components
        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(userLabel, gbc);

        userText = new JTextField(15);
        stylizeField(userText);
        gbc.gridx = 1;
        loginPanel.add(userText, gbc);

        // Password components
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);

        passwordText = new JPasswordField(15);
        stylizeField(passwordText);
        gbc.gridx = 1;
        loginPanel.add(passwordText, gbc);

        // Button Panel for better alignment
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setOpaque(false);

        // Login button with hover effect
        button = createStyledButton("Login", new Color(52, 152, 219));
        buttonPanel.add(button);

        // Reset button
        resetButton = createStyledButton("Reset", new Color(231, 76, 60));
        buttonPanel.add(resetButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(buttonPanel, gbc);

        // Status and attempts labels
        success = new JLabel("", SwingConstants.CENTER);
        success.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        loginPanel.add(success, gbc);

        attemptsLabel = new JLabel("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts), SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        gbc.gridy = 5;
        loginPanel.add(attemptsLabel, gbc);

        // Add action listeners
        button.addActionListener(new Exercise1());
        resetButton.addActionListener(e -> resetFields());

        // Add enter key listener
        KeyAdapter enterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }
        };
        userText.addKeyListener(enterListener);
        passwordText.addKeyListener(enterListener);

        // Add panels to frame
        mainPanel.add(loginPanel);
        frame.add(mainPanel);
        
        // Center frame on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void stylizeField(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        field.setBackground(new Color(255, 255, 255)); // Pure white background
    }

    private static JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        
        // Add hover effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }

    private static void resetFields() {
        userText.setText("");
        passwordText.setText("");
        success.setText("");
        if (loginAttempts < MAX_ATTEMPTS) {
            attemptsLabel.setText("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (loginAttempts >= MAX_ATTEMPTS) {
            success.setText("Account locked. Please wait 30 seconds.");
            success.setForeground(Color.RED);
            return;
        }
    
        String user = userText.getText();
        String password = new String(passwordText.getPassword());
    
        if (user.equals("user") && password.equals("password")) {
            success.setText("Login successful!");
            success.setForeground(new Color(46, 204, 113));
            loginAttempts = 0;
            attemptsLabel.setText("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_ATTEMPTS) {
                success.setText("Account locked. Please wait 30 seconds.");
                success.setForeground(Color.RED);
                attemptsLabel.setText("Account locked");
                button.setEnabled(false);
                
                // Start lockout timer
                lockoutTimer = new Timer(30000, evt -> {
                    loginAttempts = 0;
                    success.setText("Account unlocked. You may try again.");
                    success.setForeground(Color.BLACK);
                    attemptsLabel.setText("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
                    button.setEnabled(true);
                    ((Timer)evt.getSource()).stop();
                });
                lockoutTimer.start();
            } else {
                success.setText("Login failed!");
                success.setForeground(Color.RED);
                attemptsLabel.setText("Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
            }
        }
    }
}