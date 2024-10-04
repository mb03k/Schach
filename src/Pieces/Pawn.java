package Pieces;

import java.util.ArrayList;

import Logic.PawnMoves;
import static Logic.Logic.*;
import static GameData.Data.*;

public class Pawn extends Piece {
    private int[] currentPosition;
    private int[] potentialNewPosition;
    private final String color;
    private final String ui;
    private boolean firstMoveTwoSteps;

    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public Pawn(String color) {
        this.color = color;
        firstMoveTwoSteps = true;

        if (color.equals("w")) {
            ui = "♙";
        } else {
            ui = "♟";
        }
    }

    public String getUi() {
        return this.ui;
    }

    public String getName() {
        return "P"+color;
    }
    
    public String getColor() {
        return this.color;
    }

    public void calculateMoves(int y, int x) {
        currentPosition = new int[]{y, x};
        PawnMoves pm = new PawnMoves();
        pm.setPosition(currentPosition);
        potentialMoves = pm.calculateMoves();
        potentialTakes = pm.getPossibleTakesOfPieces();

        // HERES A BUG: getValues is null every time
        writePM_PGN(color, pm.getValuesForPM_PGN());
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
