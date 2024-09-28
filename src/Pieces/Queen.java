package Pieces;

import Logic.QueenMoves;

import java.util.ArrayList;
import static GameData.Data.*;

import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Queen extends Piece {
    private final String color;
    private final String ui;
    private int[] position;
    private int[] newPosition;
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

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y,x};
        QueenMoves qm = new QueenMoves();
        qm.setPosition(position);
        potentialMoves = qm.calculateMoves();
        potentialTakes = qm.getPossibleTakesOfPieces();

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
