package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class PawnMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMoves;
    private ArrayList<int[]> potentialMovesStorage;

    public PawnMoves() {
        potentialMoves = new ArrayList<>();
        potentialMovesStorage = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setTempPosition() {
        this.tempPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateMoves() {

        if (pawnIsWhite()) {
            setTempPosition();
            calculateMoves(-1, 0);
            if (firstPawnMove()) {
                setTempPosition();
                calculateMoves(-2, 0);
            }
        } else {
            setTempPosition();
            calculateMoves(1, 0);
            if (firstPawnMove()) {
                setTempPosition();
                calculateMoves(2, 0);
            }
        }
        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        tempPosition[y] += yDirection;
        tempPosition[x] += xDirection;
        try {
            if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                potentialMovesStorage.add(new int[] {tempPosition[y], tempPosition[x]});
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public boolean pawnIsWhite() {
        return pgn[position[y]][position[x]].getColor().equals("w");
    }

    public boolean firstPawnMove() {
        return pgn[position[y]][position[x]].getFirstMoveTwoSteps();
    }
}
