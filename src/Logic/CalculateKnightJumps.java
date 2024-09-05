package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class CalculateKnightJumps extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMoves;
    private ArrayList<int[]> potentialMovesStorage;

    public CalculateKnightJumps() {
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

        // can be simplified with for (i guess)
        setTempPosition();
        calculateMoves(-2, 1); // top right

        setTempPosition();
        calculateMoves(-2, -1); // top left

        setTempPosition();
        calculateMoves(-1, 2); // right top

        setTempPosition();
        calculateMoves(1, 2); // right bottom

        setTempPosition();
        calculateMoves(2, 1); // bottom right

        setTempPosition();
        calculateMoves(2, -1); // bottom left

        setTempPosition();
        calculateMoves(1, -2); // left top

        setTempPosition();
        calculateMoves(-1, -2); // left bottom

        return potentialMovesStorage;
    }

    public void calculateMoves(int yDirection, int xDirection) {
        try {
            if (pgn[tempPosition[y]+=yDirection][tempPosition[x]+=xDirection] == 0) {
                potentialMovesStorage.add(new int[]{tempPosition[0], tempPosition[1]});
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }
}
