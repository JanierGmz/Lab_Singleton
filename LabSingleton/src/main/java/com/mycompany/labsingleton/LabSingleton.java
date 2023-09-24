/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labsingleton;

import data.DBConnection;
/**
 *
 * @author Janier Gomez 
 * @author Harold Molano
 */
/**
 * Esta clase representa una prueba del patrón Singleton utilizando la clase DBConnection.
 * Simultáneamente, se crean dos hilos para probar la obtención de la misma instancia de DBConnection.
 * Cada hilo se conecta y desconecta de una base de datos diferente.
 */
public class LabSingleton {

    public static void main(String[] args) {
       DBConnection conn = DBConnection.getDBConnection();
       conn.connect("empleados");
       conn.disconnect();
       DBConnection conn2 = DBConnection.getDBConnection();
       conn2.connect("nomina");
       conn2.disconnect();
       //DBConnection conn3 = new DBConnection(); //esta line provocaria error
    }
}

