package Pieces;

import Logic.CalculateDiagonals;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.setColorPGN;

public class Bishop extends Piece {
    private final String color;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();

    private int[] newPosition; // {y,x}
    private int[] position;

    public Bishop(String color) {
        this.color = color;
    }

    public String getName() {
        return "B"+color;
    }

    public void setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y, x};

        CalculateDiagonals cd = new CalculateDiagonals();
        cd.setPosition(position);
        potentialMoves = cd.calculateDiagonal();
        
        setColorPGN(potentialMoves);

        /*System.out.println("Möglichkeiten:");
        for (int[] potentialMove : potentialMoves) {
            System.out.print(Arrays.toString(potentialMove));
        }
        System.out.println(" -> "+potentialMoves.size());*/
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }
}
