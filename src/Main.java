import Gui.Homescreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Homescreen hs = new Homescreen();
            hs.setHomescreen();
        });
    }
}