package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import static Logic.Logic.*;

public class CalculateDiagonals {

    private final int y = 0;
    private final int x = 1;

    private int[] position;
    private int[] tempPosition;
    private final ArrayList<int[]> potentialMovesStorage;
    private final ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public CalculateDiagonals() {
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
                if (newPieceIsSameColor(position, tempPosition)) {
                    valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
                    break;
                }

                valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});

                if (isEmptyField(tempPosition[y], tempPosition[x])) {
                    potentialMovesStorage.add(new int[]{tempPosition[y],tempPosition[x]});
                }
                // if a piece is detected
                else if (pieceCanBeTaken(position, tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                    break;
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
