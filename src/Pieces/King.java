package Pieces;

import java.util.ArrayList;

import static Logic.CheckRequirements.takePiece;

public class King extends Piece {
    private final String color;
    private int[] newPosition;
    private ArrayList<int[]> potentialMoves;

    public King(String color) {
        this.color = color;
    }

    public String getName() {
        return "K"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return takePiece(newPosition, potentialMoves);
    }

}
