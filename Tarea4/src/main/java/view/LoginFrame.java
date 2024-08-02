package view;

import model.User;
import service.UserManager;
import model.UserFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Campos pa' ingresar usuario y contrasena
public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Constructor de la clase LoginFrame
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel que contiene todo
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // Etiqueta y campo de texto para el nombre de usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        // Etiqueta y campo de texto para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // Botón de "Iniciar Sesión"
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);

        // Botón de "Registrarse"
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(10, 110, 150, 25);
        panel.add(registerButton);

        // Acción para el botón de "Iniciar Sesión"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Verifica que los campos no estén vacíos
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse.");
                } else {
                    UserManager userManager = UserManager.getInstance();
                    User user = userManager.getUser(username, password);
                    if (user != null) {
                        dispose();
                        new UserListFrame().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    }
                }
            }
        });

        // Acción para el botón de "Registrarse"
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true);
            }
        });
    }
}

