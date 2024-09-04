package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class CalculateDiagonals {

    private int[] tempPosition = new int[2];
    private int[] position;
    private int[] newPosition;
    private final ArrayList<int[]> potentialMovesStorage = new ArrayList<>();
    private final ArrayList<int[]> possibleTakesOfPieces = new ArrayList<>();


    public CalculateDiagonals(int[] position) {
        this.position = position;
    }

    public ArrayList<int[]> calculateDiagonal() {
        // to top; right and left


        // hier ein fehler. Irgendwie überschreibt er immer den Wert von int[] position mit den Indizes der For-Schleife
        calculateTopDiagonal(-1, 1);
        calculateTopDiagonal(-1, -1);

        return potentialMovesStorage;
    }

    public void calculateTopDiagonal(int yDirection, int xDirection) { // direction can be 1 or -1 (left or right)
        try {
            for (int i=0; i<8; i++) { // go up and right
                tempPosition[0] += yDirection;
                tempPosition[1] += xDirection;
                if (pgn[tempPosition[0]][tempPosition[1]] == 0) {
                    potentialMovesStorage.add(new int[]{tempPosition[0],tempPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }
}
