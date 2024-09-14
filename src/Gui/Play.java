package Gui;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.*;
import static Logic.CheckRequirements.*;
import static java.lang.String.valueOf;
import static java.lang.System.exit;

public class Play {

    private JFrame frame;
    private JPanel fieldButtonPanel;
    public static String currentPlayer;

    public int[] oldPosition = new int[2];

    private JPanel[][] board;

    public Play() {}

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPlayingField() {
        setMenuBar();
        setPlayingFieldGridLayout();
        board = new JPanel[8][8];

        // creates 64 squares with buttons and pieces
        for (int y=0; y<8; y++) { // vertical
            for (int x=0; x<8; x++) { // horizontal
                addPlayingFieldContent(y, x);
            }
        }

        frame.setVisible(true);
    }

    public void addPlayingFieldContent(int y, int x) {
        JPanel btnPanel = new JPanel();
        JButton playingFieldButtonListener;

        char nameOfPiece = pgn[y][x].getUi();
        if (nameOfPiece == 'e') {
            playingFieldButtonListener = new JButton();
        } else {
            playingFieldButtonListener = new JButton(valueOf(nameOfPiece));
        }

        playingFieldButtonListener.setFont(new Font("Verdana", Font.PLAIN, 50));
        playingFieldButtonListener.setBorder(BorderFactory.createLineBorder(Color.RED));
        playingFieldButtonListener.addActionListener(e -> handlePieceClick(y, x));

        // make button invisible
        playingFieldButtonListener.setBorderPainted(false);
        playingFieldButtonListener.setContentAreaFilled(false);
        playingFieldButtonListener.setFocusPainted(false);
        playingFieldButtonListener.setOpaque(false);

        btnPanel.add(playingFieldButtonListener);
        board[y][x] = btnPanel;
        board[y][x].setLayout(new GridLayout());
        changeSquareColor(y, x);
        fieldButtonPanel.add(btnPanel);
    }

    public void changeSquareColor(int y, int x) {
        switch(colorPGN[y][x]) {
            case 0:
                board[y][x].setBackground(Color.GRAY);
                break;
            case 1:
                board[y][x].setBackground(Color.LIGHT_GRAY);
                break;
            case 2:
                board[y][x].setBackground(Color.ORANGE);
                break;
            case 3:
                board[y][x].setBackground(Color.MAGENTA);
            default:
        }
    }

    public void markPotentialMovesWithColor() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                changeSquareColor(i,j);
            }
        }
        frame.repaint();
    }

    public void clearPotentialMoveColor() {
        setStandardColorPGN();
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                changeSquareColor(i,j);
            }
        }
        frame.repaint();
    }

    public void setPlayingFieldGridLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 0);

        JPanel letterPanel = new JPanel(new GridLayout(1, 8));
        letterPanel.setBackground(Color.DARK_GRAY);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0.05;
        frame.add(letterPanel, gbc);

        JPanel numberPanel = new JPanel(new GridLayout(8, 1));
        numberPanel.setBackground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(numberPanel, gbc);

        setzeSpielfeldMarkierungen(letterPanel, numberPanel);
        erzeugeSpielfeldGUI(gbc);
    }

    public void setzeSpielfeldMarkierungen(JPanel letterPanel, JPanel numberPanel) {
        // Panel for labels (A-H)
        for (int iterator = 0; iterator < 8; iterator++) {
            JLabel letterLabel = new JLabel(valueOf((char) ('a' + iterator)), SwingConstants.CENTER);
            letterLabel.setForeground(Color.WHITE);
            letterLabel.setFont(new Font("Arial", Font.BOLD, 20));
            letterPanel.add(letterLabel);
        }
        // Panel for labels (1-8)
        for (int num=8; num>0; num--) {
            JLabel numberLabel = new JLabel(valueOf(num), SwingConstants.CENTER);
            numberLabel.setForeground(Color.WHITE);
            numberLabel.setFont(new Font("Arial", Font.BOLD, 20));
            numberLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Abstand Rand
            numberPanel.add(numberLabel);
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

        // create and add edges
        JPanel leftEdge = new JPanel();
        JPanel rightEdge = new JPanel();
        leftEdge.setBackground(Color.DARK_GRAY);
        rightEdge.setBackground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(leftEdge, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.8;
        frame.add(rightEdge, gbc);
    }

    public void setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Datei");

        JMenuItem saveMenuItem = new JMenuItem("Speichern");
        JMenuItem homescreenMenuItem = new JMenuItem("Startseite");
        JMenuItem quitMenuItem = new JMenuItem("Beenden");

        saveMenuItem.addActionListener(e -> saveGame());
        homescreenMenuItem.addActionListener(e -> setHomescreen());
        quitMenuItem.addActionListener(e -> quitGame());

        saveMenuItem.setBackground(Color.decode("#92C7CF"));
        homescreenMenuItem.setBackground(Color.decode("#AAD7D9"));
        quitMenuItem.setBackground(Color.decode("#91C8E4"));

        fileMenu.add(saveMenuItem);
        fileMenu.add(homescreenMenuItem);
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    public void handlePieceClick(int y, int x) {
        // player wants to move
        if (pgn[y][x] instanceof EmptyField) {
            clearPotentialMoveColor();
            // if piece can move
            if (pgn[oldPosition[0]][oldPosition[1]].setNewPosition(y, x)) {

                pgn[y][x] = pgn[oldPosition[0]][oldPosition[1]]; // new field
                pgn[oldPosition[0]][oldPosition[1]] = new EmptyField(); // old field

                paintPlayingFieldAfterTake();
            }
        } else { // player wants to take or calculate moves
            if (playerWantsToTake(y, x)) {
                clearPotentialMoveColor();
                ArrayList<int[]> potentialMoves = pgn[oldPosition[0]][oldPosition[1]].getPotentialTakes();

                if (checkPieceMoveOrTake(new int[]{y,x}, potentialMoves)) {
                    pgn[y][x] = pgn[oldPosition[0]][oldPosition[1]];
                    pgn[oldPosition[0]][oldPosition[1]] = new EmptyField();
                    paintPlayingFieldAfterTake();
                }
            } else if (itsPlayersTurn(y, x)) {
                clearPotentialMoveColor();
                checkSequenceAndCalculateMoves(y, x);
                markPotentialMovesWithColor();

                oldPosition[0] = y;
                oldPosition[1] = x;
            }
        }
    }

    public boolean playerWantsToTake(int y, int x) {
        // white clicks black piece or inverse
        return currentPlayer.equals("w") && pgn[y][x].getColor().equals("b")
                || currentPlayer.equals("b") && pgn[y][x].getColor().equals("w");
    }

    public boolean itsPlayersTurn(int y, int x) {
        return currentPlayer.equals("w") && pgn[y][x].getColor().equals("w")
                || currentPlayer.equals("b") && pgn[y][x].getColor().equals("b");
    }

    public void paintPlayingFieldAfterTake() {
        frame.getContentPane().removeAll();
        frame.repaint();
        setPlayingField();
    }

    public static void setCurrentPlayer(String cp) {
        currentPlayer = cp;
    }

    public static String getCurrentPlayer() {
        return currentPlayer;
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
