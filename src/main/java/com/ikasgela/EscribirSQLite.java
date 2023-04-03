package com.ikasgela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EscribirSQLite {

    public static void main(String[] args) {

        // Cadena de conexión
        String cadenaConexion = "jdbc:sqlite:corredores.sqlite";

        try {
            // Conectar a la BD
            Connection conexion = DriverManager.getConnection(cadenaConexion);

            // Inserción
            String sql = "INSERT INTO corredores (nombre, dorsal, mejor_marca) VALUES( ?, ?, ? )";

            PreparedStatement pst = conexion.prepareStatement(sql);

            // El campo id está definido como autoincremental en la base de datos
            pst.setString(1, "Ion");
            pst.setInt(2, 1001);
            pst.setDouble(3, 3800);

            int filasModificadas = pst.executeUpdate();

            if (filasModificadas > 0) {
                System.out.println("OK");
            } else {
                System.err.println("ERROR: Algo no ha ido bien...");
            }

            // Desconectar
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
