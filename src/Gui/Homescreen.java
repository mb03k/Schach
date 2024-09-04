package Gui;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

public class Homescreen {

    private final JFrame frame;
    private Play play;

    public Homescreen() {
        this.frame = new Frame();
    }

    public void setHomescreen() {
        // design of homescreen
        frame.setLayout(new GridBagLayout());

        JPanel outerContainer = new JPanel(new GridBagLayout());
        JPanel labelContainer = new JPanel(new GridLayout());
        JPanel elementContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel elmContTop = new JPanel (new GridLayout());
        JPanel elmContBottom = new JPanel(new GridLayout());

        JLabel mainLabel = new JLabel("Chess", SwingConstants.CENTER);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 120));
        mainLabel.setForeground(Color.LIGHT_GRAY);

        JButton play = new JButton("Spielen");
        JButton setUpPosition = new JButton("set up position");
        JButton exit = new JButton("Exit");

        play.addActionListener(e -> play());
        setUpPosition.addActionListener(e -> setUpBoard());
        exit.addActionListener(e -> exit(0));

        elmContTop.add(play);
        elmContBottom.add(setUpPosition);
        elmContBottom.add(exit);

        gbc.gridy = 0;
        elementContainer.add(elmContTop, gbc);

        gbc.gridy = 1;
        elementContainer.add(elmContBottom, gbc);


        labelContainer.add(mainLabel);
        gbc.gridx = 0;
        outerContainer.add(labelContainer);
        gbc.gridx = 1;
        outerContainer.add(elementContainer);

        frame.add(outerContainer);
        frame.setVisible(true);
    }

    public void play() {
        frame.getContentPane().removeAll();
        play = new Play(frame);
        play.setStandardPGN();
        play.setSpielfeld();
        frame.repaint();
    }

    public void setUpBoard() {

    }
}
