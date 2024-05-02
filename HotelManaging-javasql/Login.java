package hotelmanagement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;

    Login() {
        super("Login");
        setLayout(null);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("images/logins.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 1550, 1000);
        add(backgroundLabel);

        l1 = new JLabel("Username");
        l1.setBounds(620, 430, 100, 30);
        backgroundLabel.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(620, 500, 100, 30);
        backgroundLabel.add(l2);

        t1 = new JTextField();
        t1.setBounds(750, 430, 150, 30);
        backgroundLabel.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(750, 500, 150, 30);
        backgroundLabel.add(t2);

        ImageIcon userIcon = new ImageIcon(ClassLoader.getSystemResource("images/kir.png"));
        Image userImage = userIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledUserIcon = new ImageIcon(userImage);
        JLabel userLabel = new JLabel(scaledUserIcon);
        userLabel.setBounds(1000, 400, 200, 200);
        backgroundLabel.add(userLabel);

        b1 = new JButton("Login");
        b1.setBounds(640, 600, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        backgroundLabel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(780, 600, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        backgroundLabel.add(b2);

        getContentPane().setBackground(Color.WHITE);

        // Set the frame to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                // Replace the following with your actual login logic
                String username = t1.getText();
                String password = new String(t2.getPassword());

                Conn c = new Conn();
String query = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";               ResultSet rs = c.s.executeQuery(query);
               if (rs.next()) {
                System.out.println("Login successful");

                // Create an instance of the Dashboard class and make it visible
                new Dashboard().setVisible(true);
                // Close the current login window
                this.setVisible(false);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                               

               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
                setVisible(false);        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}
