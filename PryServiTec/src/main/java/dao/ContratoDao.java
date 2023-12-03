package dao;

import modelo.*;
import util.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContratoDao { 
    Connection conn = MySQLConexion.getConexion();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;    
    
     public List<ContratoDto> listarContrato() {
        List<ContratoDto> contratos = new ArrayList<>();
        try {
            String query = "SELECT * FROM Contrato";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ContratoDto contrato = new ContratoDto();
                contrato.setCodiCont(resultSet.getString("codiCont"));
                contrato.setFechCont(resultSet.getString("fechCont"));
                contrato.setFechInicCont(resultSet.getString("fechInicCont"));
                contrato.setFechFincont(resultSet.getString("fechFinCont"));
                contrato.setEstCont(resultSet.getString("estaCont"));
                contrato.setDescCont(resultSet.getString("descCont"));
                contrato.setCodiEmpl(resultSet.getString("fk_codiEmpl"));
                contrato.setCodiTrab(resultSet.getString("fk_codiTrab"));
                contrato.setCodiNego(resultSet.getString("fk_codiNego"));

                
                contratos.add(contrato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }

    public List<ContratoDto> listarContXEmpleador(String empl) {
        List<ContratoDto> contratos = new ArrayList<>();
        try {
            // Utiliza una cláusula WHERE para filtrar por el ID del empleador
            String query = "SELECT * FROM Contrato WHERE fk_codiEmpl = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, empl);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ContratoDto contrato = new ContratoDto();
                contrato.setCodiCont(resultSet.getString("codiCont"));
                contrato.setFechCont(resultSet.getString("fechCont"));
                contrato.setFechInicCont(resultSet.getString("fechInicCont"));
                contrato.setFechFincont(resultSet.getString("fechFinCont"));
                contrato.setEstCont(resultSet.getString("estaCont"));
                contrato.setDescCont(resultSet.getString("descCont"));
                contrato.setCodiEmpl(resultSet.getString("fk_codiEmpl"));
                contrato.setCodiTrab(resultSet.getString("fk_codiTrab"));
                contrato.setCodiNego(resultSet.getString("fk_codiNego"));

                contratos.add(contrato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }
    
    public String obtenerNuevoCodigoContrato() {
        String nuevoCodigo = null;

        String obtenerUltimoCodigoSQL = "SELECT CONCAT('C', LPAD(COALESCE(MAX(SUBSTRING(codiCont, 2)), 0) + 1, 4, '0')) AS nuevoCodigo FROM contrato";

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
    
    // Método para crear un nuevo contrato
    public boolean nuevo(ContratoDto contrato) {
        String sql = "INSERT INTO contrato (codiCont, fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiEmpl, fk_codiTrab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, contrato.getCodiCont());
            st.setString(2, contrato.getFechCont());
            st.setString(3, contrato.getFechInicCont());
            st.setString(4, contrato.getFechFincont());
            st.setString(5, contrato.getEstCont());
            st.setString(6, contrato.getDescCont());
            st.setString(7, contrato.getCodiNego());
            st.setString(8, contrato.getCodiEmpl());
            st.setString(9, contrato.getCodiTrab());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0; // Retorna true si se insertó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retorna false en caso de error
    }
    
        // Método para actualizar un contrato existente
    public boolean editar(ContratoDto contrato) {
        String sql = "UPDATE contrato SET fechCont = ?, fechInicCont = ?, fechFinCont = ?, estaCont = ?, descCont = ?, fk_codiNego = ?, fk_codiEmpl = ?, fk_codiTrab = ? WHERE codiCont = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, contrato.getFechCont());
            st.setString(2, contrato.getFechInicCont());
            st.setString(3, contrato.getFechFincont());
            st.setString(4, contrato.getEstCont());
            st.setString(5, contrato.getDescCont());
            st.setString(6, contrato.getCodiNego());
            st.setString(7, contrato.getCodiEmpl());
            st.setString(8, contrato.getCodiTrab());
            st.setString(9, contrato.getCodiCont());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0; // Retorna true si se actualizó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retorna false en caso de error
    }

    // Método para eliminar un contrato existente por su código
    public boolean eliminar(String codiCont) {
        String sql = "DELETE FROM contrato WHERE codiCont = ?";

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, codiCont);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0; // Retorna true si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retorna false en caso de error
    }
}
