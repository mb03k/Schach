package Pieces;

import java.util.ArrayList;

import static Logic.CheckRequirements.takePiece;

public class Queen extends Piece {
    private final String color;
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
}
