
package dao;

/* 🚀 Developed by NelsonJGP */
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Autenticacion;
import modelo.Usuario;
import modelo.empleador;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
    
    
        public String obtenertipocuenta(String fk_codiTipoEmpl){
         String sql="SELECT nomnTipoEmpl FROM `bdservitec`.`tipoempleador` WHERE `codiTipoEmpl` = ? ";
            String tipocuenta="";
            try {
             PreparedStatement st = con.prepareStatement(sql);
               st.setString(1, tipocuenta);
            ResultSet rs = st.executeQuery();
                    if (rs.next()) {
            tipocuenta = rs.getString("nomnTipoEmpl");
        }
                    rs.close();
                    st.close();
            } catch (Exception e) {
            }
            return tipocuenta;
         }
     public void Iniciartabla(DefaultTableModel model){
         String sql="SELECT \n" +
            "    c.codiEmpl, \n" +
            "    c.dniRucEmpl, \n" +
            "    c.nombEmpl, \n" +
            "    c.teleEmpl, \n" +
            "    c.emailEmpl, \n" +
            "    t.nombTipoEmpl, \n" +
            "    c.fk_codiUsua, \n" +
            "    u.passUsua \n" +
            "FROM \n" +
            "    empleador c\n" +
            "LEFT JOIN \n" +
            "    usuario u ON c.fk_codiUsua = u.codiUsua\n" +
            "LEFT JOIN \n" +
            "    tipoempleador t ON c.fk_codiTipoEmpl = t.codiTipoEmpl";
                 
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String IDEMPLEADO = rs.getString("codiEmpl");
            String DNI = rs.getString("dniRucEmpl");
            String NOMBRE = rs.getString("nombEmpl");
            String TELEFONO = rs.getString("teleEmpl");
            String EMAIL = rs.getString("emailEmpl");
            String TIPOCUENTA = rs.getString("nombTipoEmpl");
            String CODIGO = rs.getString("fk_codiUsua");
            String CONTRA = rs.getString("passUsua");

 

            model.addRow(new Object[]{IDEMPLEADO, TIPOCUENTA, CODIGO, CONTRA, DNI, NOMBRE, TELEFONO, EMAIL});

        }
         } catch (Exception e) {
         }
     
     
     }
      public boolean usuarioverificar(String nombreuser){
      
         try {
           String sql="SELECT * FROM usuario WHERE codiUsua = ?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, nombreuser);
         ResultSet rs = ps.executeQuery();
         boolean usuarioverificado = rs.next();
        rs.close();
        ps.close();

        return usuarioverificado;
        } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }
            public boolean dniverificar(String dni){
      
         try {
           String sql="SELECT * FROM empleador WHERE dniRucEmpl = ?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, dni);
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
                        public boolean correoverificar (String correo){
      
         try {
           String sql="SELECT * FROM empleador WHERE emailEmpl = ?";
         PreparedStatement ps = con.prepareStatement(sql);
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
   public String generarCodigoEspecialidad() {
        String nuevoCodigo = null;

        try {
            String sql = "SELECT MAX(codiEmpl) AS ultimoCodigo FROM empleador";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String ultimoCodigo = rs.getString("ultimoCodigo");

                if (ultimoCodigo != null && ultimoCodigo.matches("^[E]\\d{3}$")) {
                    int numero = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
                    nuevoCodigo = String.format("E%03d", numero);
                } else {
                    nuevoCodigo = "E001";
                }
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en una aplicación real
        }

        return nuevoCodigo;
    }
 public void eliminarUsuario(String id) {
    try {
        String sql = "DELETE FROM usuario WHERE codiUsua = ?";
        String sql2="Delete from empleador where fk_codiUsua=?";
        try(PreparedStatement ps = con.prepareStatement(sql2)){
        ps.setString(1, id);
        ps.executeUpdate();
        }
        try(PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
            ps.close();}
        

    } catch (SQLException e) {
        e.printStackTrace();

    } 
}
     public void crearUsuario(Usuario usuario,empleador empleador) {
        Connection con = MySQLConexion.getConexion();

        String sql = "INSERT INTO usuario (CodiUsua, passUsua, TipoUsua) VALUES (?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, usuario.getCodiUsua());
            st.setString(2, usuario.getPassUsua());
            st.setString(3, usuario.getTipoUsua());
            st.executeUpdate();

                
                insertarempleador(empleador);

            st.close();
                  } catch (SQLException e) {
            e.printStackTrace();
                  }
}
         private void insertarempleador(empleador empleador) {
        
         Connection con = MySQLConexion.getConexion();
        String sql = "INSERT INTO empleador (codiEmpl, dniRucEmpl, nombEmpl, teleEmpl, emailEmpl, fk_codiTipoEmpl, fk_codiUsua) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empleador.getCodiEmpl());
            ps.setString(2, empleador.getDniRucEmpl());
            ps.setString(3, empleador.getNombEmpl());
            ps.setString(4, empleador.getTeleEmpl());
            ps.setString(5, empleador.getEmailEmpl());
            ps.setString(6, empleador.getFk_codiTipoEmpl());
            ps.setString(7, empleador.getFk_codiUsua());
            ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO");  

        } catch (SQLException e) {
                System.out.println("ERROR USUARIO");
                e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
   public void  actualizarusuario(String codiEmpl,  String dniRucEmpl,String nomEmpl,String teleEmpl,String emailEmpl,String fk_codiTipoEmpl,String fk_codiUsua,String contra){
                 Connection con = MySQLConexion.getConexion(); 
               String sql2="Update usuario Set passUsua=?,tipoUsua=? where codiUsua=?";
               String sql = "UPDATE empleador SET codiEmpl=?, dniRucEmpl=?, nombEmpl=?, teleEmpl=?, emailEmpl=?, fk_codiTipoEmpl=? WHERE fk_codiUsua=?";
            try {
                try(PreparedStatement ps=con.prepareStatement(sql2)){
                  ps.setString(1, contra);
                  ps.setString(2, "cliente");
                  ps.setString(3, fk_codiUsua);
                 ps.executeUpdate();
                }
               try(PreparedStatement ps=con.prepareStatement(sql)){
                
                  ps.setString(1, codiEmpl);
                  ps.setString(2, dniRucEmpl);
                  ps.setString(3, nomEmpl);
                  ps.setString(4, teleEmpl);
                  ps.setString(5, emailEmpl);
                  ps.setString(6, fk_codiTipoEmpl);
                  ps.setString(7, fk_codiUsua);
                  ps.executeUpdate();   
                                    JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO");

            }

            } catch (Exception e) {
                System.out.println("error"+e);
          } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión en el bloque finally
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
       public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    org.apache.poi.ss.usermodel.Row fila =  hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    org.apache.poi.ss.usermodel.Row fila =  hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
public boolean verificarContra(String usuario, String contraActual) {
    String sql = "SELECT passUsua FROM usuario WHERE codiUsua = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String passGuardada = rs.getString("passUsua");
            if (passGuardada.equals(contraActual)) {
                return true; // Contraseña válida
            } else {
                return false; // Contraseña no coincide
            }
        } else {
            return false; // No se encontró el usuario
        }
    } catch (SQLException e) {
        // Manejar la excepción adecuadamente
        e.printStackTrace();
        System.out.println("ERROR CONTRA");
        return false;
          } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión en el bloque finally
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

      public void cambiar_contra(String usuario,String contranueva){
String sql = "UPDATE usuario SET passUsua = ? WHERE codiUsua = ? AND tipoUsua = 'cliente'";
                           try {
                try(PreparedStatement ps=con.prepareStatement(sql)){
                
                  ps.setString(1, contranueva);
                  ps.setString(2, usuario);
 
                 ps.executeUpdate();
                                                     JOptionPane.showMessageDialog(null, "CONTRASEÑA ACTUALIZADO");

                }
 

            } catch (Exception e) {
                System.out.println("error"+e);
          } finally {
            try {
                if (con != null) {
                    con.close(); // Cierra la conexión en el bloque finally
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
  }
   
}