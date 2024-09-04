package Pieces;

public class Knight extends Piece {
    private String color;

    public Knight(String color) {
        this.color = color;
    }

    public String getName() {
        return "N"+color;
    }
}
