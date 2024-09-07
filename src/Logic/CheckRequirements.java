package Logic;

import java.util.ArrayList;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

public class CheckRequirements {
    // only calculate moves if its the right piece color
    public static void checkSequenceAndCalculateMoves(int y, int x) {
        if (pgn[y][x].getColor().equals("w") && currentPlayer.equals("w")) {
            pgn[y][x].calculateAndMarkMoves(y, x);
        } else if (pgn[y][x].getColor().equals("b") && currentPlayer.equals("b")) {
            pgn[y][x].calculateAndMarkMoves(y, x);
        }
    }

    public static void takePiece(int[] newPosition, ArrayList<int[]> potentialMoves) {
        if (potentialMoves.contains(newPosition)) {
            System.out.println("OMG WAS JA");
        }
        System.out.println("vndskj");
    }
}
