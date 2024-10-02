package Pieces;

import Logic.PawnMoves;

import java.util.ArrayList;
import static GameData.Data.*;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Pawn extends Piece {
    private int[] position;
    private final String ui;
    private int[] newPosition;
    private final String color;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();
    private boolean firstMoveTwoSteps;

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

    public String getColor() {return this.color;}

    public boolean getFirstMoveTwoSteps() {
        return this.firstMoveTwoSteps;
    }

    public void setFirstMoveTwoStepsFalse() {
        this.firstMoveTwoSteps = false;
    }

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y, x};
        PawnMoves pm = new PawnMoves();
        pm.setPosition(position);
        potentialMoves = pm.calculateMoves();
        potentialTakes = pm.getPossibleTakesOfPieces();
        ArrayList<int[]> valuesPM = pm.getValuesForPM_PGN();

        // HERES A BUG: getValues is null every time
        writePM_PGN(color, valuesPM);
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
