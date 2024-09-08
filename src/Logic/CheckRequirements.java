package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

public class CheckRequirements {
    // only calculate moves if its the right piece color
    public static void checkSequenceAndCalculateMoves(int y, int x) {
        // whites move; white piece
        if (pgn[y][x].getColor().equals("w") && currentPlayer.equals("w")) {
            pgn[y][x].calculateAndMarkMoves(y, x);
        // blacks move; blacks piece
        } else if (pgn[y][x].getColor().equals("b") && currentPlayer.equals("b")) {
            pgn[y][x].calculateAndMarkMoves(y, x);
        }
    }

    public static boolean takePiece(int[] newPosition, ArrayList<int[]> potentialMoves) {
        for (int[] move : potentialMoves) {
            if (Arrays.equals(move, newPosition)) {
                System.out.println("return true");
                return true;
            }
        }
        return false;
    }
}
