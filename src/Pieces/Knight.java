package Pieces;

import Logic.KnightMoves;
import java.util.ArrayList;
import static GameData.Data.*;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Knight extends Piece {
    private final String color;
    private final String ui;
    private int[] position;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();
    private int[] newPosition;

    public Knight(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = "♘";
        } else {
            ui = "♞";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "N"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y,x};

        KnightMoves ck = new KnightMoves();
        ck.setPosition(position);
        potentialMoves = ck.calculateMoves();
        potentialTakes = ck.getPossibleTakesOfPieces();

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
