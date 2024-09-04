package Pieces;

public class Pawn extends Piece {
    private String color;

    public Pawn(String color) {
        this.color = color;
    }

    public String getName() {
        return "P"+color;
    }
}
