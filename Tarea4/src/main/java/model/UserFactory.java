package model;

/* Clase UserFactory que crea instancias de la clase User.
 * Esta clase sigue el patrón Factory */

public class UserFactory {
    /*  Crear y retornar un nuevo objeto User, con el método estático. */
    public static User createUser(String username, String firstName, String lastName, String phoneNumber, String email, String password) {
        return new User(username, firstName, lastName, phoneNumber, email, password);
    }
}

