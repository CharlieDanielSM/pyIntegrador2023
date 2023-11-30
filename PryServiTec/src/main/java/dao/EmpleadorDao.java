
package dao;
import modelo.EmpleadorDto;

import util.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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
                empleador.setTeleEmp(resultSet.getString("teleEmp"));
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
