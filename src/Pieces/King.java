package Pieces;

import Logic.CalculateDiagonals;
import Logic.KingMoves;

import java.util.ArrayList;

import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.takePiece;

public class King extends Piece {
    private final String color;
    private int[] position;
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

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y, x};

        KingMoves km = new KingMoves();
        km.setPosition(position);
        potentialMoves = km.calculateMoves();

        setColorPGN(potentialMoves);
    }

}
