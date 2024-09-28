package Pieces;

import java.util.ArrayList;
import static GameData.Data.*;
import Logic.CalculateHorizontals;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Rook extends Piece {
    private final String color;
    private final String ui;
    private int[] position;
    private int[] newPosition;
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

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y,x};

        CalculateHorizontals ch = new CalculateHorizontals();
        ch.setPosition(position);
        potentialMoves = ch.calculateHorizontals();
        potentialTakes = ch.getPossibleTakesOfPieces();

        writePM_PGN(color, potentialMoves, potentialTakes);
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
