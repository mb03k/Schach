package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import Pieces.EmptyField;

import static GameData.Data.pgn;

public class QueenMoves extends Logic {
    private final int y = 0;
    private final int x = 1;

    private int[] position;
    private int[] tempPosition;
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

    public void setTempPosition() {
        this.tempPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateMoves() {
        calculateDiagonal();
        calculateHorizontals();

        return potentialMovesStorage;
    }

    public void calculateDiagonal() {
        setTempPosition();
        calculateDiagonal(-1, 1);

        setTempPosition();
        calculateDiagonal(-1, -1);

        setTempPosition();
        calculateDiagonal(1, 1);

        setTempPosition();
        calculateDiagonal(1,-1);
    }

    private void calculateDiagonal(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                tempPosition[y] += yDirection;
                tempPosition[x] += xDirection;

                // same color on the diagonal (cant move further)
                if (whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                } else if (!whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                }

                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y],tempPosition[x]});
                    valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
                }
                // if a piece is detected
                else if (pieceCanBeTaken(tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                    valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public void calculateHorizontals() {
        setTempPosition();
        calculateHorizontals(0, 1);

        setTempPosition();
        calculateHorizontals(0, -1);

        setTempPosition();
        calculateHorizontals(1, 0);

        setTempPosition();
        calculateHorizontals(-1, 0);
    }

    private void calculateHorizontals(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                tempPosition[y] += yDirection;
                tempPosition[x] += xDirection;

                // same color on the diagonal (cant move further)
                if (whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                } else if (!whitesMove() && newPieceIsSameColor(tempPosition)) {
                    break;
                }
                if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                    potentialMovesStorage.add(new int[]{tempPosition[y],tempPosition[x]});
                    valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
                } else if (pieceCanBeTaken(tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                    valuesForPM_PGN.add(new int[]{tempPosition[y],tempPosition[x]});
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
