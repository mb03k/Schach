package Logic;

import java.util.ArrayList;
import java.util.Arrays;

public class RookMoves extends Logic {
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public RookMoves() {
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
        valuesForPM_PGN = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setTempPosition() {
        this.newPosition = Arrays.copyOf(position, position.length);
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

    private void calculateHorizontals(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                newPosition[y] += yDirection;
                newPosition[x] += xDirection;

                valuesForPM_PGN.add(new int[]{newPosition[y], newPosition[x]});

                if (newPieceIsSameColor(position, newPosition)) {
                    break;
                } 
                
                if (isEmptyField(newPosition[y], newPosition[x])) {
                    potentialMovesStorage.add(new int[]{newPosition[y],newPosition[x]});
                } else if (!newPieceIsSameColor(position, newPosition)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[y], newPosition[x]});
                    break;
                }
            }
        } catch(ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return this.possibleTakesOfPieces;
    }

    public ArrayList<int[]> getValuesForPM_PGN() {
        return valuesForPM_PGN;
    }
}
