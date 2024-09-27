package Pieces;

import Logic.CalculateDiagonals;
import Logic.CalculateHorizontals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Queen extends Piece {
    private final String color;
    private final String ui;
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();
    private ArrayList<int[]> potentialTakesHorizontal = new ArrayList<>();
    private ArrayList<int[]> potentialTakesVertical = new ArrayList<>();

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
        potentialMoves = new ArrayList<>();
        ArrayList<int[]> potentialDiagonals;
        ArrayList<int[]> potentialHorizontals;

        CalculateDiagonals cd = new CalculateDiagonals();
        CalculateHorizontals ch = new CalculateHorizontals();

        cd.setPosition(position);
        ch.setPosition(position);

        potentialDiagonals = cd.calculateDiagonal();
        potentialHorizontals = ch.calculateHorizontals();

        // behaves very strange if you can take multiple pieces
        potentialTakesHorizontal = ch.getPossibleTakesOfPieces();
        potentialTakesVertical = cd.getPossibleTakesOfPieces();

        potentialTakes.addAll(potentialTakesHorizontal);
        potentialTakes.addAll(potentialTakesVertical);

        potentialMoves.addAll(potentialDiagonals);
        potentialMoves.addAll(potentialHorizontals);
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
