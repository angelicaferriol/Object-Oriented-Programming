public import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Exercise11 implements ActionListener {
    private static JLabel userLabel, passwordLabel, success;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton loginButton, registerButton, resetButton;
    private static JFrame frame;
    private static int loginAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static Timer lockoutTimer;
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Add some default users
        users.put("user", "password");
        users.put("admin", "admin123");

        frame = new JFrame("Login System");
        JPanel panel = new JPanel();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Set a better layout
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 250)); // Light lavender background

        // Username field
        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Password field
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Login button with hover effect
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        styleButton(loginButton);
        loginButton.addActionListener(new Exercise11());
        panel.add(loginButton);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 80, 90, 25);
        styleButton(registerButton);
        registerButton.addActionListener(e -> showRegistrationDialog());
        panel.add(registerButton);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 80, 80, 25);
        styleButton(resetButton);
        resetButton.addActionListener(e -> resetFields());
        panel.add(resetButton);

        // Status message
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        // Add key listener for Enter key
        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        };
        userText.addKeyListener(enterKeyListener);
        passwordText.addKeyListener(enterKeyListener);

        // Center the frame on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(JButton button) {
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));

        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(65, 105, 225)); // Darker blue
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(100, 149, 237));
            }
        });
    }

    private static void resetFields() {
        userText.setText("");
        passwordText.setText("");
        success.setText("");
    }

    private static void showRegistrationDialog() {
        JDialog dialog = new JDialog(frame, "Register New User", true);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));
        dialog.setSize(300, 150);

        JTextField newUser = new JTextField();
        JPasswordField newPass = new JPasswordField();
        JButton registerBtn = new JButton("Create Account");

        dialog.add(new JLabel("New Username:"));
        dialog.add(newUser);
        dialog.add(new JLabel("New Password:"));
        dialog.add(newPass);
        dialog.add(new JLabel(""));
        dialog.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String username = newUser.getText();
            String password = new String(newPass.getPassword());
            
            if (username.length() < 3 || password.length() < 3) {
                JOptionPane.showMessageDialog(dialog, 
                    "Username and password must be at least 3 characters long!");
                return;
            }
            
            if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(dialog, "Username already exists!");
                return;
            }

            users.put(username, password);
            JOptionPane.showMessageDialog(dialog, "Registration successful!");
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        if (loginAttempts >= MAX_ATTEMPTS) {
            success.setText("Account locked. Please wait 30 seconds.");
            success.setForeground(Color.RED);
            return;
        }

        if (users.containsKey(user) && users.get(user).equals(password)) {
            success.setText("Login successful!");
            success.setForeground(new Color(0, 128, 0)); // Dark green
            loginAttempts = 0;
            
            // Show welcome dialog
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(frame,
                    "Welcome " + user + "!\nYou have successfully logged in.",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE);
            });
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_ATTEMPTS) {
                success.setText("Account locked. Please wait 30 seconds.");
                success.setForeground(Color.RED);
                
                // Start lockout timer
                lockoutTimer = new Timer(30000, evt -> {
                    loginAttempts = 0;
                    success.setText("Account unlocked. You may try again.");
                    success.setForeground(Color.BLACK);
                    ((Timer)evt.getSource()).stop();
                });
                lockoutTimer.start();
            } else {
                success.setText("Login failed! Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts));
                success.setForeground(Color.RED);
            }
        }
    }
} {
    
}
