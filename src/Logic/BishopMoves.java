package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import static Logic.Logic.*;

public class BishopMoves {

    private final int y = 0;
    private final int x = 1;

    private int[] position;
    private int[] newPosition;
    private final ArrayList<int[]> potentialMovesStorage;
    private final ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public BishopMoves() {
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

    public ArrayList<int[]> calculateDiagonal() {
        setNewPosition();
        calculateDiagonal(-1, 1);

        setNewPosition();
        calculateDiagonal(-1, -1);

        setNewPosition();
        calculateDiagonal(1, 1);

        setNewPosition();
        calculateDiagonal(1,-1);

        return potentialMovesStorage;
    }

    private void calculateDiagonal(int yDirection, int xDirection) {
        try {
            for (int i=0; i<8; i++) {
                newPosition[y] += yDirection;
                newPosition[x] += xDirection;
                
                valuesForPM_PGN.add(new int[]{newPosition[y],newPosition[x]});
                
                // same color on the diagonal (cant move further)
                if (newPieceIsSameColor(position, newPosition)) {
                    break;
                }

                if (isEmptyField(newPosition[y], newPosition[x])) {
                    potentialMovesStorage.add(new int[]{newPosition[y],newPosition[x]});
                }
                // if a piece is detected
                else if (pieceCanBeTaken(position, newPosition)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[y], newPosition[x]});
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
