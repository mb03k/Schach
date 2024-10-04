package Logic;

import static GameData.Data.blacksPM_PGN;
import static GameData.Data.pgn;
import static GameData.Data.whitesPM_PGN;
import static GameData.Data.currentPlayer;

import java.util.ArrayList;
import java.util.Arrays;

import Pieces.EmptyField;

public abstract class Logic {
    protected static final int y = 0;
    protected static final int x = 1;

    protected static boolean whitesMove() {
        return currentPlayer.equals("w");
    }

    /*
     * Bug-fix:
     * in the old version only the color of 'tempPosition' was compared with the string 'currentPlayer'
     * but at the beginning of a game (stand of state: 03. October 24) the game starts with currentPlayer white
     * so it returned with black every time false
     */
    protected static boolean newPieceIsSameColor(int[] oldPosition, int[] newPosition) {
        String oldPos = pgn[oldPosition[0]][oldPosition[1]].getColor();
        String newPos = pgn[newPosition[0]][newPosition[1]].getColor();
        
        return oldPos.equals(newPos);
        
        //return pgn[oldPosition[0]][oldPosition[1]].getColor().equals(pgn[newPosition[0]][newPosition[1]].getColor());
    }

    // white takes black or black takes white
    protected static boolean pieceCanBeTaken(int[] position, int[] newPosition) {
        //return whitesMove() && !newPieceIsSameColor(tempPosition) || !whitesMove() && !newPieceIsSameColor(tempPosition);
        return !newPieceIsSameColor(position, newPosition);
    }

    public static boolean isEmptyField(int y, int x) {
        return pgn[y][x] instanceof EmptyField;
    }

    protected static boolean otherColorSeesTheField(int[] pos, String color) {
        if (color.equals("w")) {
            return blacksPM_PGN[pos[y]][pos[x]] == 1;
        } 

        return whitesPM_PGN[pos[y]][pos[x]] == 1;
    }

    public static boolean checkPieceMoveOrTake(int[] newPosition, ArrayList<int[]> potentialMoves) {
        try {
            for (int[] move : potentialMoves) {
                if (Arrays.equals(move, newPosition)) {
                    return true;
                }
            }
        } catch (Exception igored) {}
        
        return false;
    }
}
