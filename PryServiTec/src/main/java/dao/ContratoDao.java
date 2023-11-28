

package dao;
import modelo.*;
import util.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContratoDao 
{ 
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

    
    
    
    
    
}
