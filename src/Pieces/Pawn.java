package Pieces;

import Logic.CalculateHorizontals;
import Logic.PawnMoves;

import java.util.ArrayList;
import static GameData.Data.setColorPGN;

public class Pawn extends Piece {
    private int[] position;
    private final String color;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private boolean firstMoveTwoSteps;

    public Pawn(String color) {
        this.color = color;
        firstMoveTwoSteps = true;
    }

    public String getName() {
        return "P"+color;
    }

    public String getColor() {return this.color;}

    public boolean getFirstMoveTwoSteps() {
        return this.firstMoveTwoSteps;
    }

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y, x};

        PawnMoves pm = new PawnMoves();
        pm.setPosition(position);
        potentialMoves = pm.calculateMoves();

        setColorPGN(potentialMoves);
    }
}
