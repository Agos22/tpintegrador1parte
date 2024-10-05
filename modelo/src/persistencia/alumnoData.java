
package persistencia;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;


public class alumnoData {
   
    private Connection connection;

    public alumnoData(conexion conexion) {
        
        connection = conexion.getConnection();
    }
    
    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT * INTO alumno (nombre, apellido, edad, activo) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setBoolean(4, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alu = new Alumno();
                alu.setId(rs.getInt("id"));
                alu.setNombre(rs.getString("nombre"));
                alu.setApellido(rs.getString("apellido"));
                alu.setEdad(rs.getInt("edad"));
                alu.setActivo(rs.getBoolean("activo"));
                alumnos.add(alu);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
    
