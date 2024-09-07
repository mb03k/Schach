package Pieces;

import Logic.KnightMoves;
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
        return "N"+color;
    }

    public String getColor() {return this.color;}

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y,x};

        KnightMoves ck = new KnightMoves();
        ck.setPosition(position);
        potentialMoves = ck.calculateMoves();

        setColorPGN(potentialMoves);
    }
}
