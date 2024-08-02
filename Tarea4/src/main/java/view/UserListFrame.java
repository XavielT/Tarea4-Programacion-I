package view;

import model.User;
import model.UserFactory;
import service.UserManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserListFrame extends JFrame {
    private JTable userTable; // Tabla que mostrará la lista de usuarios
    private UserTableModel userModel; // Modelo de la tabla

    // Constructor de la clase UserListFrame
    public UserListFrame() {
        setTitle("Lista de Usuarios");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userModel = new UserTableModel();
        userTable = new JTable(userModel);

        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane);

        // Crear panel y botones
        JPanel panel = new JPanel();
        JButton logoutButton = new JButton("Cerrar Sesión");
        JButton updateButton = new JButton("Actualizar Usuario");
        JButton deleteButton = new JButton("Eliminar Usuario");

        // Anade los botones
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(logoutButton);
        add(panel, "South");

        // Acción para el botón de "Cerrar Sesión"
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });

        // Acción para el botón de "Actualizar Usuario"
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    User user = userModel.getUserAt(selectedRow);
                    new UpdateUserFrame(user, userModel).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un usuario para actualizar.");
                }
            }
        });

        // Acción para el botón de "Eliminar Usuario"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    User user = userModel.getUserAt(selectedRow);
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar a este usuario?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        UserManager.getInstance().deleteUser(user);
                        userModel.refreshData();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un usuario para eliminar.");
                }
            }
        });
    }
}

