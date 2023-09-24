/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Janier Gomez 
 * @author Harold Molano
 */
/**
 * Esta clase proporciona una única instancia para la conexión a la base de datos SQLite.
 */
public class DBConnection {
    // La única instancia de esta clase (Singleton)
    private static DBConnection instance;
    // La conexión a la base de datos
    private Connection connection;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase
    private DBConnection() {
         System.out.println("Se ha creado una instancia de DBConnection.");
    }

    /**
     * Obtiene la única instancia de la clase DBConnection.
     *
     * @return La instancia de DBConnection
     */
    public static synchronized DBConnection getDBConnection() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Conecta a una base de datos SQLite.
     *
     * @param databaseName El nombre de la base de datos (sin la extensión .db)
     */
    public void connect(String databaseName) {
        try {
            // Se establece la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName + ".db");
        } catch (SQLException ex) {
            // Se maneja cualquier excepción de SQL e imprime un mensaje de error
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra la conexión a la base de datos, si está abierta.
     */
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                // Se cierra la conexión si no está cerrada
                connection.close();
            }
        } catch (SQLException ex) {
            // Se maneja cualquier excepción de SQL e imprime un mensaje de error
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}

