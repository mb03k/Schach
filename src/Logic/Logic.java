package Logic;

import static GameData.Data.pgn;
import static Gui.Play.currentPlayer;

public abstract class Logic {
    protected final int y = 0;
    protected final int x = 1;

    protected static boolean whitesMove() {
        return currentPlayer.equals("w");
    }

    protected static boolean newPieceIsSameColor(int[] tempPosition, int y, int x) {
        return pgn[tempPosition[y]][tempPosition[x]].getColor().equals(currentPlayer);
    }
}
