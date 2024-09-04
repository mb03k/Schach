package GameData;

import Pieces.*;

public class Data {
    public static int[][] pgn = new int[][] {
        // -1 = Pawn black
        // -2 = Bishop black
        // -3 = Knight black
        // -4 = Rook black
        // -5 = Queen black
        // -6 = King black

        // 1 = Pawn white
        // 2 = Bishop white
        // 3 = Knight white
        // 4 = Rook white
        // 5 = Queen white
        // 6 = King white
        // 0 = empty

        {-4, -3, -2, -5, -6, -2, -3, -4},
        {-1, -1, -1, -1, -1, -1, -1, -1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1},
        {4, 3, 2, 5, 6, 2, 3, 4}
    };

    /*public Movements[][] objectPGN = new Movements[][]{
        {new Rook("black"), new Knight("black"), new Bishop("black"), new Queen("black"), new King("black"), new Bishop("black"), new Knight("black"), new Rook("black")},
        {new Pawn("black"), new Pawn("black"), new Pawn("black"), new Pawn("black"), new Pawn("black"), new Pawn("black"), new Pawn("black"), new Pawn("black")},
        {null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null},
        {new Pawn("white"), new Pawn("white"), new Pawn("white"), new Pawn("white"), new Pawn("white"), new Pawn("white"), new Pawn("white"), new Pawn("white")},
        {new Rook("white"), new Knight("white"), new Bishop("white"), new Queen("white"), new King("white"), new Bishop("white"), new Knight("white"), new Rook("white")}
    };*/

    public static Piece[][] objectPGN = new Piece[8][8];

    public static Object[][] individualizedPGN;

    public void setIndividualizedPGN(Object[][] pgn) {
        individualizedPGN = pgn;
    }

    public static int[][] colorPGN = new int[][] {
        // 0 = schwarz; 1 = weiß; 2 = orange
        {1, 0, 1, 0, 2, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1}
    };
}
