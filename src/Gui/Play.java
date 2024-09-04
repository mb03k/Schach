package Gui;

import Pieces.*;

import javax.swing.*;
import java.awt.*;

import static GameData.Data.objectPGN;

public class Play {

    private final JFrame frame;
    private int[][] pgn;
    private JPanel checkerboard; // rauswerfen

    private JPanel[][] board;

    public Play(JFrame frame) {
        this.frame = frame;
    }

    public void setStandardPGN() {
        this.pgn = GameData.Data.pgn;
    }

    public void setSpielfeld() {
        setMenueBar();
        setzeSpielfeldGridLayout();
        board = new JPanel[8][8];

        // Spielfeld (und Farben) erstellen
        for (int i=0; i<8; i++) { // vertikal
            for (int j=0; j<8; j++) { // horizontal
                setSpielfeldInhalte(i, j);
            }
        }

        frame.setVisible(true);
    }

    public void setSpielfeldInhalte(int i, int j) {
        JPanel btnPanel = new JPanel();

        setLayoutPieces(i, j);

        JButton spielfeldButtonListener = new JButton(objectPGN[i][j].getColor());
        btnPanel.add(spielfeldButtonListener);

        checkerboard.add(btnPanel);

        board[i][j] = btnPanel;
        board[i][j].setLayout(new GridLayout());
    }

    public void setLayoutPieces(int i, int j) {
        switch(pgn[i][j]) {
            case 1:
                objectPGN[i][j] = new Pawn("white");
                break;
            case 2:
                objectPGN[i][j] = new Bishop("white");
                break;
            case 3:
                objectPGN[i][j] = new Knight("white");
                break;
            case 4:
                objectPGN[i][j] = new Rook("white");
                break;
            case 5:
                objectPGN[i][j] = new Queen("white");
                break;
            case 6:
                objectPGN[i][j] = new King("white");
                break;
            case -1:
                objectPGN[i][j] = new Pawn("black");
                break;
            case -2:
                objectPGN[i][j] = new Bishop("black");
                break;
            case -3:
                objectPGN[i][j] = new Knight("black");
                break;
            case -4:
                objectPGN[i][j] = new Rook("black");
                break;
            case -5:
                objectPGN[i][j] = new Queen("black");
                break;
            case -6:
                objectPGN[i][j] = new King("black");
                break;
            default:
                objectPGN[i][j] = new EmptyField();
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
        checkerboard = new JPanel();
        checkerboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        checkerboard.setLayout(new GridLayout(8, 8));
        checkerboard.setBackground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.add(checkerboard, gbc);

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

    public void setMenueBar() {
        JMenuBar menueLeiste = new JMenuBar();
        JMenu dateiMenue = new JMenu("Datei");

        JMenuItem speichern_menuItem = new JMenuItem("Speichern");
        JMenuItem startseite_menuItem = new JMenuItem("Startseite");
        JMenuItem beenden_menuItem = new JMenuItem("Beenden");

        //speichern_menuItem.addActionListener(e -> spielSpeichern());
        //startseite_menuItem.addActionListener(e -> setzeStartseite());
        //beenden_menuItem.addActionListener(e -> spielBeenden());

        speichern_menuItem.setBackground(Color.decode("#92C7CF"));
        startseite_menuItem.setBackground(Color.decode("#AAD7D9"));
        beenden_menuItem.setBackground(Color.decode("#91C8E4"));

        dateiMenue.add(speichern_menuItem);
        dateiMenue.add(startseite_menuItem);
        dateiMenue.add(beenden_menuItem);
        menueLeiste.add(dateiMenue);
        frame.setJMenuBar(menueLeiste);
    }
}
