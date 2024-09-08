package Pieces;

import java.util.ArrayList;

public abstract class Piece {
    private int[] position;
    private int[] newPosition;

    private ArrayList<Integer>[] potentialPosition;

    public String getName() {
        return "";
    }

    public void calculateAndMarkMoves(int y, int x) {}

    public ArrayList<int[]> getMoves() {
        return null;
    }

    public boolean setNewPosition(int newy, int newx) {return false;}

    public String getColor() {
        return "";
    }

    public boolean getFirstMoveTwoSteps() {
        return false;
    }
}
