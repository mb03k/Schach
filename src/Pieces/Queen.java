package Pieces;

import Logic.CalculateDiagonals;
import Logic.CalculateHorizontals;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.takePiece;

public class Queen extends Piece {
    private final String color;
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMoves;

    public Queen(String color) {
        this.color = color;
    }

    public String getName() {
        return "Q"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return takePiece(newPosition, potentialMoves);
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

        setColorPGN(potentialMoves);
    }
}
