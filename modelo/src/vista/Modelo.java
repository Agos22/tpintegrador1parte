
package vista;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Modelo {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escuela","root", "");
        
            //Agregar alumno
           
            String sql="INSERT INTO alumno(id, nombre, apellido, edad, activo) "
                   + "VALUES (1, 'Mariana', 'Gomez', 23, 1)";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            int filas = ps.executeUpdate();
            System.out.println(filas);
                 
            JOptionPane.showMessageDialog(null, "alumno agregado exitosamente");
           
           //Actualizar alumno 
           
           /* String sqlact= "UPDATE alumno SET nombre = 'Gimena' WHERE id=1";
            PreparedStatement psa=conn.prepareStatement(sqlact);
            int registro=psa.executeUpdate();
            System.out.println(registro); */
            
           //Eliminar alumno 
           
           /*String sqleli= "DELETE FROM alumno WHERE id=2";
           PreparedStatement pseli=conn.prepareStatement(sqleli);
           int registro1=pseli.executeUpdate();
           System.out.println(registro1);*/
           
           
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "error al cragar el driver" + ex.getMessage());
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de conexion" + ex.getMessage());
        }
        
    }
}