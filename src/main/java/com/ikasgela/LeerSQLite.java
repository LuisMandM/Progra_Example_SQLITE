package com.ikasgela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeerSQLite {

    public static void main(String[] args) {

        // Estructura de datos
        List<Corredor> lista = new ArrayList<>();

        // Cadena de conexión
        String cadenaConexion = "jdbc:sqlite:corredores.sqlite";

        try {
            // Conectar a la BD
            Connection conexion = DriverManager.getConnection(cadenaConexion);

            // Operaciones con la BD

            // Consulta simple
            String sql = "SELECT * FROM corredores";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Recorrer el ResultSet
            while (rs.next()) {

                Corredor corredor = new Corredor(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getInt("dorsal"),
                        rs.getDouble("mejor_marca")
                );

                lista.add(corredor);
            }

            // Desconectar
            conexion.close();

            // Mostrar los datos
            for (Corredor corredor : lista) {
                System.out.println(corredor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
