import Gui.Frame;
import Gui.Homescreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new Frame();

            Homescreen hs = new Homescreen();
            hs.setFrame(frame);
            hs.setHomescreen();
        });
    }
}