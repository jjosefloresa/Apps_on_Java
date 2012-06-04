package aplicacionoracle;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionBD {
    static Connection conexion;
    static Statement sentencia;
    static ResultSet resultado;
    static String passw = "", userna = "";
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static void main(String [] args){
        openDB();
        //Exemplo calld = new Exemplo();
       // calld.main(args);
    }
            
    public static void openDB(){
        userna = JOptionPane.showInputDialog("Usuario de la BD");
        passw = JOptionPane.showInputDialog("Password de la BD");
        //userna  ="SYSTEM";
        //passw = "admin";
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                conexion=DriverManager.getConnection(url, userna, passw);
                System.out.println("Conexion a BD correcta");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"ERROR, parametros de conexion incorrectos");
                System.exit(0);
                //openDB();
            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "ERROR al cargar el DRIVER");
                System.exit(0);
            }
        }
        
        public void closeBD(){
            try{
                if(conexion != null){
                    conexion.close();
                }
                if(resultado != null){
                    resultado.close();
                }
                if(sentencia != null){
                    sentencia.close();
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR al cerrar la conexión");
                System.exit(0);
            }
        }
        
        public static ResultSet consultar (String peticion){   // Select
            try {
                sentencia = conexion.createStatement();
                resultado = sentencia.executeQuery(peticion);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR al consultar");
            }
            return resultado;
        }
        
        public static void actualizar (String peticion){    // insert, update, delete
            try {
                sentencia = conexion.createStatement();
                sentencia.executeUpdate(peticion);
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR en la operación");
            }
        }
}