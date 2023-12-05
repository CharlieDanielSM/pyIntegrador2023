package vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Usuario;

/**
 *
 * @author Nelson
 */
public class frmMenuCliente extends javax.swing.JFrame {
    Usuario user;
    /**
     * Creates new form frmMenu
     */
    public frmMenuCliente(Usuario user) {
        initComponents();
        MostrarPanel(new clienteInicio());
        if (user==null) this.user = new Usuario("cliente", "cliente", "cliente"); else this.user = user;
        System.out.println("user: "+this.user.getCodiUsua()+",pass:"+this.user.getPassUsua()+",tipo:"+this.user.getTipoUsua());
        ImageUsuario();
    }
    
    public void ImageUsuario(){
        imageIconCambiar(getClass().getClassLoader().getResource("images/user/defaultUser.png"), userImage, 70);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraVentana1 = new guiRecursos.GuiBarraVentana();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        userImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cstmButon1 = new guiRecursos.cstmButon();
        content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnOfertas = new guiRecursos.cstmButon();
        btnInicio = new guiRecursos.cstmButon();
        btnVolver = new guiRecursos.cstmButon();
        btnServicios1 = new guiRecursos.cstmButon();
        btnEspecialidades1 = new guiRecursos.cstmButon();
        btnOfertas1 = new guiRecursos.cstmButon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        barraVentana1.setTitulo("Menu Cliente");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(43, 45, 49));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(userImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Usuario :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Default");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 100, 20));

        cstmButon1.setForeground(new java.awt.Color(255, 255, 255));
        cstmButon1.setText("Configurar");
        cstmButon1.setBorderColor(null);
        cstmButon1.setBorderPainted(false);
        cstmButon1.setColor(new java.awt.Color(0, 102, 102));
        cstmButon1.setColorClick(new java.awt.Color(0, 204, 204));
        cstmButon1.setColorOver(new java.awt.Color(0, 153, 153));
        jPanel3.add(cstmButon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 100, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 120));

        content.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 950, 610));

        jPanel2.setBackground(new java.awt.Color(43, 45, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOfertas.setForeground(new java.awt.Color(255, 255, 255));
        btnOfertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconOfertas.png"))); // NOI18N
        btnOfertas.setText("Ofertas");
        btnOfertas.setBorderColor(null);
        btnOfertas.setColor(new java.awt.Color(65, 67, 73));
        btnOfertas.setColorClick(new java.awt.Color(114, 119, 130));
        btnOfertas.setColorOver(new java.awt.Color(87, 91, 99));
        btnOfertas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOfertas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOfertas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOfertas.setIconTextGap(15);
        btnOfertas.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertasActionPerformed(evt);
            }
        });
        jPanel2.add(btnOfertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconInicio.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorderColor(null);
        btnInicio.setColor(new java.awt.Color(65, 67, 73));
        btnInicio.setColorClick(new java.awt.Color(114, 119, 130));
        btnInicio.setColorOver(new java.awt.Color(87, 91, 99));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInicio.setIconTextGap(15);
        btnInicio.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconVolver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorderColor(null);
        btnVolver.setColor(new java.awt.Color(43, 45, 49));
        btnVolver.setColorClick(new java.awt.Color(205, 97, 85));
        btnVolver.setColorOver(new java.awt.Color(192, 57, 43));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver.setIconTextGap(15);
        btnVolver.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 210, 60));

        btnServicios1.setForeground(new java.awt.Color(255, 255, 255));
        btnServicios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconListar.png"))); // NOI18N
        btnServicios1.setText("Negociaciones");
        btnServicios1.setBorderColor(null);
        btnServicios1.setColor(new java.awt.Color(65, 67, 73));
        btnServicios1.setColorClick(new java.awt.Color(114, 119, 130));
        btnServicios1.setColorOver(new java.awt.Color(87, 91, 99));
        btnServicios1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnServicios1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnServicios1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnServicios1.setIconTextGap(15);
        btnServicios1.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnServicios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicios1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnServicios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, 60));

        btnEspecialidades1.setForeground(new java.awt.Color(255, 255, 255));
        btnEspecialidades1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconServicios.png"))); // NOI18N
        btnEspecialidades1.setText("Especialidades");
        btnEspecialidades1.setBorderColor(null);
        btnEspecialidades1.setBorderPainted(false);
        btnEspecialidades1.setColor(new java.awt.Color(65, 67, 73));
        btnEspecialidades1.setColorClick(new java.awt.Color(114, 119, 130));
        btnEspecialidades1.setColorOver(new java.awt.Color(87, 91, 99));
        btnEspecialidades1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEspecialidades1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEspecialidades1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEspecialidades1.setIconTextGap(15);
        btnEspecialidades1.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnEspecialidades1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialidades1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnEspecialidades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 60));

        btnOfertas1.setForeground(new java.awt.Color(255, 255, 255));
        btnOfertas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/iconHistory.png"))); // NOI18N
        btnOfertas1.setText("Historial");
        btnOfertas1.setBorderColor(null);
        btnOfertas1.setColor(new java.awt.Color(65, 67, 73));
        btnOfertas1.setColorClick(new java.awt.Color(114, 119, 130));
        btnOfertas1.setColorOver(new java.awt.Color(87, 91, 99));
        btnOfertas1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOfertas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOfertas1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOfertas1.setIconTextGap(15);
        btnOfertas1.setMargin(new java.awt.Insets(0, 10, 0, 0));
        btnOfertas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertas1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnOfertas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 210, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraVentana1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraVentana1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertasActionPerformed
        Usuario user = new Usuario();
        user.setCodiUsua("cliente");
        user.setPassUsua("cliente");
        user.setTipoUsua("cliente");
        MostrarPanel(new clienteOfertas(user));
    }//GEN-LAST:event_btnOfertasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        MostrarPanel(new clienteInicio());
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnServicios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicios1ActionPerformed
        
    }//GEN-LAST:event_btnServicios1ActionPerformed

    private void btnEspecialidades1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialidades1ActionPerformed
        MostrarPanel(new clienteEspecialidad());
    }//GEN-LAST:event_btnEspecialidades1ActionPerformed

    private void btnOfertas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertas1ActionPerformed
        MostrarPanel(new clienteHistorial(user));
    }//GEN-LAST:event_btnOfertas1ActionPerformed

    public void MostrarPanel(JPanel panel){
        panel.setSize(content.getWidth(),content.getHeight());
        panel.setLocation(0,0);
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
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
            java.util.logging.Logger.getLogger(frmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuCliente(null).setVisible(true);
            }
        });
    }

    public void imageIconCambiar(URL resource, JLabel iconoMod, int tamaño) {
        if (resource != null) {
            ImageIcon iconLogo = new ImageIcon(resource);
            Image image = iconLogo.getImage();
            Image imgRescalado = image.getScaledInstance(tamaño, tamaño, java.awt.Image.SCALE_SMOOTH);
            iconLogo = new ImageIcon(imgRescalado);
            iconoMod.setIcon(iconLogo);
        } else {
            System.out.println("No se encontro");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private guiRecursos.GuiBarraVentana barraVentana1;
    private guiRecursos.cstmButon btnEspecialidades1;
    private guiRecursos.cstmButon btnInicio;
    private guiRecursos.cstmButon btnOfertas;
    private guiRecursos.cstmButon btnOfertas1;
    private guiRecursos.cstmButon btnServicios1;
    private guiRecursos.cstmButon btnVolver;
    private javax.swing.JPanel content;
    private guiRecursos.cstmButon cstmButon1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel userImage;
    // End of variables declaration//GEN-END:variables
}
