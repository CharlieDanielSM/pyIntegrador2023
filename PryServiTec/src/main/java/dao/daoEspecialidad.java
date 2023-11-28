package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Especialidad;
import util.MySQLConexionOriginal;
import util.MySQLConexion;

/* 🚀 Developed by NelsonJGP */
public class daoEspecialidad {
    Connection con = MySQLConexion.getConexion();

    // Obtener todas las especialidades
    public List<Especialidad> listar() {
        List<Especialidad> especialidades = new ArrayList<>();

        // Reemplaza MySQLConexion con tu clase de conexión a la base de datos
        String sql = "SELECT codiEspe, nombEspe, precBaseEspe, descEspe FROM especialidad";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String codiEspe = rs.getString("codiEspe");
                String nombEspe = rs.getString("nombEspe");
                double precBaseEspe = rs.getDouble("precBaseEspe");
                String descEspe = rs.getString("descEspe");

                Especialidad esp = new Especialidad(codiEspe, nombEspe, precBaseEspe, descEspe);
                especialidades.add(esp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return especialidades;
    }

    // Obtener una sola especialidad por su código
    public Especialidad obtener(String codiEspe) {
        Especialidad especialidad = null;

        String sql = "SELECT nombEspe, precBaseEspe, descEspe FROM especialidad WHERE codiEspe = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiEspe);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String nombEspe = rs.getString("nombEspe");
                double precBaseEspe = rs.getDouble("precBaseEspe");
                String descEspe = rs.getString("descEspe");

                especialidad = new Especialidad(codiEspe, nombEspe, precBaseEspe, descEspe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return especialidad;
    }

    // Crear una nueva especialidad
    public boolean nuevo(Especialidad especialidad) {
        // Reemplaza MySQLConexion con tu clase de conexión a la base de datos
        String sql = "INSERT INTO especialidad (codiEspe, nombEspe, precBaseEspe, descEspe) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, especialidad.getCodiEspe());
            st.setString(2, especialidad.getNombEspe());
            st.setDouble(3, especialidad.getPrecBaseEspe());
            st.setString(4, especialidad.getDescEspe());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // La especialidad se creó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al crear la especialidad
    }

    public boolean editar(Especialidad especialidad) {
        String sql = "UPDATE especialidad SET nombEspe = ?, precBaseEspe = ?, descEspe = ? WHERE codiEspe = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, especialidad.getNombEspe());
            st.setDouble(2, especialidad.getPrecBaseEspe());
            st.setString(3, especialidad.getDescEspe());
            st.setString(4, especialidad.getCodiEspe());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // La especialidad se actualizó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al actualizar la especialidad
    }

    // Eliminar una especialidad existente por su código
    public boolean eliminar(String codiEspe) {
        String sql = "DELETE FROM especialidad WHERE codiEspe = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiEspe);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // La especialidad se eliminó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al eliminar la especialidad
    }
    
    public String obtenerIdEspecialidadPorNombre(String nombreEspecialidad) {
        String codigoEspecialidad = null;
        String sql = "SELECT codiEspe FROM especialidad WHERE nombEspe = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nombreEspecialidad);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                codigoEspecialidad = rs.getString("codiEspe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codigoEspecialidad;
    }
}