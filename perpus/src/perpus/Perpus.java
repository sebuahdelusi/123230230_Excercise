package perpus;

import View.Buku.View;
import Controller.Controller;

public class Perpus {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            View view = new View();
            new Controller(view);
            view.setVisible(true);
        });
    }
}
