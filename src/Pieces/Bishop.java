package Pieces;

import Logic.CalculateDiagonals;
import java.util.ArrayList;
import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.takePiece;

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

    public String getColor() {
        System.out.println("Color: "+color);

        return this.color;}

    public void setNewPosition(int newy, int newx) {
        System.out.println("nwenis");
        this.newPosition = new int[] {newy, newx};

        takePiece(newPosition, potentialMoves);
    }

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y, x};

        CalculateDiagonals cd = new CalculateDiagonals();
        cd.setPosition(position);
        potentialMoves = cd.calculateDiagonal();

        setColorPGN(potentialMoves);
    }

    @Override
    public ArrayList<int[]> getMoves() {
        return potentialMoves;
    }
}
