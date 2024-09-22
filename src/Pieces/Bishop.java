package Pieces;

import Logic.CalculateDiagonals;
import java.util.ArrayList;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.*;

public class Bishop extends Piece {
    private final String color;
    private final String ui;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    private int[] newPosition; // {y,x}
    private int[] position;

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
        return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        // return if piece can move or if piece can be taken
        if (!checkPieceMoveOrTake(newPosition, potentialMoves)) {
            return checkPieceMoveOrTake(newPosition, potentialTakes);
        }
        return true;
    }

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y, x};

        CalculateDiagonals cd = new CalculateDiagonals();
        cd.setPosition(position);
        potentialMoves = cd.calculateDiagonal();
        potentialTakes = cd.getPossibleTakesOfPieces();

        setColorPGN(potentialMoves, 2);
        setColorPGN(potentialTakes, 3);
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
