package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class KnightMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMoves;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;

    public KnightMoves() {
        potentialMoves = new ArrayList<>();
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setTempPosition() {
        this.tempPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateMoves() {
        int[][] drc = new int[][] {
                {-2,1}, // top right
                {-2,-1}, // top left
                {-1,2}, // right top
                {1,2}, // right bottom
                {2,1}, // bottom right
                {2,-1}, // bottom left
                {1,-2}, // left top
                {-1,-2}, // left bottom
        };

        for (int i=0; i<8; i++) {
            setTempPosition();
            calculateMoves(drc[i][0], drc[i][1]);
        }

        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        tempPosition[y]+=yDirection;
        tempPosition[x]+=xDirection;
        try {
            if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                potentialMovesStorage.add(new int[]{tempPosition[0], tempPosition[1]});
            } else {
                if (otherPieceColorWasClicked(position)) {
                    possibleTakesOfPieces.add(new int[] {tempPosition[0], tempPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return possibleTakesOfPieces;
    }

}
