package Pieces;

public class Bishop extends Piece {
    public String color;

    public Bishop(String color) {
        this.color = color;
    }

    public String getName() {
        return "B"+color;
    }
}
