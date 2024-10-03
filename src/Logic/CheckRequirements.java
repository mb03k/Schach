package Logic;

import java.util.ArrayList;
import java.util.Arrays;


public class CheckRequirements {
    // only calculate moves if its the right piece color
    public static void checkSequenceAndCalculateMoves(int y, int x) {
        //pgn[y][x].calculateAndMarkMoves(y, x);
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
