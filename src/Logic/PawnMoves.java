package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class PawnMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMoves;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;

    public PawnMoves() {
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

    public ArrayList<int[]> calculateMoves() {
        // Bug: wenn Bauer zwei Felder gehen kann und das erste Feld besetzt ist, aber nicht das zweite
        // kann er trotzdem auf das zweite Feld gehen
        if (pawnIsWhite()) {
            setTempPosition();
            calculateMoves(-1);
            setTempPosition();
            calculateTakes(-1);
            if (firstPawnMove()) {
                setTempPosition();
                calculateMoves(-2);
            }
        } else {
            setTempPosition();
            calculateMoves(1);
            setTempPosition();
            calculateTakes(1);
            if (firstPawnMove()) {
                setTempPosition();
                calculateMoves(2);
            }
        }
        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection) {
        tempPosition[y] += yDirection;
        try {
            if (pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) {
                potentialMovesStorage.add(new int[] {tempPosition[y], tempPosition[x]});
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    private void calculateTakes(int yDirection) {
        tempPosition[y] += yDirection;
        tempPosition[x]--;

        try {
            // left or right sides of pawn are occupied and capturable
            if (!(pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) && pieceCanBeTaken(tempPosition)) {
                possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
            }
        } catch(Exception ignored) {
            tempPosition[x] += 2;
            if (!(pgn[tempPosition[y]][tempPosition[x]] instanceof EmptyField) && pieceCanBeTaken(tempPosition)) {
                possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
            }
        }
    }

    private boolean pawnIsWhite() {
        return pgn[position[y]][position[x]].getColor().equals("w");
    }

    private boolean firstPawnMove() {
        return pgn[position[y]][position[x]].getFirstMoveTwoSteps();
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return this.possibleTakesOfPieces;
    }
}
