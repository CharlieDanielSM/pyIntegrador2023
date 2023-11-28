
package dao;

/* 🚀 Developed by NelsonJGP */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Trabajador;
import util.MySQLConexion;

public class daoTrabajador {
    private Connection con = MySQLConexion.getConexion();

    // Obtener todos los trabajadores
    public List<Trabajador> listar() {
        List<Trabajador> trabajadores = new ArrayList<>();

        // Reemplaza MySQLConexion con tu clase de conexión a la base de datos
        String sql = "SELECT codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, fk_codiEspe, fk_codiUsua FROM trabajador";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String codiTrab = rs.getString("codiTrab");
                String dniTrab = rs.getString("dniTrab");
                String nombTrab = rs.getString("nombTrab");
                String ApelTrab = rs.getString("ApelTrab");
                String teleTrab = rs.getString("teleTrab");
                char sexoTrab = rs.getString("sexoTrab").charAt(0);
                String emailTrab = rs.getString("emailTrab");
                String codiEspe = rs.getString("fk_codiEspe");
                String codiUsua = rs.getString("fk_codiUsua");

                Trabajador trab = new Trabajador(codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, codiEspe, codiUsua);
                trabajadores.add(trab);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabajadores;
    }

    // Obtener un solo trabajador por su código
    public Trabajador obtener(String codiTrab) {
        Trabajador trabajador = null;

        String sql = "SELECT dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, fk_codiEspe, fk_codiUsua FROM trabajador WHERE codiTrab = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiTrab);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String dniTrab = rs.getString("dniTrab");
                String nombTrab = rs.getString("nombTrab");
                String ApelTrab = rs.getString("ApelTrab");
                String teleTrab = rs.getString("teleTrab");
                char sexoTrab = rs.getString("sexoTrab").charAt(0);
                String emailTrab = rs.getString("emailTrab");
                String codiEspe = rs.getString("fk_codiEspe");
                String codiUsua = rs.getString("fk_codiUsua");

                trabajador = new Trabajador(codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, codiEspe, codiUsua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabajador;
    }

    // Crear un nuevo trabajador
    public boolean nuevo(Trabajador trabajador) {
        // Reemplaza MySQLConexion con tu clase de conexión a la base de datos
        String sql = "INSERT INTO trabajador (codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, fk_codiEspe, fk_codiUsua) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trabajador.getCodiTrab());
            st.setString(2, trabajador.getDniTrab());
            st.setString(3, trabajador.getNombTrab());
            st.setString(4, trabajador.getApelTrab());
            st.setString(5, trabajador.getTeleTrab());
            st.setString(6, String.valueOf(trabajador.getSexoTrab()));
            st.setString(7, trabajador.getEmailTrab());
            st.setString(8, trabajador.getCodiEspe());
            st.setString(9, trabajador.getCodiUsua());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // El trabajador se creó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al crear el trabajador
    }

    public boolean editar(Trabajador trabajador) {
        String sql = "UPDATE trabajador SET dniTrab = ?, nombTrab = ?, ApelTrab = ?, teleTrab = ?, sexoTrab = ?, emailTrab = ?, fk_codiEspe = ?, fk_codiUsua = ? WHERE codiTrab = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trabajador.getDniTrab());
            st.setString(2, trabajador.getNombTrab());
            st.setString(3, trabajador.getApelTrab());
            st.setString(4, trabajador.getTeleTrab());
            st.setString(5, String.valueOf(trabajador.getSexoTrab()));
            st.setString(6, trabajador.getEmailTrab());
            st.setString(7, trabajador.getCodiEspe());
            st.setString(8, trabajador.getCodiUsua());
            st.setString(9, trabajador.getCodiTrab());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // El trabajador se actualizó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al actualizar el trabajador
    }

    // Eliminar un trabajador existente por su código
    public boolean eliminar(String codiTrab) {
        String sql = "DELETE FROM trabajador WHERE codiTrab = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiTrab);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return true; // El trabajador se eliminó con éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Hubo un error al eliminar el trabajador
    }
    
    /*-=-=-=-=*/
    // Obtener trabajadores por especialidad
    public List<Trabajador> obtenerTrabajadoresPorEspecialidad(String codiEspe) {
        List<Trabajador> trabajadores = new ArrayList<>();

        // Reemplaza MySQLConexion con tu clase de conexión a la base de datos
        String sql = "SELECT codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, codiEspe, codiUsua FROM trabajador WHERE codiEspe = ?";

        try (Connection con = MySQLConexion.getConexion();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codiEspe);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String codiTrab = rs.getString("codiTrab");
                    String dniTrab = rs.getString("dniTrab");
                    String nombTrab = rs.getString("nombTrab");
                    String ApelTrab = rs.getString("ApelTrab");
                    String teleTrab = rs.getString("teleTrab");
                    char sexoTrab = rs.getString("sexoTrab").charAt(0);
                    String emailTrab = rs.getString("emailTrab");
                    String codiUsua = rs.getString("codiUsua");

                    Trabajador trabajador = new Trabajador(codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, codiEspe, codiUsua);
                    trabajadores.add(trabajador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabajadores;
    }
    
    public double obtenerPromedioCalificaciones(String codiTrabajador) {
        double promedio = 0.0; int totalCalificaciones = 0;
        String sql = "SELECT puntuacion FROM calificacion WHERE fk_codiTrab = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiTrabajador);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int calificacion = rs.getInt("puntuacion");
                promedio += calificacion;
                totalCalificaciones++;
            }
            if (totalCalificaciones > 0) {
                promedio /= totalCalificaciones;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promedio;
    }
}
