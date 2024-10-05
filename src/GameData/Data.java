package GameData;

import Pieces.*;

import java.util.ArrayList;

public class Data {
    public static String currentPlayer;
    public static boolean kingsInCheck;

    public static int[][] colorPGN = new int[][] {
        // 0 = black; 1 = white; 2 = orange; 3 = red
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1}
    };

    public static void setStandardColorPGN() {
        colorPGN = new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1}
        };
    }

    public static void setColorPGN(ArrayList<int[]> colorIndices, int whichColor) {
        try {
            for (int[] color : colorIndices) {
                colorPGN[color[0]][color[1]] = whichColor;
            }
        } catch (NullPointerException e) {}
    }

    public static Piece[][] pgn = new Piece[][] {
        {new Rook("b"), new Knight("b"), new Bishop("b"), new Queen("b"), new King("b"), new Bishop("b"), new Knight("b"), new Rook("b")},
        {new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b")},
        {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new Bishop("b"), new Pawn("b"), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new EmptyField(), new Knight("w"), new Bishop("w"), new Pawn("b"), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new Pawn("b"), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new EmptyField(), new Pawn("w"), new Pawn("w"), new EmptyField()},
        {new Rook("w"), new Knight("w"), new Bishop("w"), new Queen("w"), new King("w"), new Bishop("w"), new Knight("w"), new Rook("w")}
    };

    public static int[][] whitesPM_PGN = new int[][] {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static int[][] blacksPM_PGN = new int[][] {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static void setStandardPM_PGN() {
        whitesPM_PGN = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        blacksPM_PGN = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public static void writePM_PGN(String color, ArrayList<int[]> moves) {
        if (color.equals("w")) {
            writeWhitesPM_PNG(moves);
        } else {
            writeBlacksPM_PNG(moves);
        }
    }

    // OUT OF BOUNDS STOPPT DIE AUFNAHME OMG
    private static void writeWhitesPM_PNG(ArrayList<int[]> moves) {
        try {
            for (int[] move : moves) {
                if (outOfBounds(move)) {
                    continue;
                }

                whitesPM_PGN[move[0]][move[1]] = 1;
            }
        } catch (Exception e) {}
    }

    private static void writeBlacksPM_PNG(ArrayList<int[]> moves) {
        try {
            for (int[] move : moves) {
                if (outOfBounds(move)) {
                    continue;
                }

                blacksPM_PGN[move[0]][move[1]] = 1;
            }
        } catch (Exception e) {}
    }

    private static boolean outOfBounds(int[] move) {
        return move[0]<0 || move[0]>7 || move[1]<0 || move[1]>7;
    }

    // ♚ ♛ ♜ ♝ ♞ ♟ schwarz
    // ♔ ♕ ♖ ♗ ♘ ♙ weiß
}
