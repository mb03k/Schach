package Pieces;

import Logic.KnightMoves;
import java.util.ArrayList;
import static GameData.Data.setColorPGN;
import static Logic.CheckRequirements.checkPieceMoveOrTake;

public class Knight extends Piece {
    private final String color;
    private final char ui;
    private int[] position;
    private ArrayList<int[]> potentialMoves = new ArrayList<>();
    private ArrayList<int[]> potentialTakes = new ArrayList<>();
    private int[] newPosition;

    public Knight(String color) {
        this.color = color;

        if (color.equals("w")) {
            ui = '♘';
        } else {
            ui = '♞';
        }
    }

    public char getUi() {
        return this.ui;
    }

    public String getName() {
        return "N"+color;
    }

    public String getColor() {return this.color;}

    public boolean setNewPosition(int newy, int newx) {
        this.newPosition = new int[] {newy, newx};

        return checkPieceMoveOrTake(newPosition, potentialMoves);
    }

    public void calculateAndMarkMoves(int y, int x) {
        position = new int[]{y,x};

        KnightMoves ck = new KnightMoves();
        ck.setPosition(position);
        potentialMoves = ck.calculateMoves();
        potentialTakes = ck.getPossibleTakesOfPieces();

        setColorPGN(potentialMoves, 2);
        setColorPGN(potentialTakes, 3);
    }

    public ArrayList<int[]> getPotentialTakes() {
        return this.potentialTakes;
    }
}
