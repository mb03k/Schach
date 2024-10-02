package Logic;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

import Pieces.EmptyField;

public abstract class Logic {
    protected static final int y = 0;
    protected static final int x = 1;

    protected static boolean whitesMove() {
        return currentPlayer.equals("w");
    }

    protected static boolean newPieceIsSameColor(int[] position) {
        return pgn[position[y]][position[x]].getColor().equals(currentPlayer);
    }

    // white takes black or black takes white
    protected static boolean pieceCanBeTaken(int[] tempPosition) {
        return whitesMove() && !newPieceIsSameColor(tempPosition) || !whitesMove() && !newPieceIsSameColor(tempPosition);
    }

    protected static boolean isEmptyField(int y, int x) {
        return pgn[y][x] instanceof EmptyField;
    }
}
