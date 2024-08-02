package view;

import model.User;
import service.UserManager;
import model.UserFactory;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nombre", "Apellido", "Teléfono", "Correo"};
    // Nombres de las columnas de la tabla
    private List<User> userList;
    // Lista de usuarios que se mostrará en la tabla

    // Constructor de la clase UserTableModel
    public UserTableModel() {
        userList = UserManager.getInstance().getAllUsers();
    }

    @Override
    public int getRowCount() {
        return userList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Devuelve el valor en una celda específica de la tabla
        User user = userList.get(rowIndex);
        // Obtiene el usuario en la fila especificada
        switch (columnIndex) {
            case 0: return user.getFirstName();
            case 1: return user.getLastName();
            case 2: return user.getPhoneNumber();
            case 3: return user.getEmail();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        // Devuelve el nombre de una columna específica
        return columnNames[column];
    }

    public User getUserAt(int rowIndex) {
        // Devuelve el usuario en una fila específica
        return userList.get(rowIndex);
    }

    public void refreshData() {
        // Refresca la lista de usuarios obteniéndola nuevamente desde UserManager
        userList = UserManager.getInstance().getAllUsers();
        // Notifica a la tabla que los datos han cambiado para que se actualice
        fireTableDataChanged();
    }
}

