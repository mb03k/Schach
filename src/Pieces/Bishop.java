package Pieces;

public class Bishop extends Piece {
    public Bishop(String color) {
        System.out.println("Bishop der Farbe "+color+" erstellt!");
    }

    public String getColor() {
        return "white";
    }
}
