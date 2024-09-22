package Pieces;

import Logic.CalculateHorizontals;
import Logic.PawnMoves;

import java.util.ArrayList;
import static GameData.Data.setColorPGN;
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

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y, x};

        PawnMoves pm = new PawnMoves();
        pm.setPosition(position);
        potentialMoves = pm.calculateMoves();
        potentialTakes = pm.getPossibleTakesOfPieces();

        setColorPGN(potentialMoves, 2);
        setColorPGN(potentialTakes, 3);
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
