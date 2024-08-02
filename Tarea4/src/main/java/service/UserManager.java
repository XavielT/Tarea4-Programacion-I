package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

/* esta clase UserManager gestiona las operaciones que hace el usuario,
 * Digase la búsqueda, actualización, eliminación de usuarios, etc.
 * En esta clase esta el patrón Singleton, basicamente asegurando 
 * que solo exista una instancia de UserManager. */

public class UserManager {
    // Instancia única de UserManager
    private static UserManager instance;
    // Lista para almacenar los usuarios
    private List<User> userList;

    // Un constructor privado pa' iniciar la lista de usuarios.
    // Privado pa' evitar crear varias instancias de UserManager.
    private UserManager() {
        userList = new ArrayList<>();
    }

    // Método estático que retorna la instancia única de UserManager.
     // Si no existe, se crea y luego se retorna.
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    // Método pa' agregar nuevos usuarios a la lista.
    public void addUser(User user) {
        userList.add(user);
    }

    // Método para obtener un usuario basado en su nombre de
    // usuario y contraseña.
    public User getUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Método que retorna una lista de todos los usuarios.
    public List<User> getAllUsers() {
        return userList;
    }

    public void updateUser(User user) {
        // Método pa' actualizar un usuario existente.
    }

    // Método para eliminar un usuario.
    public void deleteUser(User user) {
        userList.remove(user);
    }
}

