package Pieces;

import Logic.CalculateDiagonals;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece {
    private final String color;
    private ArrayList<int[]> potentialMoves;

    private int[] position; // {y,x}
    private int[] newPosition; // {y,x}

    public Bishop(String color) {
        this.color = color;
    }

    public String getName() {
        return "B"+color;
    }

    public void setPotentialPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};
    }


    public void calculateMoves(int y, int x) {
        potentialMoves = new ArrayList<>();
        this.position = new int[] {y, x};

        CalculateDiagonals cd = new CalculateDiagonals(position);
        potentialMoves = cd.calculateDiagonal();

        System.out.println("Möglichkeiten:");
        for (int[] potentialMove : potentialMoves) {
            System.out.print(Arrays.toString(potentialMove));
        }
        System.out.println(potentialMoves.size());
    }


    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }
}
