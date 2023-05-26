package Vizhalozat;

import javax.swing.*;
import java.util.Objects;

public class ImageExample {
    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;
    private JButton button;

    public ImageExample(){
        icon = new ImageIcon("src/images/bg.jpg");
        label = new JLabel(icon);
        label.setSize(1200,675);

        frame = new JFrame("Hello");
        frame.add(label);
        frame.setSize(1200,675);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
