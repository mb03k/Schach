package Gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        super("Schach");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(750, 770);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500, 450));
        this.setVisible(true);
    }

    public JFrame getJFrame() {
        return this;
    }
}