
package dao;

/* 🚀 Developed by NelsonJGP */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contrato;
import util.MySQLConexion;

public class daoContrato {
    private Connection con = MySQLConexion.getConexion();

    // Obtener todos los contratos
    public List<Contrato> listar() {
        List<Contrato> contratos = new ArrayList<>();

        String sql = "SELECT codiCont, fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiTrab, fk_codiEmpl FROM contrato";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String codiCont = rs.getString("codiCont");
                java.sql.Date fechCont = rs.getDate("fechCont");
                java.sql.Date fechInicCont = rs.getDate("fechInicCont");
                java.sql.Date fechFinCont = rs.getDate("fechFinCont");
                String estaCont = rs.getString("estaCont");
                String descCont = rs.getString("descCont");
                String fk_codiNego = rs.getString("fk_codiNego");
                String fk_codiTrab = rs.getString("fk_codiTrab");
                String fk_codiEmpl = rs.getString("fk_codiEmpl");

                Contrato contrato = new Contrato(codiCont, fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiTrab, fk_codiEmpl);
                contratos.add(contrato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contratos;
    }

    // Obtener un solo contrato por su código
    public Contrato obtener(String codiCont) {
        Contrato contrato = null;

        String sql = "SELECT fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiTrab, fk_codiEmpl FROM contrato WHERE codiCont = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiCont);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                java.sql.Date fechCont = rs.getDate("fechCont");
                java.sql.Date fechInicCont = rs.getDate("fechInicCont");
                java.sql.Date fechFinCont = rs.getDate("fechFinCont");
                String estaCont = rs.getString("estaCont");
                String descCont = rs.getString("descCont");
                String fk_codiNego = rs.getString("fk_codiNego");
                String fk_codiTrab = rs.getString("fk_codiTrab");
                String fk_codiEmpl = rs.getString("fk_codiEmpl");

                contrato = new Contrato(codiCont, fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiTrab, fk_codiEmpl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contrato;
    }

    // Crear un nuevo contrato
    public boolean crear(Contrato contrato) {
        String sql = "INSERT INTO contrato (codiCont, fechCont, fechInicCont, fechFinCont, estaCont, descCont, fk_codiNego, fk_codiTrab, fk_codiEmpl) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, contrato.getCodiCont());
            st.setDate(2, contrato.getFechCont());
            st.setDate(3, contrato.getFechInicCont());
            st.setDate(4, contrato.getFechFinCont());
            st.setString(5, contrato.getEstaCont());
            st.setString(6, contrato.getDescCont());
            st.setString(7, contrato.getFk_codiNego());
            st.setString(8, contrato.getFk_codiTrab());
            st.setString(9, contrato.getFk_codiEmpl());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para editar un contrato existente
    public boolean editar(Contrato contrato) {
        String sql = "UPDATE contrato SET fechCont = ?, fechInicCont = ?, fechFinCont = ?, estaCont = ?, descCont = ?, fk_codiNego = ?, fk_codiTrab = ?, fk_codiEmpl = ? WHERE codiCont = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1, contrato.getFechCont());
            st.setDate(2, contrato.getFechInicCont());
            st.setDate(3, contrato.getFechFinCont());
            st.setString(4, contrato.getEstaCont());
            st.setString(5, contrato.getDescCont());
            st.setString(6, contrato.getFk_codiNego());
            st.setString(7, contrato.getFk_codiTrab());
            st.setString(8, contrato.getFk_codiEmpl());
            st.setString(9, contrato.getCodiCont());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para eliminar un contrato existente por su código
    public boolean eliminar(String codiCont) {
        String sql = "DELETE FROM contrato WHERE codiCont = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiCont);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
}
