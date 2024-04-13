/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horarios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Derian Iqbal
 */
public class Conexion {
    
    public Connection Conectar ()
    {
        Connection conexion= null;
        String url ="jdbc:mysql://localhost:3306/horarios?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user= "root";
        String password= "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e){
            //Manejo de errores
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base por:"+e);
        }
        return conexion;
    }
    
}
