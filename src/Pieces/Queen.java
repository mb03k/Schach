package Pieces;

public class Queen extends Piece {
    private final String color;

    public Queen(String color) {
        this.color = color;
    }

    public String getName() {
        return "Q"+color;
    }

    public String getColor() {return this.color;}
}
