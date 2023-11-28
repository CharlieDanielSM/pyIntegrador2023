
package dao;

/* 🚀 Developed by NelsonJGP */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Autenticacion;
import modelo.Usuario;
import util.MySQLConexion;

public class daoUsuario {
    private Connection con = MySQLConexion.getConexion();

    // Obtener un usuario por su código
    public Usuario obtener(String codiUsua) {
        Usuario usuario = null;

        String sql = "SELECT passUsua, tipoUsua FROM usuario WHERE codiUsua = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiUsua);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String passUsua = rs.getString("passUsua");
                String tipoUsua = rs.getString("tipoUsua");

                usuario = new Usuario(codiUsua, passUsua, tipoUsua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    // Método para iniciar sesión con detalles de autenticación
    public Autenticacion autenticar(String codiUsua, String contraseña) {
        String sql = "SELECT passUsua FROM usuario WHERE codiUsua = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiUsua);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Usuario existe
                // Comprobar si la contraseña coincide
                if (validarContraseña(codiUsua, contraseña)) {
                    // Obtener los datos adicionales del usuario
                    Usuario usuarioAutenticado = obtener(codiUsua);
                    return new Autenticacion(true, true, usuarioAutenticado); // Usuario y contraseña válidos
                } else {
                    return new Autenticacion(true, false, null); // Contraseña incorrecta
                }
            } else {
                return new Autenticacion(false, false, null); // Usuario incorrecto
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Error
        return new Autenticacion(false, false, null);
    }

    public boolean validarContraseña(String codiUsua, String contraseña) {
        String sql = "SELECT passUsua FROM usuario WHERE codiUsua = ?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codiUsua);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String contraseñaDB = rs.getString("passUsua");
                return contraseña.equals(contraseñaDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Error o contraseña incorrecta
    }
}