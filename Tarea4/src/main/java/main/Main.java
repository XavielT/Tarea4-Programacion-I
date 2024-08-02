package main;

import view.LoginFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Método principal que inicia la ejecución de la aplicación
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
            // Crea una instancia de LoginFrame y la hace visible
        });
    }
}


