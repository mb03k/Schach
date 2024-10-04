package Pieces;

import static Logic.Logic.*;
import static GameData.Data.*;

import java.util.ArrayList;

import Logic.KnightMoves;

public class Knight extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

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

    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y, x};

        KnightMoves ck = new KnightMoves();
        ck.setPosition(currentPosition);
        potentialMoves = ck.calculateMoves();
        potentialTakes = ck.getPossibleTakesOfPieces();

        writePM_PGN(color, ck.getValuesForPM_PGN());
    }

    public boolean pieceCanBeMoved(int y, int x) {
        this.potentialNewPosition = new int[] {y, x};

        return checkPieceMoveOrTake(potentialNewPosition, potentialMoves);
    }

    public ArrayList<int[]> getPotentialMoves() {
        return this.potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
