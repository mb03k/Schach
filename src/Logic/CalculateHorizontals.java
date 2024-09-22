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
    private ArrayList<int[]> possibleTakesOfPieces;

    public CalculateHorizontals() {
        potentialMoves = new ArrayList<>();
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
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

    private void calculateHorizontals(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                tempPosition[y] += yDirection;
                tempPosition[x] += xDirection;

                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y], tempPosition[x]});
                }

                // same color on the diagonal (cant move further)
                if (whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                } else if (!whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                }
                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y],tempPosition[x]});
                } else if (otherPieceColorWasClicked(tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                    break;
                }
            }
        } catch(ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return this.possibleTakesOfPieces;
    }
}
