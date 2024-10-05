package Pieces;

import static Logic.Logic.*;
import static GameData.Data.*;
import Logic.KingMoves;

import java.util.ArrayList;

public class King extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;
    private KingMoves km;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public King(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = "♔";
        } else {
            ui = "♚";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "K"+color;
    }
    
    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y, x};
        km = new KingMoves();
        km.setPosition(currentPosition);
        km.addPM_PGN();
        writePM_PGN(color, km.getValuesForPM_PGN());
    }

    public boolean pieceCanBeMoved(int y, int x) {
        this.potentialNewPosition = new int[] {y, x};

        return checkPieceMoveOrTake(potentialNewPosition, potentialMoves);
    }

    public ArrayList<int[]> getPotentialMoves() {
        potentialMoves = km.calculateMoves();
        potentialTakes = km.getPossibleTakesOfPieces();
        return this.potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
