package Pieces;

import Logic.KnightMoves;
import java.util.ArrayList;
import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.takePiece;

public class Knight extends Piece {
    private final String color;
    private int[] position;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private int[] newPosition;

    public Knight(String color) {
        this.color = color;
    }

    public String getName() {
        return "N"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return takePiece(newPosition, potentialMoves);
    }

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y,x};

        KnightMoves ck = new KnightMoves();
        ck.setPosition(position);
        potentialMoves = ck.calculateMoves();

        setColorPGN(potentialMoves);
    }
}
