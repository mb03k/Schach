package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;

public class CheckRequirements {
    // only calculate moves if its the right piece color
    public static void checkSequenceAndCalculateMoves(int y, int x) {
        pgn[y][x].calculateAndMarkMoves(y, x);
    }

    // can be simplified to one method
    public static boolean checkPieceMoves(int[] newPosition, ArrayList<int[]> potentialMoves) {
        for (int[] move : potentialMoves) {
            if (Arrays.equals(move, newPosition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPieceMoves(int[] newPosition, int[] potentialMoves) {
        for (int[] move : pgn[potentialMoves[0]][potentialMoves[1]].getMoves()) {
            if (Arrays.equals(move, newPosition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPieceTake(int[] newPosition, int[] oldPosition) {
        for (int[] move : pgn[oldPosition[0]][oldPosition[1]].getPotentialTakes()) {
            if (Arrays.equals(move, newPosition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPieceTake(int[] newPosition, ArrayList<int[]> oldPosition) {
        for (int[] move : oldPosition) {
            if (Arrays.equals(move, newPosition)) {
                return true;
            }
        }
        return false;
    }
}
