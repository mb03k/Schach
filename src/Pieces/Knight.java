package Pieces;

import Logic.CalculateHorizontals;
import Logic.CalculateKnightJumps;

import java.util.ArrayList;

import static GameData.Data.setColorPGN;

public class Knight extends Piece {
    private final String color;
    private int[] position;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();

    public Knight(String color) {
        this.color = color;
    }

    public String getName() {
        return "R"+color;
    }

    public void calculateMoves(int y, int x) {
        position = new int[]{y,x};

        CalculateKnightJumps ck = new CalculateKnightJumps();
        ck.setPosition(position);
        potentialMoves = ck.calculateMoves();

        setColorPGN(potentialMoves);
    }
}
