import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment_1_Viray{
    public static void main(String[] args){
        JFrame f;
        JTextField t1,t2;
        JComboBox c1;
        JButton b1;
        JLabel l1;

        f = new JFrame("Calculator");
        f.setSize(400,400);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 75));

        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(100,30));
        t2 = new JTextField();
        t2.setPreferredSize(new Dimension(100, 30));

        String[] operators = {"+", "-", "*", "/"};

        c1 = new JComboBox(operators);

        b1 = new JButton("Calculate");

        l1 = new JLabel("", JLabel.CENTER);

        l1.setPreferredSize(new Dimension(300,30));
        
        f.add(t1);
        f.add(c1);
        f.add(t2);
        f.add(b1);
        f.add(l1);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                boolean valid;
                try{
                    Integer.parseInt(t1.getText());
                    Integer.parseInt(t2.getText());
                    valid = true;
                } catch(NumberFormatException ex){
                    valid = false;
                }
                if(valid){
                String op = (String)c1.getSelectedItem();
                    
                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());
                int result = 0;

                if(op.equals("/") && num2 == 0){
                    l1.setText("Cannot divide by zero");
                }else{
                    if(op.equals("+")){
                        result = num1 + num2;
                    }else if(op.equals("-")){
                        result = num1 - num2;
                    }else if(op.equals("*")){
                        result = num1 * num2;
                    }else if(op.equals("/")){
                        result = num1 / num2;
                    }
                    l1.setText("Result: " + result);
                    }
                }else{
                    l1.setText("Invalid Input");
                }
                
            }
        });
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
} 
