package Pieces;

public class Rook extends Piece {
    private final String color;

    public Rook(String color) {
        this.color = color;
    }

    public String getName() {
        return "R"+color;
    }
}
