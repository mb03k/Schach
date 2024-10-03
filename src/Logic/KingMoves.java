package Logic;

import java.util.ArrayList;
import java.util.Arrays;

public class KingMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public KingMoves() {
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
            {-1,0}, // top
            {-1,-1}, // top left
            {-1,1}, // right top
            {0,1}, // right
            {0,-1}, // left
            {1,0}, // bottom
            {1,-1}, // bottom left
            {1,1}, // bottom right
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

        valuesForPM_PGN.add(new int[]{tempPosition[y], tempPosition[x]});
        try {
            if (isEmptyField(tempPosition[y], tempPosition[x])) {
                if (!otherColorSeesTheField(tempPosition[y], tempPosition[x])) {
                    potentialMovesStorage.add(new int[]{tempPosition[0], tempPosition[1]});
                }
            } else {
                if (pieceCanBeTaken(position, tempPosition) && !otherColorSeesTheField(tempPosition[0], tempPosition[1])) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[0],tempPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getValuesForPM_PGN() {
        return valuesForPM_PGN;
    }
}
