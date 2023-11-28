package vista;

import dao.daoEspecialidad;
import dao.daoTrabajador;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Especialidad;
import modelo.Trabajador;
import recursos.ExportarExcel;

/**
 *
 * @author Nelson
 */
public class clienteTablaEsp extends javax.swing.JFrame {
    daoEspecialidad objEsp = new daoEspecialidad();
    List<Especialidad> lista;
    /**
     * Creates new form clienteTablaTrab
     */
    public clienteTablaEsp(List<Especialidad> lista) {
        initComponents();
        this.lista = lista;
        actualizarTablaEspecialidad(lista);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cstmButon1 = new guiRecursos.cstmButon();
        cstmButon2 = new guiRecursos.cstmButon();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TablaOfertas");

        jPanel1.setBackground(new java.awt.Color(214, 219, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio Base", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 700, 230));

        cstmButon1.setText("Cerrar");
        cstmButon1.setColorClick(new java.awt.Color(205, 97, 85));
        cstmButon1.setColorOver(new java.awt.Color(192, 57, 43));
        cstmButon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstmButon1ActionPerformed(evt);
            }
        });
        jPanel1.add(cstmButon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, -1));

        cstmButon2.setText("Exportar en excel");
        cstmButon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstmButon2ActionPerformed(evt);
            }
        });
        jPanel1.add(cstmButon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 140, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("TablaOfertas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cstmButon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstmButon1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cstmButon1ActionPerformed

    private void cstmButon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstmButon2ActionPerformed
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(tabla);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_cstmButon2ActionPerformed

    public void actualizarTablaEspecialidad(List<Especialidad> listaEsp) {
        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dt.setRowCount(0);

        for (Especialidad esp : listaEsp) {
            Object v[] = {
                esp.getCodiEspe(),
                esp.getNombEspe(),
                esp.getDescEspe(),
                esp.getPrecBaseEspe()
            };
            dt.addRow(v);
        }
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
            java.util.logging.Logger.getLogger(clienteTablaEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clienteTablaEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clienteTablaEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clienteTablaEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clienteTablaEsp(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private guiRecursos.cstmButon cstmButon1;
    private guiRecursos.cstmButon cstmButon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
