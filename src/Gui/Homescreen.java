package Gui;

import javax.swing.*;
import java.awt.*;

import static Gui.Play.setCurrentPlayer;
import static java.lang.System.exit;

public class Homescreen {

    private JFrame frame;

    public Homescreen() {}

    public void setFrame(JFrame frame) {
        this.frame = frame;
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

        JLabel mainLabel = new JLabel("Dame", SwingConstants.CENTER);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 120));
        mainLabel.setForeground(Color.LIGHT_GRAY);

        JButton play = new JButton("Spielen");
        JButton setUpPosition = new JButton("Position erstellen");
        JButton exit = new JButton("Verlassen");

        // action listener
        play.addActionListener(e -> play());
        setUpPosition.addActionListener(e -> setUpBoard());
        exit.addActionListener(e -> exit(0));

        // add buttons to panel
        elmContTop.add(play);
        elmContBottom.add(setUpPosition);
        elmContBottom.add(exit);

        // set grid of elements
        labelContainer.add(mainLabel);
        gbc.gridy = 0;
        elementContainer.add(elmContTop, gbc);
        gbc.gridy = 1;
        elementContainer.add(elmContBottom, gbc);
        gbc.gridx = 0;
        outerContainer.add(labelContainer);
        gbc.gridx = 1;
        outerContainer.add(elementContainer);

        frame.add(outerContainer);
        frame.setVisible(true);
    }

    public void play() {
        frame.getContentPane().removeAll();

        Play play = new Play();
        play.setFrame(frame);
        setCurrentPlayer("b");
        play.setPlayingField();

        frame.repaint();
    }

    public void setUpBoard() {

    }
}
