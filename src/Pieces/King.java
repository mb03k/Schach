package Pieces;

public class King extends Piece {
    private final String color;

    public King(String color) {
        this.color = color;
    }

    public String getName() {
        return "K"+color;
    }
}
