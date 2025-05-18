/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paula
 */
public class dataBaseConfig {
     private static final String URL = "jdbc:mysql://localhost:3307/organizadorlibros";
    private static final String USER = "root";
    private static final String PASSWORD = "Paulabetancourt";
    
    private static dataBaseConfig instance; 
    private Connection connection;
    
    private dataBaseConfig() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
            throw new SQLException("No se pudo establecer la conexión", e);
        }
    }
    
     public static dataBaseConfig getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new dataBaseConfig();
        }
        return instance;
    }
     
     public Connection getConnection(){
         return connection;
     }
}
