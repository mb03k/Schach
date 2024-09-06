package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class CalculateHorizontals extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMoves;
    private ArrayList<int[]> potentialMovesStorage;

    public CalculateHorizontals() {
        potentialMoves = new ArrayList<>();
        potentialMovesStorage = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setTempPosition() {
        this.tempPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateHorizontals() {
        setTempPosition();
        calculateHorizontals(0, 1);

        setTempPosition();
        calculateHorizontals(0, -1);

        setTempPosition();
        calculateHorizontals(1, 0);

        setTempPosition();
        calculateHorizontals(-1, 0);
        return potentialMovesStorage;
    }

    public void calculateHorizontals(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                tempPosition[y] += yDirection;
                tempPosition[x] += xDirection;

                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y], tempPosition[x]});
                }
            }
        } catch(ArrayIndexOutOfBoundsException ignored) {}
    }
}
