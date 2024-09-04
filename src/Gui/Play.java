package Gui;

import Pieces.*;

import javax.swing.*;
import java.awt.*;

import static GameData.Data.colorPGN;
import static GameData.Data.objectPGN;
import static java.lang.System.exit;

public class Play {

    private JFrame frame;
    private int[][] pgn;
    private JPanel fieldButtonPanel;

    private JPanel[][] board;

    public Play() {}

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setSpielfeld() {
        setMenuBar();
        setzeSpielfeldGridLayout();
        board = new JPanel[8][8];

        // creates 64 squares with buttons and pieces
        for (int y=0; y<8; y++) { // vertical
            for (int x=0; x<8; x++) { // horizontal
                setSpielfeldInhalte(y, x);
            }
        }

        frame.setVisible(true);
    }

    public void setSpielfeldInhalte(int y, int x) {
        setLayoutPieces(y, x);

        JPanel btnPanel = new JPanel();
        String nameOfPiece = objectPGN[y][x].getName();

        JButton spielfeldButtonListener = new JButton(nameOfPiece);
        spielfeldButtonListener.setFont(new Font("Verdana", Font.PLAIN, 25));
        spielfeldButtonListener.setBorder(BorderFactory.createLineBorder(Color.RED));

        // make button invisible
        spielfeldButtonListener.setBorderPainted(false);
        spielfeldButtonListener.setContentAreaFilled(false);
        spielfeldButtonListener.setFocusPainted(false);
        spielfeldButtonListener.setOpaque(false);

        btnPanel.add(spielfeldButtonListener);
        board[y][x] = btnPanel;
        board[y][x].setLayout(new GridLayout());
        changeSquareColor(y, x);
        fieldButtonPanel.add(btnPanel);
    }

    public void setLayoutPieces(int y, int x) {
        switch(pgn[y][x]) {
            case 1:
                objectPGN[y][x] = new Pawn("w");
                break;
            case 2:
                objectPGN[y][x] = new Bishop("w");
                break;
            case 3:
                objectPGN[y][x] = new Knight("w");
                break;
            case 4:
                objectPGN[y][x] = new Rook("w");
                break;
            case 5:
                objectPGN[y][x] = new Queen("w");
                break;
            case 6:
                objectPGN[y][x] = new King("w");
                break;
            case -1:
                objectPGN[y][x] = new Pawn("b");
                break;
            case -2:
                objectPGN[y][x] = new Bishop("b");
                break;
            case -3:
                objectPGN[y][x] = new Knight("b");
                break;
            case -4:
                objectPGN[y][x] = new Rook("b");
                break;
            case -5:
                objectPGN[y][x] = new Queen("b");
                break;
            case -6:
                objectPGN[y][x] = new King("b");
                break;
            default:
                objectPGN[y][x] = new EmptyField();
        }
    }

    public void changeSquareColor(int y, int x) {
        if (colorPGN[y][x] == 0) {
            board[y][x].setBackground(Color.GRAY);
        } else if (colorPGN[y][x] == 1) {
            board[y][x].setBackground(Color.LIGHT_GRAY);
        } else if (colorPGN[y][x] == 2) {
            board[y][x].setBackground(Color.ORANGE);
        }
    }

    public void setzeSpielfeldGridLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 0);

        // Panel fuer labels (A-H)
        JPanel buchstabenPanel = new JPanel(new GridLayout(1, 8));
        buchstabenPanel.setBackground(Color.DARK_GRAY);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0.05;
        frame.add(buchstabenPanel, gbc);

        // Panel fuer labels (1-8)
        JPanel nummernPanel = new JPanel(new GridLayout(8, 1));
        nummernPanel.setBackground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(nummernPanel, gbc);

        setzeSpielfeldMarkierungen(buchstabenPanel, nummernPanel);
        erzeugeSpielfeldGUI(gbc);
    }

    public void setzeSpielfeldMarkierungen(JPanel buchstabenPanel, JPanel nummernPanel) {
        for (int iterator = 0; iterator < 8; iterator++) {
            JLabel letterLabel = new JLabel(String.valueOf((char) ('a' + iterator)), SwingConstants.CENTER);
            letterLabel.setForeground(Color.WHITE);
            letterLabel.setFont(new Font("Arial", Font.BOLD, 20));
            buchstabenPanel.add(letterLabel);
        }
        for (int num=8; num>0; num--) {
            JLabel nummernLabel = new JLabel(String.valueOf(num), SwingConstants.CENTER);
            nummernLabel.setForeground(Color.WHITE);
            nummernLabel.setFont(new Font("Arial", Font.BOLD, 20));
            nummernLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Abstand Rand
            nummernPanel.add(nummernLabel);
        }
    }

    public void erzeugeSpielfeldGUI(GridBagConstraints gbc) {
        // Spielfeld
        fieldButtonPanel = new JPanel();
        fieldButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fieldButtonPanel.setLayout(new GridLayout(8, 8));
        fieldButtonPanel.setBackground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.add(fieldButtonPanel, gbc);

        // Raender erstellen
        JPanel linksRand = new JPanel();
        linksRand.setBackground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(linksRand, gbc);

        JPanel rechtsRand = new JPanel();
        rechtsRand.setBackground(Color.DARK_GRAY);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(rechtsRand, gbc);
    }

    public void setMenuBar() {
        JMenuBar menueLeiste = new JMenuBar();
        JMenu dateiMenue = new JMenu("Datei");

        JMenuItem speichern_menuItem = new JMenuItem("Speichern");
        JMenuItem startseite_menuItem = new JMenuItem("Startseite");
        JMenuItem beenden_menuItem = new JMenuItem("Beenden");

        speichern_menuItem.addActionListener(e -> saveGame());
        startseite_menuItem.addActionListener(e -> setHomescreen());
        beenden_menuItem.addActionListener(e -> quitGame());

        speichern_menuItem.setBackground(Color.decode("#92C7CF"));
        startseite_menuItem.setBackground(Color.decode("#AAD7D9"));
        beenden_menuItem.setBackground(Color.decode("#91C8E4"));

        dateiMenue.add(speichern_menuItem);
        dateiMenue.add(startseite_menuItem);
        dateiMenue.add(beenden_menuItem);
        menueLeiste.add(dateiMenue);
        frame.setJMenuBar(menueLeiste);
    }

    public void setStandardPGN() {
        this.pgn = GameData.Data.pgn;
    }

    public void setHomescreen() {
        frame.getContentPane().removeAll();
        frame.setJMenuBar(null);
        frame.repaint();
        Homescreen sb = new Homescreen();
        sb.setFrame(frame);
        sb.setHomescreen();
    }

    public void saveGame() {

    }

    public void quitGame() {
        exit(0);
    }
}
