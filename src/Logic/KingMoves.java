package Logic;

import static GameData.Data.pgn;

import java.util.ArrayList;
import java.util.Arrays;

public class KingMoves extends Logic {
    private int[] position;
    private int[] newPosition;
    private int[][] drc;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public KingMoves() {
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
        valuesForPM_PGN = new ArrayList<>();

        drc = new int[][] {
            {-1,0}, // top
            {-1,-1}, // top left
            {-1,1}, // right top
            {0,1}, // right
            {0,-1}, // left
            {1,0}, // bottom
            {1,-1}, // bottom left
            {1,1}, // bottom right
        };
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setNewPosition() {
        this.newPosition = Arrays.copyOf(position, position.length);
    }

    public void addPM_PGN() {
        for (int[] dir : drc) {
            setNewPosition();
            newPosition[y]+=dir[y];
            newPosition[x]+=dir[x];
            valuesForPM_PGN.add(new int[]{newPosition[y], newPosition[x]});
        }
    }

    public ArrayList<int[]> calculateMoves() {
        for (int i=0; i<8; i++) {
            setNewPosition();
            calculateMoves(drc[i][0], drc[i][1]);
        }
        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        newPosition[y]+=yDirection;
        newPosition[x]+=xDirection;
        String color = pgn[position[0]][position[1]].getColor();

        try {
            if (isEmptyField(newPosition[y], newPosition[x])) {
                if (!otherColorSeesTheField(newPosition, color)) { 
                    potentialMovesStorage.add(new int[]{newPosition[0], newPosition[1]});
                }
            } else {
                if (pieceCanBeTaken(position, newPosition) && !otherColorSeesTheField(newPosition, color)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[0],newPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getValuesForPM_PGN() {
        return valuesForPM_PGN;
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return possibleTakesOfPieces;
    }
}
