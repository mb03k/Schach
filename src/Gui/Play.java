package Gui;

import Pieces.Knight;

import javax.swing.*;
import java.awt.*;

import static GameData.Data.objectPGN;

public class Play {

    private final JFrame frame;
    private int[][] pgn;

    public Play(JFrame frame) {
        this.frame = frame;
    }

    public void setStandardPGN() {
        this.pgn = GameData.Data.pgn;
    }

    public void setSpielfeld() {
        setMenueBar();
        setzeSpielfeldGridLayout();

        // Spielfeld (und Farben) erstellen
        for ( int i=0; i<8; i++ ) { // vertikal
            for ( int j=0; j<8; j++ ) { // horizontal
                setSpielfeldInhalte(i, j);
            }
        }
    }

    public void setSpielfeldInhalte(int i, int j) {
        JPanel btnPanel = new JPanel();

        JButton spielfeldButtonListener = new JButton(objectPGN[i][j].getColor);

        btnPanel.add(spielfeldButtonListener);


        feld[i][j] = btnPanel;
        feld[i][j].setLayout(new GridLayout());

        feld[i][j].setOpaque(true);
        faerbeHintergrund(i, j);


        setSpielfigur(i, j);
    }

    public void setLayoutPieces(int i, int j) {

    }

    private static void faerbeHintergrund(int y, int x) {
        feld[y][x].setBackground(Color.GRAY);
        if (hintergrundIstDunkel(y, x)) { // jedes zweite Feld färben
            feld[y][x].setBackground(Color.DARK_GRAY);
        }
    }

    private static boolean hintergrundIstDunkel(int y, int x) {
        return ((y+x) % 2 == 1);
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
        /*checkerboard = new JPanel();
        checkerboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        checkerboard.setLayout(new GridLayout(8, 8));
        checkerboard.setBackground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.add(checkerboard, gbc);*/

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
    
    public void setSpielfigur(int i, int j) {
        switch (pgn[i][j]) {
            case -1: // Bauer schwarz
                break;

            case -2: // Dame schwarz
                break;

            case 1: // Bauer weiß
                break;

            case 2: // Dame weiß
                break;

            default:
        }
    }

    public void setzeDebugMenuepunkt() {
        // wenn Benutzer Debug-Modus angeklickt hat, neuen Menüpunkt erstellen
        if (modus.equals("debug")) {
            JMenu debug = new JMenu("Debug");
            JMenuItem wBauer = new JMenuItem("Spielfigur - Weiß");
            JMenuItem bBauer = new JMenuItem("Spielfigur - Schwarz");
            JMenuItem wDame = new JMenuItem("Dame - Weiß");
            JMenuItem bDame = new JMenuItem("Dame - Schwarz");
            JMenuItem loeschen = new JMenuItem("Figur löschen");
            JMenuItem spielStarten = new JMenuItem("Spiel starten");

            wDame.addActionListener(e -> debugSetzeSpielfigur(2));
            wBauer.addActionListener(e -> debugSetzeSpielfigur(1));
            bDame.addActionListener(e -> debugSetzeSpielfigur(-2));
            bBauer.addActionListener(e -> debugSetzeSpielfigur(-1));
            loeschen.addActionListener(e -> debugSetzeSpielfigur(0));
            //spielStarten.addActionListener(e -> debugStarten());

            wBauer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bBauer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            wDame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bDame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            loeschen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            wBauer.setBackground(Color.decode("#d4d4d4"));
            wDame.setBackground(Color.decode("#d4d4d4"));
            bBauer.setBackground(Color.decode("#949494"));
            bDame.setBackground(Color.decode("#949494"));
            loeschen.setBackground(Color.decode("#FF7074"));
            spielStarten.setBackground(Color.decode("9498256"));

            debug.add(wDame);
            debug.add(wBauer);
            debug.add(bDame);
            debug.add(bBauer);
            debug.add(loeschen);
            debug.add(spielStarten);
            menueLeiste.add(debug);
        }
    }

    public void setMenueBar() {
        // Menüleiste
        menueLeiste = new JMenuBar();
        JMenu dateiMenue = new JMenu("Datei");
        JMenuItem speichern_menuItem = new JMenuItem("Speichern");
        //speichern_menuItem.addActionListener(e -> spielSpeichern());
        JMenuItem startseite_menuItem = new JMenuItem("Startseite");
        //startseite_menuItem.addActionListener(e -> setzeStartseite());
        JMenuItem beenden_menuItem = new JMenuItem("Beenden");
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
    
    public void debugSetzeSpielfigur(int index) {
        
    }
}
