package Pieces;

public class Knight extends Piece {
    private final String color;

    public Knight(String color) {
        this.color = color;
    }

    public String getName() {
        return "N"+color;
    }
}
