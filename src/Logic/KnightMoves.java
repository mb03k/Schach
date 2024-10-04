package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class KnightMoves extends Logic {
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public KnightMoves() {
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
        valuesForPM_PGN = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setNewPosition() {
        this.newPosition = Arrays.copyOf(position, position.length);
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

        for (int i=0; i<drc.length; i++) {
            setNewPosition();
            calculateMoves(drc[i][0], drc[i][1]);
        }

        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        newPosition[y]+=yDirection;
        newPosition[x]+=xDirection;

        valuesForPM_PGN.add(new int[]{newPosition[y],newPosition[x]});
        try {
            if (pgn[newPosition[y]][newPosition[x]] instanceof EmptyField) {
                potentialMovesStorage.add(new int[]{newPosition[0], newPosition[1]});
            } else {
                if (pieceCanBeTaken(position, newPosition)) {
                    possibleTakesOfPieces.add(new int[] {newPosition[0], newPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return possibleTakesOfPieces;
    }

    public ArrayList<int[]> getValuesForPM_PGN() {
        return valuesForPM_PGN;
    }
}
