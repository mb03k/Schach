package Pieces;

import java.util.ArrayList;

public abstract class Piece {

    
    public String getUi() {
        return "";
    }

    public String getName() { // for PGN / FEN
        return "";
    }

    public String getColor() {
        return "";
    }

    public void calculateMoves(int y, int x) {

    }

    public ArrayList<int[]> getPotentialMoves() {
        return null;
    }

    public ArrayList<int[]> getPotentialTakes() {
        return null;
    }

    public boolean getFirstMoveTwoSteps() {
        return false;
    }

    public boolean pieceCanBeMoved(int y, int x) {
        return false;
    }

    public void setFirstMoveTwoStepsFalse() {

    }

}
