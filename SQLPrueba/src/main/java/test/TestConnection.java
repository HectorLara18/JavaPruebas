package test;

import java.sql.*;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try{
            Connection conexion = DriverManager.getConnection(url,"root", "admin");
            Statement instruccion = conexion.createStatement();
            var query = "SELECT id_persona, nombre, apellido FROM persona";
            ResultSet resultado = instruccion.executeQuery(query);
            while(resultado.next()){
                System.out.print("Id Persona: " + resultado.getInt("id_persona"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }

    }
}
