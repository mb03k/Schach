package Logic;

import static GameData.Data.pgn;
import static GameData.Data.whitesPM_PGN;

import java.util.ArrayList;
import java.util.Arrays;

public class KingMoves extends Logic {
    private int[] position;
    private int[] newPosition;
    private ArrayList<int[]> potentialMovesStorage;
    private ArrayList<int[]> possibleTakesOfPieces;
    private ArrayList<int[]> valuesForPM_PGN;

    public KingMoves() {
        potentialMovesStorage = new ArrayList<>();
        possibleTakesOfPieces = new ArrayList<>();
        valuesForPM_PGN = new ArrayList<>();
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setnewPosition() {
        this.newPosition = Arrays.copyOf(position, position.length);
    }

    public ArrayList<int[]> calculateMoves() {
        int[][] drc = new int[][] {
            {-1,0}, // top
            {-1,-1}, // top left
            {-1,1}, // right top
            {0,1}, // right
            {0,-1}, // left
            {1,0}, // bottom
            {1,-1}, // bottom left
            {1,1}, // bottom right
        };

        for (int i=0; i<8; i++) {
            setnewPosition();
            calculateMoves(drc[i][0], drc[i][1]);
        }
        return potentialMovesStorage;
    }

    private void calculateMoves(int yDirection, int xDirection) {
        newPosition[y]+=yDirection;
        newPosition[x]+=xDirection;
        String color = pgn[position[0]][position[1]].getColor();
        valuesForPM_PGN.add(new int[]{newPosition[y], newPosition[x]});

        try {
            if (isEmptyField(newPosition[y], newPosition[x])) {
                if (!otherColorSeesTheField(newPosition, color)) { 
                    if (color.equals("b")){
                        System.out.println("adding: "+newPosition[0]+"|"+newPosition[1]+ " - denn besetzt="+whitesPM_PGN[newPosition[0]][newPosition[1]]);
                        System.out.println("DEBUGWEISS:");
                        for (int i=0; i<8; i++) {
                            for (int j=0; j<8; j++) {
                                System.out.print(whitesPM_PGN[i][j]+"|");
                            }
                            System.out.println();
                        }
                    }
                    potentialMovesStorage.add(new int[]{newPosition[0], newPosition[1]});
                }
            } else {
                if (pieceCanBeTaken(position, newPosition) && !otherColorSeesTheField(newPosition, color)) {
                    possibleTakesOfPieces.add(new int[]{newPosition[0],newPosition[1]});
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public ArrayList<int[]> getValuesForPM_PGN() {
        return valuesForPM_PGN;
    }

    public ArrayList<int[]> getPossibleTakesOfPieces() {
        return possibleTakesOfPieces;
    }
}
