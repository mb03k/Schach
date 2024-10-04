package Pieces;

import static GameData.Data.currentPlayer;
import static GameData.Data.writePM_PGN;
import Logic.BishopMoves;

import java.util.ArrayList;

public class Bishop extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public Bishop(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = "♗";
        } else {
            ui = "♝";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "B"+color;
    }

    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y, x};

        BishopMoves bm = new BishopMoves();
        bm.setPosition(currentPosition);
        potentialMoves = bm.calculateDiagonal();
        potentialTakes = bm.getPossibleTakesOfPieces();

        writePM_PGN(color, bm.getValuesForPM_PGN());
    }

    public ArrayList<int[]> getPotentialMoves() {
        return this.potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
