package Pieces;

import Logic.CalculateHorizontals;
import java.util.ArrayList;
import static GameData.Data.setColorPGN;

public class Rook extends Piece {
    private final String color;
    private int[] position;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();

    public Rook(String color) {
        this.color = color;
    }

    public String getName() {
        return "R"+color;
    }

    public String getColor() {return this.color;}

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y,x};

        CalculateHorizontals ch = new CalculateHorizontals();
        ch.setPosition(position);
        potentialMoves = ch.calculateHorizontals();

        setColorPGN(potentialMoves);
    }
}
