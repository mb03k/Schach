package Logic;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

public abstract class Logic {
    protected static final int y = 0;
    protected static final int x = 1;

    protected static boolean whitesMove() {
        return currentPlayer.equals("w");
    }

    protected static boolean newPieceIsSameColor(int[] position) {
        return pgn[position[y]][position[x]].getColor().equals(currentPlayer);
    }

    protected static boolean otherPieceColorWasClicked(int[] tempPosition) {
        return whitesMove() && !newPieceIsSameColor(tempPosition) || !whitesMove() && !newPieceIsSameColor(tempPosition);
    }
}
