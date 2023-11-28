package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
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
public class frmMenuAdmin extends javax.swing.JFrame {
    Usuario user;
    /**
     * Creates new form frmMenu
     */
    public frmMenuAdmin(Usuario user) {
        FlatLightLaf.setup();
        initComponents();
        this.user = user;
        imageIconCambiar(getClass().getClassLoader().getResource("images/icon/volver.png"), volverIcon, 40);
        
        ImageUsuario();
        crearSecciones();
    }
    
    
    public void crearSecciones(){
        //Seccion Categorias
        mnSeccion1.iconImg("users.png");
        mnSeccion1.textoSeccion("Gestionar Usuarios");
        
        //Seccion Categorias
        mnSeccion2.iconImg("services.png");
        mnSeccion2.textoSeccion("Gestionar Servicios");
        
        //Seccion Categorias
        mnSeccion3.iconImg("solicitud.png");
        mnSeccion3.textoSeccion("Gestionar Solicitudes");
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
        content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mnSeccion1 = new guiRecursos.GuimenuBoton();
        mnSeccion2 = new guiRecursos.GuimenuBoton();
        mnSeccion3 = new guiRecursos.GuimenuBoton();
        volverPanel = new javax.swing.JPanel();
        volverIcon = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        barraVentana1.setTitulo("Menu Admin");

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

        mnSeccion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSeccion1MouseClicked(evt);
            }
        });
        jPanel2.add(mnSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mnSeccion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSeccion2MouseClicked(evt);
            }
        });
        jPanel2.add(mnSeccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));
        jPanel2.add(mnSeccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        volverPanel.setBackground(new java.awt.Color(43, 45, 49));
        volverPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverPanelformMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverPanelformMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverPanelMousePressed(evt);
            }
        });

        volverIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtSeccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSeccion.setForeground(new java.awt.Color(255, 255, 255));
        txtSeccion.setText("Volver");

        javax.swing.GroupLayout volverPanelLayout = new javax.swing.GroupLayout(volverPanel);
        volverPanel.setLayout(volverPanelLayout);
        volverPanelLayout.setHorizontalGroup(
            volverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volverPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(volverIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        volverPanelLayout.setVerticalGroup(
            volverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volverPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(volverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volverIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(volverPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraVentana1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void volverPanelformMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverPanelformMouseEntered
        volverPanel.setBackground(new Color(203, 64, 64));
    }//GEN-LAST:event_volverPanelformMouseEntered

    private void volverPanelformMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverPanelformMouseExited
        volverPanel.setBackground(new Color(43,45,49));
    }//GEN-LAST:event_volverPanelformMouseExited

    private void volverPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverPanelMousePressed
        frmLogin login = new frmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverPanelMousePressed

    private void mnSeccion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSeccion2MouseClicked
        MostrarPanel(new adminServicios3());
    }//GEN-LAST:event_mnSeccion2MouseClicked

    private void mnSeccion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSeccion1MouseClicked
        // TODO add your handling code here:
        MostrarPanel(new adminUsuarios());
    }//GEN-LAST:event_mnSeccion1MouseClicked

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
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuAdmin(null).setVisible(true);
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
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private guiRecursos.GuimenuBoton mnSeccion1;
    private guiRecursos.GuimenuBoton mnSeccion2;
    private guiRecursos.GuimenuBoton mnSeccion3;
    private javax.swing.JLabel txtSeccion;
    private javax.swing.JLabel userImage;
    private javax.swing.JLabel volverIcon;
    private javax.swing.JPanel volverPanel;
    // End of variables declaration//GEN-END:variables
}
