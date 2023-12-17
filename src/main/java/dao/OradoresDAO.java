package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Orador;
import util.ConexionDB;

/**
 *
 * @author hector
 */
public class OradoresDAO
{
    // Método para Agregar Oradores
    public void agregarOrador(Orador orador)
    {
        String sql = "INSERT INTO oradores_2023 (nombre, apellido, tema, fecha_alta) VALUES (?, ?, ?, ?)";
        // Bloque try-with-resources
        // Asegura que los recursos abiertos en su declaración (dentro de los
        // paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, orador.getNombre());
            pstmt.setString(2, orador.getApellido());
            pstmt.setString(3, orador.getTema());
            pstmt.setDate(4, orador.getFechaAlta());
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Método para Obtener Orador por id
    public Orador obtenerPorId(int id)
    {
        String sql = "SELECT * FROM oradores_2023 WHERE id_orador = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                Orador orador = new Orador();
                orador.setIdOrador(rs.getInt("id_orador"));
                orador.setNombre(rs.getString("nombre"));
                orador.setApellido(rs.getString("apellido"));
                orador.setTema(rs.getString("tema"));
                orador.setFechaAlta(rs.getDate("fecha_alta"));
                // Retorno información de la BD del id pedido
                return orador;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    // Método para Obtener Lista de Oradores
    public List<Orador> obtenerTodos()
    {
        // Creo un ArrayList para guardar todos los Oradores de la BD
        List<Orador> oradores = new ArrayList<>();
        String sql = "SELECT * FROM oradores_2023";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Orador orador = new Orador();
                orador.setIdOrador(rs.getInt("id_orador"));
                orador.setNombre(rs.getString("nombre"));
                orador.setApellido(rs.getString("apellido"));
                orador.setTema(rs.getString("tema"));
                orador.setFechaAlta(rs.getDate("fecha_alta"));
                // Guardo en el ArrayList la información de un registro de la BD
                oradores.add(orador);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        // Retorno la lista completa de Oradores de la BD
        return oradores;
    }

    // Método para Actualizar Oradores
    public void actualizarOrador(Orador orador)
    {
        String sql = "UPDATE oradores_2023 SET nombre = ?, apellido = ?, tema = ?, fecha_alta = ? WHERE id_orador = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, orador.getNombre());
            pstmt.setString(2, orador.getApellido());
            pstmt.setString(3, orador.getTema());
            pstmt.setDate(4, orador.getFechaAlta());
            pstmt.setInt(5, orador.getIdOrador());
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Método para Eliminar un Orador por medio del id
    public void eliminarOrador(int id)
    {
        String sql = "DELETE FROM oradores_2023 WHERE id_orador = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
