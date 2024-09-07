package GameData;

import Pieces.*;

import java.util.ArrayList;

public class Data {
    public static int[][] colorPGN = new int[][] {
        // 0 = schwarz; 1 = weiß; 2 = orange; 3 = red/magenta/...
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
        // 0 = black; 1 = white; 2 = orange; 3 = red
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

    public static void setColorPGN(ArrayList<int[]> colors) {
        for (int[] color : colors) {
            colorPGN[color[0]][color[1]] = 2;
        }
    }

    public static Piece[][] pgn = new Piece[][]{
        /*{new Rook("b"), new Knight("b"), new Bishop("b"), new Queen("b"), new King("b"), new Bishop("b"), new Knight("b"), new Rook("b")},
        {new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b")},
        {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
        {new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w")},
        {new Rook("w"), new Knight("w"), new Bishop("w"), new Queen("w"), new King("w"), new Bishop("w"), new Knight("w"), new Rook("w")}
    */
            {new Rook("b"), new Knight("b"), new Bishop("b"), new Queen("b"), new King("b"), new Bishop("b"), new Knight("b"), new Rook("b")},
            {new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b"), new Pawn("b")},
            {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
            {new Bishop("b"), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
            {new EmptyField(), new Knight("w"), new Bishop("w"), new Pawn("b"), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
            {new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField(), new EmptyField()},
            {new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w"), new Pawn("w")},
            {new Rook("w"), new Knight("w"), new Bishop("w"), new Queen("w"), new King("w"), new Bishop("w"), new Knight("w"), new Rook("w")}
    };
}
