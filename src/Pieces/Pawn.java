package Pieces;

import Logic.CalculateHorizontals;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.setColorPGN;

public class Pawn extends Piece {
    private int[] position;
    private final String color;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();

    public Pawn(String color) {
        this.color = color;
    }

    public String getName() {
        return "P"+color;
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y, x};

        CalculateHorizontals ch = new CalculateHorizontals();
        ch.setPosition(position);
        potentialMoves = ch.calculateHorizontals();
        System.out.println("Möglichkeiten:");
        for (int[] potentialMove : potentialMoves) {
            System.out.print(Arrays.toString(potentialMove));
        }
        System.out.println(" -> "+potentialMoves.size());
        setColorPGN(potentialMoves);
    }
}
