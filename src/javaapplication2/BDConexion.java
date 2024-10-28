package javaapplication2;
import java.sql.*;
/**
 *
 * @author reymi
 */
public class BDConexion {
    static String url = "jdbc:mysql://127.0.0.1/Hospitales";
    static String user = "samuel";
    static String password = "password";   
    
    public static Connection conectar(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
