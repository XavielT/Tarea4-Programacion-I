package view;

import model.User;
import model.UserFactory;
import service.UserManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Campos de texto para ingresar los datos
public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    // Constructor de esta clase
    public RegisterFrame() {
        // Diseno ventana
        setTitle("Registro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // Etiqueta y campo de texto para el nombre de usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(150, 20, 200, 25);
        panel.add(usernameField);

        // Etiqueta y campo de texto para el nombre
        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(10, 60, 80, 25);
        panel.add(firstNameLabel);

        firstNameField = new JTextField(20);
        firstNameField.setBounds(150, 60, 200, 25);
        panel.add(firstNameField);

        // Etiqueta y campo de texto para el apellido
        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(10, 100, 80, 25);
        panel.add(lastNameLabel);

        lastNameField = new JTextField(20);
        lastNameField.setBounds(150, 100, 200, 25);
        panel.add(lastNameField);

        // Etiqueta y campo de texto para el número de teléfono
        JLabel phoneLabel = new JLabel("Teléfono:");
        phoneLabel.setBounds(10, 140, 80, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(150, 140, 200, 25);
        panel.add(phoneField);

        // Etiqueta y campo de texto para el correo electrónico
        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(10, 180, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(150, 180, 200, 25);
        panel.add(emailField);

        // Etiqueta y campo de texto para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 220, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 220, 200, 25);
        panel.add(passwordField);

        // Etiqueta y campo de texto para confirmar la contraseña
        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordLabel.setBounds(10, 260, 150, 25);
        panel.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBounds(150, 260, 200, 25);
        panel.add(confirmPasswordField);

        // Botón de "Registrar"
        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(150, 300, 200, 25);
        panel.add(registerButton);

        // Acción para el botón de "Registrar"
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Verifica que todos los campos estén completos
                if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
                } else {
                    UserManager userManager = UserManager.getInstance();
                    User newUser = UserFactory.createUser(username, firstName, lastName, phone, email, password);
                    userManager.addUser(newUser);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                    dispose();
                }
            }
        });
    }
}

