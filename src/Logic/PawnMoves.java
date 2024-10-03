package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class PawnMoves extends Logic {
    private int[] position;
    private int[] tempPosition;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public PawnMoves() {
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
        calculateTakesLeft(yDirection);
        setTempPosition();
        calculateTakesRight(yDirection);
    }
    
    private void calculateTakesLeft(int yDirection) {
        tempPosition[y] += yDirection;
        tempPosition[x]--;

        valuesForPM_PGN.add(new int[]{tempPosition[y], tempPosition[x]});
        try {
            if (!isEmptyField(tempPosition[y], tempPosition[x])) {
                if (pieceCanBeTaken(position, tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                } 
            } 
        } catch(Exception ignored) {}
    }

    private void calculateTakesRight(int yDirection) {
        tempPosition[y] += yDirection;
        tempPosition[x]++;
        
        valuesForPM_PGN.add(new int[]{tempPosition[y], tempPosition[x]});
        try {
            if (!isEmptyField(tempPosition[y], tempPosition[x])) {
                if (pieceCanBeTaken(position, tempPosition)) {
                    possibleTakesOfPieces.add(new int[]{tempPosition[y], tempPosition[x]});
                }
            }
        } catch(Exception ignored) {}
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

    public ArrayList<int[]> getValuesForPM_PGN() {
        return this.valuesForPM_PGN;
    }
}
