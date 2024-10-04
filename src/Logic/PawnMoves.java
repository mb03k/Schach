package Logic;

import Pieces.EmptyField;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class PawnMoves extends Logic {
    private int[] position;
    private int[] newPosition;
    private boolean pieceInTheWay = false;
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

    public void setNewPosition() {
        this.newPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateMoves() {
        // Bug: wenn Bauer zwei Felder gehen kann und das erste Feld besetzt ist, aber nicht das zweite
        // kann er trotzdem auf das zweite Feld gehen
        if (pawnIsWhite()) {
            setNewPosition();
            calculateMoves(-1);

            setNewPosition();
            calculateTakes(-1);

            if (firstPawnMove()) {
                setNewPosition();
                calculateMoves(-2);
            }
        } else {
            setNewPosition();
            calculateMoves(1);

            setNewPosition();
            calculateTakes(1);

            if (firstPawnMove()) {
                setNewPosition();
                calculateMoves(2);
            }
        }
        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection) {
        newPosition[y] += yDirection;
        try {
            // !pieceInTheWay fixes the bug that pawn could move 2 squares - even if on the first one
            // is another piece
            if (pgn[newPosition[y]][newPosition[x]] instanceof EmptyField && !pieceInTheWay) {
                potentialMovesStorage.add(new int[] {newPosition[y], newPosition[x]});
            } else {
                pieceInTheWay = true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }


    
    private void calculateTakes(int yDirection) {
        calculateTakesLeft(yDirection);
        setNewPosition();
        calculateTakesRight(yDirection);
    }
    
    private void calculateTakesLeft(int yDirection) {
        newPosition[y] += yDirection;
        newPosition[x]--;

        valuesForPM_PGN.add(new int[]{newPosition[y], newPosition[x]});

        try {
            if (!isEmptyField(newPosition[y], newPosition[x])) {
                if (pieceCanBeTaken(position, newPosition)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[y], newPosition[x]});
                } 
            } 
        } catch(Exception ignored) {}
    }

    private void calculateTakesRight(int yDirection) {
        newPosition[y] += yDirection;
        newPosition[x]++;
        
        valuesForPM_PGN.add(new int[]{newPosition[y], newPosition[x]});
        
        try {
            if (!isEmptyField(newPosition[y], newPosition[x])) {
                if (pieceCanBeTaken(position, newPosition)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[y], newPosition[x]});
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
