package Gui;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static GameData.Data.*;
import static java.lang.System.exit;
import static Logic.Logic.*;
import static Gui.PlayingField.*;

public class Play {

    private JFrame frame;
    private JPanel fieldButtonPanel;

    public int[] oldPosition = new int[2];

    private JPanel[][] board;

    public Play() {}

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setPlayingField() {
        setMenuBar();
        fieldButtonPanel = new JPanel();
        setPlayingFieldGridLayout(this.frame, fieldButtonPanel);
        board = new JPanel[8][8];
        setStandardPM_PGN();

        // creates 64 squares with buttons and pieces
        for (int y=0; y<8; y++) { // vertical
            for (int x=0; x<8; x++) { // horizontal
                pgn[y][x].calculateMoves(y, x);
                addPlayingFieldContent(y, x);
            }
        }

        if(kingsInCheck()) {
            kingsInCheck = true;
        } else {
            kingsInCheck = false;
        }
        
        markPotentialMovesWithColor();
        frame.repaint();

        frame.setVisible(true);
    }

    public void addPlayingFieldContent(int y, int x) {
        JPanel btnPanel = new JPanel();
        JButton playingFieldButtonListener;
        String nameOfPiece = pgn[y][x].getUi();
        JLabel emojiLabel = new JLabel(nameOfPiece);
        emojiLabel.setFont(new Font("Dialog", Font.PLAIN, 50));
        
        playingFieldButtonListener = new JButton();
        playingFieldButtonListener.addActionListener(e -> handlePieceClick(y, x));
        playingFieldButtonListener.add(emojiLabel);

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
                board[y][x].setBackground(Color.decode("#769656")); // green - standard color for square
                break;
            case 1:
                board[y][x].setBackground(Color.decode("#eeeed2")); // white - standard color for square
                break;
            case 2:
                board[y][x].setBackground(Color.decode("#faaf6b")); // light orange - potential move
                break;
            case 3:
                board[y][x].setBackground(Color.decode("#ffaeff")); // light magenta - potential take
                break;
            case 4:
                board[y][x].setBackground(Color.decode("#FF8488")); // light red - kings in check
            default:
        }
    }

    public void markPotentialMovesWithColor() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                changeSquareColor(i,j);
            }
        }
    }

    public void clearPotentialMoveColor() {
        setStandardColorPGN();
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                changeSquareColor(i,j);
            }
        }
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

    // Logik muss nichts mehr berechnen. Nur noch die Daten abfragen
    public void handlePieceClick(int y, int x) {

        // have to check if the king is in check. If so only Moves should be available
        // that stop the check of the king -> if no moves are available: we have a winner

        if (isEmptyField(y, x)) {
            clearPotentialMoveColor();
            // if piece can move
            if (pgn[oldPosition[0]][oldPosition[1]].pieceCanBeMoved(y, x)) {
                drawPlayerMoves(y, x);

                oldPosition[0] = y;
                oldPosition[1] = x;
            }
        } else { // player wants to take or calculate moves
            if (playerWantsToTake(y, x) && itsPlayersTurn(oldPosition[0], oldPosition[1])) { // player wants to take
                int[] currentPosition = new int[] {y, x};

                ArrayList<int[]> potentialTakes = new ArrayList<>();
                potentialTakes = pgn[oldPosition[0]][oldPosition[1]].getPotentialTakes();

                if (checkPieceMoveOrTake(currentPosition, potentialTakes)) {
                    drawPlayerMoves(y, x);
                }
            } else if (itsPlayersTurn(y, x)) { // player wants to move (same color-piece was clicked)
                clearPotentialMoveColor();
                setColorPGN(pgn[y][x].getPotentialMoves(), 2);
                setColorPGN(pgn[y][x].getPotentialTakes(), 3);
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

    public void drawPlayerMoves(int y, int x) {
        if (pgn[oldPosition[0]][oldPosition[1]] instanceof Pawn) {
            pgn[oldPosition[0]][oldPosition[1]].setFirstMoveTwoStepsFalse();
        }

        pgn[y][x] = pgn[oldPosition[0]][oldPosition[1]]; // new field
        pgn[oldPosition[0]][oldPosition[1]] = new EmptyField(); // old field

        setOtherPlayer();
        paintPlayingFieldAfterMove();
    }

    public void paintPlayingFieldAfterMove() {
        setStandardColorPGN();
        frame.getContentPane().removeAll();
        setPlayingField();
    }

    public void setHomescreen() {

    }

    public void saveGame() {

    }

    public void quitGame() {
        exit(0);
    }
}