package Logic;

import java.util.ArrayList;
import java.util.Arrays;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

public class CheckRequirements {
    // only calculate moves if its the right piece color
    public static void checkSequenceAndCalculateMoves(int y, int x) {

            pgn[y][x].calculateAndMarkMoves(y, x);
        //checkIfPieceTake(y, x);

        // whites move; white piece
        /*if (pgn[y][x].getColor().equals("w") && currentPlayer.equals("w")) {

        // blacks move; blacks piece
        } else if (pgn[y][x].getColor().equals("b") && currentPlayer.equals("b")) {
            pgn[y][x].calculateAndMarkMoves(y, x);
        }*/
    }

    public static void checkIfPieceTake(int y, int x) {
        System.out.print("checkIfPieceTake");
        int[] position = new int[]{y, x};
        ArrayList<int[]> potentialTakes = pgn[y][x].getPotentialTakes();
        System.out.println(" größe: "+potentialTakes.size());

        try {
            for (int[] potentialTake : potentialTakes) {
                System.out.println(Arrays.equals(position, potentialTake) + " -");
                System.out.println("potentialTake: " + potentialTake[0] + "-" + potentialTake[1]);
                System.out.println("position (wird übergeben): " + y + "-" + x);
            }
        } catch (NullPointerException ignored) {}
        System.out.println();
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
    public static boolean checkPieceTake(int[] newPosition, int[] potentialPosition) {
        for (int[] move : pgn[potentialPosition[0]][potentialPosition[1]].getPotentialTakes()) {
            if (Arrays.equals(move, newPosition)) {
                System.out.println("Figur auf "+newPosition[0]+"-"+newPosition[1]+" von "+move[0]+"-"+move[1]+" schlagbar");
                return true;
            }
        }
        return false;
    }

    public static boolean checkPieceTake(int[] newPosition, ArrayList<int[]> potentialPosition) {
        for (int[] move : potentialPosition) {
            if (Arrays.equals(move, newPosition)) {
                System.out.println("Figur auf "+newPosition[0]+"-"+newPosition[1]+" von "+move[0]+"-"+move[1]+" schlagbar");
                return true;
            }
        }
        return false;
    }
}
