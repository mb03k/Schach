package Logic;

import java.util.ArrayList;
import java.util.Arrays;


public class QueenMoves extends Logic {
    private final int y = 0;
    private final int x = 1;

    private int[] position;
    private int[] newPosition;
    private final ArrayList<int[]> potentialMovesStorage;
    private final ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public QueenMoves() {
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
        calculateDiagonal();
        calculateHorizontals();

        return potentialMovesStorage;
    }

    public void calculateDiagonal() {
        setNewPosition();
        calculateDiagonal(-1, 1);

        setNewPosition();
        calculateDiagonal(-1, -1);

        setNewPosition();
        calculateDiagonal(1, 1);

        setNewPosition();
        calculateDiagonal(1,-1);
    }

    private void calculateDiagonal(int yDirection, int xDirection) {
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
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public void calculateHorizontals() {
        setNewPosition();
        calculateHorizontals(0, 1);

        setNewPosition();
        calculateHorizontals(0, -1);

        setNewPosition();
        calculateHorizontals(1, 0);

        setNewPosition();
        calculateHorizontals(-1, 0);
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
