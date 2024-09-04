package Pieces;

public class Queen extends Piece {
    private String color;

    public Queen(String color) {
        this.color = color;
    }

    public String getName() {
        return "Q"+color;
    }
}
