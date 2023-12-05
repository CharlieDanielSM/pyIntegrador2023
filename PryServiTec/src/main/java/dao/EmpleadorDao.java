
package dao;
import modelo.EmpleadorDto;

import util.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.empleador;



public class EmpleadorDao 
{
    
    Connection conn = MySQLConexion.getConexion();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;  
    

    public List<EmpleadorDto> listarEmpleadores() {
        List<EmpleadorDto> empleadores = new ArrayList<>();
        try {
            String query = "SELECT * FROM Empleador";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmpleadorDto empleador = new EmpleadorDto();
                empleador.setCodiEmpl(resultSet.getString("codiEmpl"));
                empleador.setDniRucEmpl(resultSet.getString("dniRucEmpl"));
                empleador.setNombEmpl(resultSet.getString("nombEmpl"));
                empleador.setTeleEmp(resultSet.getString("teleEmpl"));
                empleador.setEmailEmpl(resultSet.getString("emailEmpl"));

                // Establece otros atributos del empleador si los hay
                empleadores.add(empleador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleadores;
    }

    public EmpleadorDto obtenerEmpleadorPorID(String idEmpleador) {
        EmpleadorDto empleador = null;
        try {

            String query = "SELECT * FROM Empleador WHERE codiEmpl = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, idEmpleador);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
    } 
        return empleador;
    }
    public boolean correoverificar (String correo){
         try {
           String sql="SELECT * FROM trabajador WHERE emailTrab = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, correo);
         ResultSet rs = ps.executeQuery();
         boolean dniverificar = rs.next();
        rs.close();
        ps.close();

        return dniverificar;
        } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }
   
    public void ACTUALIZARMPLEADO(String nomEmpl, String teleEmpl, String emailEmpl, String fk_codiUsua, String nuevousuario) {
        String sql2 ="UPDATE usuario SET codiUsua = ? WHERE codiUsua = ?";

        String sql = "UPDATE empleador SET nombEmpl=?, teleEmpl=?, emailEmpl=? WHERE fk_codiUsua=?";

        try {
            try (PreparedStatement ps = conn.prepareStatement(sql2)) {
                ps.setString(1, nuevousuario);
                ps.setString(2, fk_codiUsua);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nomEmpl);
                ps.setString(2, teleEmpl);
                ps.setString(3, emailEmpl);
                ps.setString(4, nuevousuario);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO");
            }

        } catch (SQLException e) {
            // Manejar la excepción adecuadamente
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
              } finally {
                try {
                    if (conn != null) {
                        conn.close(); // Cierra la conexión en el bloque finally
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    public void eliminarUsuario(String id) {
       try {
           String sql = "DELETE FROM usuario WHERE codiUsua = ?";
           String sql2="Delete from empleador where fk_codiUsua=?";
           try(PreparedStatement ps = conn.prepareStatement(sql2)){
           ps.setString(1, id);
           ps.executeUpdate();
           }
           try(PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, id);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
               ps.close();}


       } catch (SQLException e) {
           e.printStackTrace();

       } 
   }

    public EmpleadorDto obtenerEmpleadorPorIDUsuario(String fk_codiUsua) {
        EmpleadorDto empleador = null;
        try {

            String query = "SELECT * FROM Empleador WHERE fk_codiUsua = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, fk_codiUsua);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                empleador = new EmpleadorDto();
                empleador.setCodiEmpl(resultSet.getString("codiEmpl"));
                empleador.setDniRucEmpl(resultSet.getString("dniRucEmpl"));
                empleador.setNombEmpl(resultSet.getString("nombEmpl"));
                empleador.setTeleEmp(resultSet.getString("teleEmpl"));
                empleador.setEmailEmpl(resultSet.getString("emailEmpl"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return empleador;
    }
}
