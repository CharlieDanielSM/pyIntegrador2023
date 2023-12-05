
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Servicios;
import modelo.Trabajador;
import modelo.Usuario;
import modelo.empleador;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
                String sexoTrab = rs.getString("sexoTrab");
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
                String sexoTrab = rs.getString("sexoTrab");
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
                    String sexoTrab = rs.getString("sexoTrab");
                    String emailTrab = rs.getString("emailTrab");
                    String codiUsua = rs.getString("codiUsua");

                    Trabajador trabajador = new Trabajador(codiTrab, dniTrab, nombTrab, ApelTrab, teleTrab, sexoTrab, emailTrab, codiEspe, codiUsua);
                    trabajadores.add(trabajador);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lista Vacia");
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
           String sql="SELECT * FROM trabajador WHERE dniTrab = ?";
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
           String sql="SELECT * FROM trabajador WHERE emailTrab = ?";
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
            String sql = "SELECT MAX(codiTrab) AS ultimoCodigo FROM trabajador";
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String ultimoCodigo = rs.getString("ultimoCodigo");

                if (ultimoCodigo != null && ultimoCodigo.matches("^[T]\\d{3}$")) {
                    int numero = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
                    nuevoCodigo = String.format("T%03d", numero);
                } else {
                    nuevoCodigo = "T001";
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
        String sql2="Delete from trabajador where fk_codiUsua=?";
        try(PreparedStatement ps = con.prepareStatement(sql2)){
        ps.setString(1, id);
        ps.executeUpdate();
        }
        try(PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "TRABAJADOR ELIMINADO");
            ps.close();}
        

    } catch (SQLException e) {
        e.printStackTrace();

    } 
}
            public void crearUsuario(Usuario usuario,Trabajador trabajador) {

        String sql = "INSERT INTO usuario (CodiUsua, passUsua, TipoUsua) VALUES (?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, usuario.getCodiUsua());
            st.setString(2, usuario.getPassUsua());
            st.setString(3, usuario.getTipoUsua());
            st.executeUpdate();

                
                insertartrabajador(trabajador);

            st.close();
                  } catch (SQLException e) {
            e.printStackTrace();
                  }
}
         private void insertartrabajador(Trabajador trabajador) {
        
        String sql = "INSERT INTO trabajador (codiTrab, dniTrab, nombTrab, apelTrab, teleTrab, sexoTrab, emailTrab,fk_codiEspe,fk_codiUsua) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trabajador.getCodiTrab());
            ps.setString(2, trabajador.getDniTrab());
            ps.setString(3, trabajador.getNombTrab());
            ps.setString(4, trabajador.getApelTrab());
            ps.setString(5, trabajador.getTeleTrab());
            ps.setString(6, trabajador.getSexoTrab());
            ps.setString(7, trabajador.getEmailTrab());
            ps.setString(8, trabajador.getCodiEspe());
            ps.setString(9, trabajador.getCodiUsua());            
            ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "TRABAJADOR REGISTRADO");  

        } catch (SQLException e) {
                System.out.println("ERROR USUARIO");
                e.printStackTrace();
    }
    }
      public String ObtenerCodigoXNombre(String nombreservicio) {
        String codigoServicio = null;

        try {
            String sql = "SELECT codiEspe FROM especialidad WHERE nombEspe = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nombreservicio);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                codigoServicio = rs.getString("codiEspe");
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en una aplicación real
        }

        return codigoServicio;
    }
      
    public Trabajador obtenerTrabajadorPorIDUsuario(String fk_codiUsua) {
        Trabajador trabajador = null;
        try {
            String sql = "SELECT * FROM Trabajador WHERE fk_codiUsua = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, fk_codiUsua);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setCodiTrab(rs.getString("codiTrab"));
                trabajador.setDniTrab(rs.getString("dniTrab"));
                trabajador.setNombTrab(rs.getString("nombTrab"));
                trabajador.setApelTrab(rs.getString("ApelTrab"));
                trabajador.setTeleTrab(rs.getString("teleTrab"));
                trabajador.setSexoTrab(rs.getString("sexoTrab"));
                trabajador.setEmailTrab(rs.getString("emailTrab"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabajador;
    }
    
           public void Iniciartabla(DefaultTableModel model){
         String sql="SELECT\n" +
                    "    t.codiTrab,\n" +
                    "    t.dniTrab,\n" +
                    "    t.nombTrab,\n" +
                    "    t.ApelTrab,\n" +
                    "    t.teleTrab,\n" +
                    "    t.sexoTrab,\n" +
                    "    t.emailTrab,\n" +
                    "    e.nombEspe,\n" +
                    "    t.fk_codiUsua,\n" +
                    "    u.passUsua\n" +
                    "FROM\n" +
                    "    trabajador t\n" +
                    "LEFT JOIN\n" +
                    "    usuario u ON t.fk_codiUsua = u.codiUsua\n" +
                    "LEFT JOIN\n" +
                    "    especialidad e ON t.`fk_codiEspe` = e.codiEspe";
                 
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String IDTRABAJADOR = rs.getString("codiTrab");
            String DNI = rs.getString("dniTrab");
            String NOMBRE = rs.getString("nombTrab");
            String APELLIDO = rs.getString("ApelTrab");  
            String SEXO = rs.getString("sexoTrab");  
            String TELEFONO = rs.getString("teleTrab");
            String EMAIL = rs.getString("emailTrab");
            String ESPECIALIDAD = rs.getString("nombEspe");  
            String CODIGO = rs.getString("fk_codiUsua");
            String CONTRA = rs.getString("passUsua");
            String idsexo="";
            if(SEXO.equals("F")){
                idsexo="F";
            }else{
              idsexo="M";

            }

            model.addRow(new Object[]{IDTRABAJADOR, CODIGO, CONTRA, DNI,ESPECIALIDAD, NOMBRE, APELLIDO,idsexo, TELEFONO, EMAIL});

        }
         } catch (Exception e) {
                             e.printStackTrace();

         }
     
     
     }
              public void  actualizarusuario(String passUsua, String tipoUsua, 
                                            String codiTrab, String dniTrab, String nombTrab, String ApelTrab,
                                            String teleTrab, String sexoTrab, String emailTrab,
                                            String fk_codiEspe,String fk_codiUsua){
               String sql2="Update usuario Set passUsua=?,tipoUsua=? where codiUsua=?";
               String sql = "UPDATE trabajador SET codiTrab =?, dniTrab =?, nombTrab=?, ApelTrab=?, teleTrab=?, sexoTrab=?,emailTrab=?,fk_codiEspe =? WHERE fk_codiUsua=?";
            try {
                try(PreparedStatement ps=con.prepareStatement(sql2)){
                  ps.setString(1, passUsua);
                  ps.setString(2, "trabajador");
                  ps.setString(3, fk_codiUsua);
                 ps.executeUpdate();
                }
               try(PreparedStatement ps=con.prepareStatement(sql)){
                
                  ps.setString(1, codiTrab);
                  ps.setString(2, dniTrab);
                  ps.setString(3, nombTrab);
                  ps.setString(4, ApelTrab);
                  ps.setString(5, teleTrab);
                  ps.setString(6, sexoTrab);
                  ps.setString(7, emailTrab);
                  ps.setString(8, fk_codiEspe);
                  ps.setString(9, fk_codiUsua);
                  ps.executeUpdate();   
                                    JOptionPane.showMessageDialog(null, "TRABAJADOR ACTUALIZADO");

            }

            } catch (Exception e) {
                System.out.println("error"+e);
 
}}
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
<<<<<<< HEAD
  public void ACTUALIZATRABA(String nomTrab,String apeTrab, String teleTrab, String emailTrab, String fk_codiUsua,String fk_codiEsp, String nuevousuario) {
    String sql2 ="UPDATE usuario SET codiUsua = ? WHERE codiUsua = ?";

    String sql = "UPDATE trabajador SET nomTrab=?,apeTrab=? teleTrab=?, emailTrab=?,fk_codiEspe=? WHERE fk_codiUsua=?";

    try {
        try (PreparedStatement ps = con.prepareStatement(sql2)) {
            ps.setString(1, nuevousuario);
            ps.setString(2, fk_codiUsua);
            ps.executeUpdate();
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nomTrab);
            ps.setString(2, apeTrab);
            ps.setString(3, teleTrab);
            ps.setString(4, emailTrab);
            ps.setString(5, fk_codiEsp);
            ps.setString(6, fk_codiUsua);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "TRABAJADOR ACTUALIZADO");
        }

    } catch (SQLException e) {
        // Manejar la excepción adecuadamente
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
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
=======
>>>>>>> c0e8717a57072df4bc6c9dfd6f1338352a4f5017
}
