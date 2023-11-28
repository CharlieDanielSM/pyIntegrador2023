
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Negociacion;
import util.MySQLConexion;

/* 🚀 Developed by NelsonJGP */
public class daoNegociacion {
    // Método para obtener todas las negociaciones
    public List<Negociacion> listar() {
        List<Negociacion> negociaciones = new ArrayList<>();

        String sql = "SELECT codiNego, fechNego, estaNego, montNego, descNego, fk_codiTrab, fk_codiCliente FROM negociacion";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String codiNego = rs.getString("codiNego");
                java.sql.Date fechNego = rs.getDate("fechNego");
                String estaNego = rs.getString("estaNego");
                double montNego = rs.getDouble("montNego");
                String descNego = rs.getString("descNego");
                String fk_codiTrab = rs.getString("fk_codiTrab");
                String fk_codiCliente = rs.getString("fk_codiCliente");

                Negociacion negociacion = new Negociacion(codiNego, fechNego, estaNego, montNego, descNego, fk_codiTrab, fk_codiCliente);
                negociaciones.add(negociacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return negociaciones;
    }

    // Método para obtener una negociación por su código
    public Negociacion obtenerNegociacion(String codiNego) {
        Negociacion negociacion = null;

        String sql = "SELECT  FROM negociacion WHERE codiNego = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codiNego);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    java.sql.Date fechNego = rs.getDate("fechNego");
                    String estaNego = rs.getString("estaNego");
                    double montNego = rs.getDouble("montNego");
                    String descNego = rs.getString("descNego");
                    String fk_codiTrab = rs.getString("fk_codiTrab");
                    String fk_codiCliente = rs.getString("fk_codiCliente");

                    negociacion = new Negociacion(codiNego, fechNego, estaNego, montNego, descNego, fk_codiTrab, fk_codiCliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return negociacion;
    }

    // Método para crear una nueva negociación
    public boolean crear(Negociacion negociacion) {
        String sql = "INSERT INTO negociacion (codiNego, fechNego, estaNego, montNego, descNego, fk_codiTrab, fk_codiCliente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, negociacion.getCodiNego());
            st.setDate(2, negociacion.getFechNego());
            st.setString(3, negociacion.getEstaNego());
            st.setDouble(4, negociacion.getMontNego());
            st.setString(5, negociacion.getDescNego());
            st.setString(6, negociacion.getCodiTrab());
            st.setString(7, negociacion.getCodiCli());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    // Método para editar una negociación existente
    public boolean editar(Negociacion negociacion) {
        String sql = "UPDATE negociacion SET fechNego = ?, estaNego = ?, montNego = ?, descNego = ?, fk_codiTrab = ?, fk_codiEmpl = ? WHERE codiNego = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setDate(1, negociacion.getFechNego());
            st.setString(2, negociacion.getEstaNego());
            st.setDouble(3, negociacion.getMontNego());
            st.setString(4, negociacion.getDescNego());
            st.setString(5, negociacion.getCodiTrab());
            st.setString(6, negociacion.getCodiCli());
            st.setString(7, negociacion.getCodiNego());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para eliminar una negociación existente por su código
    public boolean eliminar(String codiNego) {
        String sql = "DELETE FROM negociacion WHERE codiNego = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codiNego);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    // Método para obtener el nuevo código de negociación
    public String obtenerNuevoCodigoNegociacion() {
        String nuevoCodigo = null;

        String obtenerUltimoCodigoSQL = "SELECT CONCAT('N', LPAD(COALESCE(MAX(SUBSTRING(codiNego, 2)), 0) + 1, 4, '0')) AS nuevoCodigo FROM negociacion";

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
