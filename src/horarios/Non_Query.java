/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horarios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Derian Iqbal
 */
public class Non_Query {
    
    Conexion conexion = new Conexion();
    
    public void Test() {
        try {
            // Establecer la conexión
            Connection conn = conexion.Conectar();
            
            // Llamar al procedimiento almacenado
            CallableStatement cs = conn.prepareCall("{call PA_TEST()}");
            ResultSet rs = cs.executeQuery();
            
            // Mostrar el resultado en la consola
            while (rs.next()) {
                System.out.println("ID_CURSO: " + rs.getInt("ID_CURSO") + ", ID_ASIGNATURA: " + rs.getInt("ID_ASIGNATURA") + ", ID_PERSONAL: " + rs.getInt("ID_PERSONAL") + ", ESPACIO: " + rs.getString("ESPACIO") + ", HORARIO: " + rs.getString("HORARIO"));
            }
            
            // Cerrar la conexión y liberar recursos
            rs.close();
            cs.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

