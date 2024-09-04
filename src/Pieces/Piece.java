package Pieces;

import java.util.ArrayList;

public abstract class Piece {
    private int[] position;
    private int[] newPosition;

    private ArrayList<Integer>[] potentialPosition;

    public String getName() {
        return "";
    }

    public void calculateMoves(int y, int x) {}

    public ArrayList<int[]> getMoves() {
        return null;
    }

    public void setPotentialPosition(int newy, int newx) {}
}
