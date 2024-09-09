package Pieces;

import Logic.CalculateDiagonals;
import Logic.CalculateHorizontals;

import java.util.ArrayList;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.checkPieceTake;

public class Queen extends Piece {
    private final String color;
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();

    public Queen(String color) {
        this.color = color;
    }

    public String getName() {
        return "Q"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceTake(newPosition, potentialMoves);
    }

    public void calculateAndMarkMoves(int y, int x) {
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

        potentialMoves.addAll(potentialDiagonals);
        potentialMoves.addAll(potentialHorizontals);

        setColorPGN(potentialMoves, 2);
        setColorPGN(potentialTakes, 3);
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
