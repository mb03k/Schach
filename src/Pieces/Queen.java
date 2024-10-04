package Pieces;

import java.util.ArrayList;

import Logic.QueenMoves;
import static GameData.Data.writePM_PGN;

public class Queen extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public Queen(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = "♕";
        } else {
            ui = "♛";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "Q"+color;
    }
    
    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y,x};
        QueenMoves qm = new QueenMoves();
        qm.setPosition(currentPosition);
        potentialMoves = qm.calculateMoves();
        potentialTakes = qm.getPossibleTakesOfPieces();

        ArrayList<int[]> h = qm.getValuesForPM_PGN();

        writePM_PGN(color, h);
    }

    public ArrayList<int[]> getPotentialMoves() {
        return this.potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
