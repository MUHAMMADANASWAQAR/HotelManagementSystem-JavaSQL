package hotelmanagement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1;

    public HotelManagementSystem() {

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(screenSize.width, screenSize.height); // set frame size to full screen
        setLayout(null);
        setLocation(0, 0); // set location to top-left corner

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(new Color(255, 69, 0)); // Set a color for the "Next" button
        b1.setForeground(Color.WHITE); // Set text color to white

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/hotel1.png"));
        Image i3 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        JLabel lid = new JLabel("HOTEL MANAGEMENT SYSTEM");
        lid.setBounds(30, screenSize.height / 2 + 150, screenSize.width - 60, 100);
        lid.setFont(new Font("serif", Font.PLAIN, 70));
        lid.setForeground(Color.red);
        l1.add(lid);

        b1.setBounds(screenSize.width - 170, screenSize.height / 2 + 250, 150, 50);
        l1.setBounds(0, 0, screenSize.width, screenSize.height);

       l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

        while (true) {
            lid.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            lid.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
    }
}
