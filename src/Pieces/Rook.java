package Pieces;

import Logic.RookMoves;
import java.util.ArrayList;
import static GameData.Data.writePM_PGN;

public class Rook extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public Rook(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = "♖";
        } else {
            ui = "♜";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "R"+color;
    }
    
    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y,x};

        RookMoves rm = new RookMoves();
        rm.setPosition(currentPosition);
        potentialMoves = rm.calculateHorizontals();
        potentialTakes = rm.getPossibleTakesOfPieces();

        writePM_PGN(color, rm.getValuesForPM_PGN());
    }

    public ArrayList<int[]> getPotentialMoves() {
        return this.potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
