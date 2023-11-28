package vista;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.formdev.flatlaf.FlatLightLaf;
import dao.daoUsuario;
import modelo.Autenticacion;
import modelo.Usuario;
/**
 *
 * @author Nelson
 */
public class frmLogin extends javax.swing.JFrame {
    daoUsuario daoUser = new daoUsuario();
    boolean mostrarContrasena = false;
    
    public frmLogin() {
        FlatLightLaf.setup();
        initComponents();
        imageIconCambiar(frmLogin.class.getResource("/images/con_ocultar.png"),passicon,20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        errorCon = new javax.swing.JLabel();
        errorUs = new javax.swing.JLabel();
        campoCon = new javax.swing.JPasswordField();
        campoUsu = new javax.swing.JTextField();
        Separator2 = new javax.swing.JSeparator();
        Separator1 = new javax.swing.JSeparator();
        btnIngresar = new guiRecursos.cstmButon();
        btnRegistrar = new guiRecursos.cstmButon();
        passicon = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        mensajeError = new javax.swing.JLabel();
        bckground = new javax.swing.JLabel();
        guiBarraVentana1 = new guiRecursos.GuiBarraVentana();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logomed.png"))); // NOI18N
        pnlLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 430, 80));

        Contraseña.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        Contraseña.setText("Contraseña");
        pnlLogin.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 100, 20));
        pnlLogin.add(errorCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 20, 20));
        pnlLogin.add(errorUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 20, 20));

        campoCon.setBackground(new java.awt.Color(51, 51, 51));
        campoCon.setForeground(new java.awt.Color(255, 255, 255));
        campoCon.setActionCommand("<Not Set>");
        campoCon.setBorder(null);
        campoCon.setCaretColor(new java.awt.Color(255, 255, 255));
        campoCon.setOpaque(true);
        campoCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoConKeyPressed(evt);
            }
        });
        pnlLogin.add(campoCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 180, 20));

        campoUsu.setBackground(new java.awt.Color(51, 51, 51));
        campoUsu.setForeground(new java.awt.Color(255, 255, 255));
        campoUsu.setBorder(null);
        campoUsu.setCaretColor(new java.awt.Color(255, 255, 255));
        campoUsu.setOpaque(true);
        campoUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoUsuKeyPressed(evt);
            }
        });
        pnlLogin.add(campoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 180, 20));
        pnlLogin.add(Separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 180, 10));
        pnlLogin.add(Separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 180, 10));

        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorderColor(null);
        btnIngresar.setColor(new java.awt.Color(51, 51, 51));
        btnIngresar.setColorClick(new java.awt.Color(153, 153, 153));
        btnIngresar.setColorOver(new java.awt.Color(89, 89, 89));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        pnlLogin.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, -1));

        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderColor(null);
        btnRegistrar.setColor(new java.awt.Color(51, 51, 51));
        btnRegistrar.setColorClick(new java.awt.Color(153, 153, 153));
        btnRegistrar.setColorOver(new java.awt.Color(89, 89, 89));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlLogin.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 110, -1));

        passicon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passiconMouseClicked(evt);
            }
        });
        pnlLogin.add(passicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 20, 20));

        Usuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setText("Usuario");
        pnlLogin.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 20));

        mensajeError.setForeground(new java.awt.Color(255, 0, 0));
        pnlLogin.add(mensajeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 330, 20));

        bckground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/space.png"))); // NOI18N
        pnlLogin.add(bckground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guiBarraVentana1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(guiBarraVentana1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoConKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConKeyPressed
        enterLogin(evt);
    }//GEN-LAST:event_campoConKeyPressed

    private void campoUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuKeyPressed
        enterLogin(evt);
    }//GEN-LAST:event_campoUsuKeyPressed
    
    public void enterLogin(java.awt.event.KeyEvent evt){
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnIngresarActionPerformed(null);
        }
    }
    
    private void passiconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passiconMouseClicked
        mostrarContrasena = !mostrarContrasena;
        URL resource;
        if (mostrarContrasena) {
            campoCon.setEchoChar((char) 0); // Mostrar contraseña sin asteriscos
            resource = frmLogin.class.getResource("/images/con_mostrar.png");
        } else {
            campoCon.setEchoChar('*'); // Mostrar contraseña con asteriscos
            resource = frmLogin.class.getResource("/images/con_ocultar.png");
        }
        imageIconCambiar(resource, passicon, 20);
    }//GEN-LAST:event_passiconMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        frmElegirTipo eligtipo = new frmElegirTipo();
        eligtipo.setVisible(true);
        
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked

    }//GEN-LAST:event_btnIngresarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.dispose();frmElegirTipo eligtipo = new frmElegirTipo();
        eligtipo.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String user = campoUsu.getText();
        String pass = new String(campoCon.getPassword());
        Autenticacion aut = daoUser.autenticar(user, pass);
        
        //System.out.println("Contraseña valida?"+aut.isContraseñaValida());
        //System.out.println("Usuario valido?"+aut.isUsuarioValido());
        
        if (aut.isContraseñaValida()&& aut.isUsuarioValido()) {
            Usuario dato = daoUser.obtener(user);
            //System.out.println("tipo usuario: "+dato.getTipoUsua());
            entrarLogin(dato);
            mostrarError(0);
        } else if (!aut.isUsuarioValido()) {
            mostrarError(1);
        } else if (!aut.isContraseñaValida()) {
            mostrarError(2);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    public void mostrarError(int tipoError) {
        switch (tipoError) {
            case 1:
                cambiarIconoError(errorUs); // Error de usuario
                errorCon.setIcon(null);
                break;
            case 2:
                cambiarIconoError(errorCon); // Error de contraseña
                errorUs.setIcon(null);
                break;
            default:
                // Ningún error, limpiar iconos
                errorUs.setIcon(null);
                errorCon.setIcon(null);
                break;
        }
    }
    
    public void cambiarIconoError(JLabel label) {
        imageIconCambiar(frmLogin.class.getResource("/images/infoerror.png"), label, 20);
    }
    
    public void entrarLogin(Usuario user){
        String tipo = user.getTipoUsua();
        switch (tipo) {
            case "admin": new frmMenuAdmin(user).setVisible(true); break;
            case "trabajador": new frmMenuTrabajador(user).setVisible(true); break;
            case "empleador": new frmMenuCliente(user).setVisible(true); break;
            case "cliente": new frmMenuCliente(user).setVisible(true); break;
            default:
        }
        this.dispose();
    }
    
    public void imageIconCambiar(URL resource, JLabel iconoMod, int tamaño) {
        ImageIcon iconLogo = new ImageIcon(resource);
        Image image = iconLogo.getImage();
        Image imgRescalado = image.getScaledInstance(tamaño, tamaño, java.awt.Image.SCALE_SMOOTH);
        iconLogo = new ImageIcon(imgRescalado);
        iconoMod.setIcon(iconLogo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel bckground;
    private guiRecursos.cstmButon btnIngresar;
    private guiRecursos.cstmButon btnRegistrar;
    private javax.swing.JPasswordField campoCon;
    private javax.swing.JTextField campoUsu;
    private javax.swing.JLabel errorCon;
    private javax.swing.JLabel errorUs;
    private guiRecursos.GuiBarraVentana guiBarraVentana1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JLabel passicon;
    private javax.swing.JPanel pnlLogin;
    // End of variables declaration//GEN-END:variables
}
