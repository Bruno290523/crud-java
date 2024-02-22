/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;

/*import com.sun.jdi.connect.spi.Connection;*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



/**
 *
 * @author Bruno
 */
public class conexion {
    
    String strConexionDB = "jdbc:sqlite:C:/Users/Bruno/Desktop/Proyectos/crud-java/db/sistema.s3db";
    Connection conn = null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            
            System.out.println("Error de conexión"+e);
        }
    }
    
    public int ejecutarSentenciaSQL(String srtSentenciaSQL){
        
        try {
            PreparedStatement pstm = conn.prepareStatement(srtSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
        
    }
    
    
}
