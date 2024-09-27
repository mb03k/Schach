package Pieces;

import Logic.CalculateDiagonals;
import Logic.KingMoves;

import java.util.ArrayList;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class King extends Piece {
    private final String color;
    private final String ui;
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialTakes;
    private ArrayList<int[]> potentialMoves;

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

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y, x};

        KingMoves km = new KingMoves();
        km.setPosition(position);
        potentialMoves = km.calculateMoves();
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
