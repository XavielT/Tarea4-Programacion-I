package view;

import model.User;
import service.UserManager;
import model.UserFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Campos de texto
public class UpdateUserFrame extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private User user;
    private UserTableModel userModel; // Modelo de la tabla de usuarios

    // Constructor de la clase
    public UpdateUserFrame(User user, UserTableModel userModel) {
        this.user = user;
        this.userModel = userModel;

        setTitle("Actualizar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // Etiqueta y campo de texto para el nombre
        JLabel firstNameLabel = new JLabel("Nombre:");
        firstNameLabel.setBounds(10, 20, 80, 25);
        panel.add(firstNameLabel);

        firstNameField = new JTextField(20);
        firstNameField.setBounds(150, 20, 200, 25);
        firstNameField.setText(user.getFirstName());
        panel.add(firstNameField);

        // Etiqueta y campo de texto para el apellido
        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(10, 60, 80, 25);
        panel.add(lastNameLabel);

        lastNameField = new JTextField(20);
        lastNameField.setBounds(150, 60, 200, 25);
        lastNameField.setText(user.getLastName());
        panel.add(lastNameField);

        // Etiqueta y campo de texto para el teléfono
        JLabel phoneLabel = new JLabel("Teléfono:");
        phoneLabel.setBounds(10, 100, 80, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(150, 100, 200, 25);
        phoneField.setText(user.getPhoneNumber());
        panel.add(phoneField);

        // Etiqueta y campo de texto para el correo electrónico
        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(10, 140, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(150, 140, 200, 25);
        emailField.setText(user.getEmail());
        panel.add(emailField);

        // Botón para actualizar la información del usuario
        JButton updateButton = new JButton("Actualizar");
        updateButton.setBounds(150, 180, 200, 25);
        panel.add(updateButton);

        // Acción para el botón de "Actualizar"
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualiza los datos del usuario con los valores ingresados
                user.setFirstName(firstNameField.getText());
                user.setLastName(lastNameField.getText());
                user.setPhoneNumber(phoneField.getText());
                user.setEmail(emailField.getText());
                UserManager.getInstance().updateUser(user); 
                // Llama a UserManager para actualizar el usuario en la lista
                userModel.refreshData();
                // Refresca los datos en la tabla de usuarios
                dispose();
                // Cierra la ventana de actualización
            }
        });
    }
}

