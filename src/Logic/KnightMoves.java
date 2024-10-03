package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class KnightMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
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

        for (int i=0; i<drc.length; i++) {
            setTempPosition();
            calculateMoves(drc[i][0], drc[i][1]);
        }

        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        tempPosition[y]+=yDirection;
        tempPosition[x]+=xDirection;
        valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
        try {
            if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                potentialMovesStorage.add(new int[]{tempPosition[0], tempPosition[1]});
                //valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
            } else {
                if (pieceCanBeTaken(position, tempPosition)) {
                    possibleTakesOfPieces.add(new int[] {tempPosition[0], tempPosition[1]});
                    //valuesForPM_PGN.add(new int[]{tempPosition[y], tempPosition[x]});
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
