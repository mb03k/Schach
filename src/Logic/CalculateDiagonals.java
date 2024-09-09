package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.*;
import static Logic.Logic.newPieceIsSameColor;
import static Logic.Logic.whitesMove;

public class CalculateDiagonals {

    private final int y = 0;
    private final int x = 1;

    private int[] position;
    private int[] tempPosition;
    private int[] newPosition;
    private final ArrayList<int[]> potentialMovesStorage = new ArrayList<>();
    private final ArrayList<int[]> possibleTakesOfPieces = new ArrayList<>();

    public CalculateDiagonals() {}

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setTempPosition() {
        this.tempPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateDiagonal() {

        setTempPosition();
        calculateDiagonal(-1, 1);

        setTempPosition();
        calculateDiagonal(-1, -1);

        setTempPosition();
        calculateDiagonal(1, 1);

        setTempPosition();
        calculateDiagonal(1,-1);

        return potentialMovesStorage;
    }

    private void calculateDiagonal(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                tempPosition[y] += yDirection;
                tempPosition[x] += xDirection;

                // same color on the diagonal (cant move further)
                if (whitesMove() && newPieceIsSameColor(tempPosition, y, x)) {
                    break;
                } else if (!whitesMove() && newPieceIsSameColor(tempPosition, y, x)) {
                    break;
                }

                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y],tempPosition[x]});
                }

                if (whitesMove() && !newPieceIsSameColor(tempPosition, y, x)) {
                    potentialMovesStorage.add(new int[]{tempPosition[y], tempPosition[x]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }
}
