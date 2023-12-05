
package vista;
import dao.*;
import modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cobranza extends javax.swing.JInternalFrame {

    private String  codigo="";
    
    public void actualizarTabla() {
        EmpleadorDao Empleadao = new EmpleadorDao();
        List<EmpleadorDto> listaEmple = Empleadao.listarEmpleadores();
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla.setRowCount(0);

        for (EmpleadorDto Emple : listaEmple) {
                Object[] fila = {Emple.getCodiEmpl(), Emple.getNombEmpl(), Emple.getEmailEmpl()};
                modeloTabla.addRow(fila);

        }
    }
    public void listaContratoCliente( String Emp) {
        ContratoDao contratoDao = new ContratoDao();
        EmpleadorDao empleadorDao = new EmpleadorDao();
        daoNegociacion negociadao= new daoNegociacion();
        List<ContratoDto> listaContra = contratoDao.listarContXEmpleador(Emp);

        DefaultTableModel modeloTabla = (DefaultTableModel) jTable2.getModel();
        modeloTabla.setRowCount(0);

        for (ContratoDto contra : listaContra) {
            EmpleadorDto empleador = empleadorDao.obtenerEmpleadorPorID(contra.getCodiEmpl());
            Negociacion negociacion= negociadao.obtenerNegociacion(contra.getCodiNego());
            
            if (empleador != null) {
                Object[] fila = {contra.getCodiCont(), contra.getFechCont(), empleador.getNombEmpl(),negociacion.getMontNego()};
                modeloTabla.addRow(fila);
            }
        }
    }
    
    private boolean existeSeleccion() {
        int i = jTable1.getSelectedRow();
        if (i == -1) {
            return false;
        }
        return true;
    }
    
    
    public Cobranza() {
        initComponents();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnFacturar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Cibranza Clientes");

        btnBuscar.setText("Buscar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Email", "Contratos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Clientes", jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Contrato", "Fecha", "Empresa", "Monto"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane2.addTab("Detalle", jScrollPane3);

        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFacturar)))
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnFacturar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    final int[] clickCount = {0};
    if (evt.getClickCount() >= 2) {
  
        int pos=jTable1.getSelectedRow();
        codigo = jTable1.getValueAt(pos, 0).toString();
        listaContratoCliente(codigo);
       
       clickCount[0] = 0; 
    } else {
        clickCount[0]++;
    }
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed

        generaPDF pdf =new generaPDF();
        EmpleadorDao emp=new EmpleadorDao();
        comunicacionPHP php=new comunicacionPHP();
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable2.getModel();
        int pos=jTable2.getSelectedRow();
        if(pos !=1)
        {
           emp.obtenerEmpleadorPorID(codigo); 
           EmpleadorDto Empleador = emp.obtenerEmpleadorPorID(codigo);
          
           pdf.generarPDF(Empleador.getNombEmpl()+".pdf",modeloTabla );
           
           php.llamarScriptPHP(Empleador.getEmailEmpl(),Empleador.getNombEmpl()+".pdf");
        }
        else
        {
           JOptionPane.showMessageDialog(null,"No hay registros por facturar");
        }
        
        
        
    }//GEN-LAST:event_btnFacturarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
