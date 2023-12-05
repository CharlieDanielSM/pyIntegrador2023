package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadorDto;
import modelo.empleador;
import util.MySQLConexion;

public class daoEmpleador {

    // Método para obtener todos los empleadores
    public List<empleador> listar() {
        List<empleador> empleadores = new ArrayList<>();

        String sql = "SELECT codiEmpl, dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, fk_codiUsua FROM empleador";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String codiEmpl = rs.getString("codiEmpl");
                String dniRucEmpl = rs.getString("dniRucEmpl");
                String nombEmpl = rs.getString("nombEmpl");
                String teleEmpl = rs.getString("teleEmpl");
                String emailEmpl = rs.getString("emailEmpl");
                String fk_codiTipoEmpl = rs.getString("fk_codiTipoEmpl");
                String fk_codiUsua = rs.getString("fk_codiUsua");

                empleador empleador = new empleador(codiEmpl, dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, fk_codiUsua);
                empleadores.add(empleador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleadores;
    }

    // Método para obtener un solo empleador por su código
 public empleador obtener(String fk_codiUsua) {
    empleador empleador = null;

    String sql = "SELECT dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, codiEmpl FROM empleador WHERE fk_codiUsua = ?";

    try (Connection con = MySQLConexion.getConexion();
         PreparedStatement st = con.prepareStatement(sql)) {

        st.setString(1, fk_codiUsua);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                String dniRucEmpl = rs.getString("dniRucEmpl");
                String nombEmpl = rs.getString("nombEmpl");
                String teleEmpl = rs.getString("teleEmpl");
                String emailEmpl = rs.getString("emailEmpl");
                String fk_codiTipoEmpl = rs.getString("fk_codiTipoEmpl");
                String codiEmpl = rs.getString("codiEmpl");

                empleador = new empleador(codiEmpl, dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, fk_codiUsua);
                
            
            
            
            
            
            
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return empleador;
}


    // Método para crear un nuevo empleador
    public boolean crear(empleador empleador) {
        String sql = "INSERT INTO empleador (codiEmpl, dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, fk_codiUsua) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, empleador.getCodiEmpl());
            st.setString(2, empleador.getDniRucEmpl());
            st.setString(3, empleador.getNombEmpl());
            st.setString(4, empleador.getTeleEmpl());
            st.setString(5, empleador.getEmailEmpl());
            st.setString(6, empleador.getFk_codiTipoEmpl());
            st.setString(7, empleador.getFk_codiUsua());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para editar un empleador existente
    public boolean editar(empleador empleador) {
        String sql = "UPDATE empleador SET dniRucEmpl = ?, nombEmpl = ?, teleEmpl = ?, emailEmpl = ?, fk_codiTipoEmpl = ?, fk_codiUsua = ? WHERE codiEmpl = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, empleador.getDniRucEmpl());
            st.setString(2, empleador.getNombEmpl());
            st.setString(3, empleador.getTeleEmpl());
            st.setString(4, empleador.getEmailEmpl());
            st.setString(5, empleador.getFk_codiTipoEmpl());
            st.setString(6, empleador.getFk_codiUsua());
            st.setString(7, empleador.getCodiEmpl());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para eliminar un empleador existente por su código
    public boolean eliminar(String codiEmpl) {
        String sql = "DELETE FROM empleador WHERE codiEmpl = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codiEmpl);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    // Método para obtener el nuevo código de empleador
    public String obtenerNuevoCodigoEmpleador() {
        String nuevoCodigo = null;

        String obtenerUltimoCodigoSQL = "SELECT CONCAT('E', LPAD(COALESCE(MAX(SUBSTRING(codiEmpl, 2)), 0) + 1, 4, '0')) AS nuevoCodigo FROM empleador";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(obtenerUltimoCodigoSQL);
             ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                nuevoCodigo = rs.getString("nuevoCodigo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nuevoCodigo;
    }
}