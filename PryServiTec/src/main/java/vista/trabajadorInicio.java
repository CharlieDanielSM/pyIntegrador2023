package vista;

/**
 *
 * @author Nelson
 */
public class trabajadorInicio extends javax.swing.JPanel {

    /**
     * Creates new form trabajadorInicio
     */
    public trabajadorInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        guiJScrollPane1 = new guiRecursos.GuiJScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Inicio");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Bienvenidos a Nuestra Sección de Trabajadores\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFocusable(false);
        guiJScrollPane1.setViewportView(jTextArea1);

        Panel.add(guiJScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 890, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private guiRecursos.GuiJScrollPane guiJScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
