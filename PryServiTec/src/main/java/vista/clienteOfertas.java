package vista;

import com.formdev.flatlaf.FlatLightLaf;
import dao.ContratoDao;
import dao.EmpleadorDao;
import dao.daoEspecialidad;
import dao.daoTrabajador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelo.ContratoDto;
import modelo.Especialidad;
import modelo.Trabajador;
import modelo.Usuario;

/**
 *
 * @author Nelson
 */
public class clienteOfertas extends javax.swing.JPanel{
    
    daoTrabajador daoTrab = new daoTrabajador();
    daoEspecialidad daoEsp = new daoEspecialidad();
    EmpleadorDao daoEmp = new EmpleadorDao();
    ContratoDao daoCont = new ContratoDao();
    Usuario us;
    List<Trabajador> trabajadores;
    /**
     * Creates new form clienteServicios
     */
    public clienteOfertas(Usuario user) {
        FlatLightLaf.setup();
        initComponents();
        this.us = user;
        mostrarTrabajadoresEnScrollPanel("General");
        comboServiciosListar();
    }

    public void comboServiciosListar(){
        List<Especialidad> listaEsp = daoEsp.listar();
        for (Especialidad esp : listaEsp) {
            cmbServicios.addItem(esp.getNombEspe());
        }
    }
    
    public void mostrarTrabajadoresEnScrollPanel(String Opcion) {
        // Limpiar el panel antes de generar nuevos componentes
        contentServ.removeAll();
        contentServ.revalidate();
        contentServ.repaint();
        
        if (Opcion.equals("General")) {
            trabajadores = daoTrab.listar();
        } else {
            trabajadores = daoTrab.obtenerTrabajadoresPorEspecialidad(daoEsp.obtenerIdEspecialidadPorNombre(Opcion));
        }
        if (trabajadores.isEmpty()) {
            mostrarMensajeVacio();
        } else {
            exMostrar();
        }
        
    }

    private void mostrarMensajeVacio() {
        contentServ.removeAll(); // Elimina todos los componentes existentes en el JPanel

        JLabel mensajeLabel = new JLabel("No hay trabajadores para mostrar.");
        mensajeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Tamaño 20 y en negrita

        // Configura el layout del JPanel para centrar el mensaje
        contentServ.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 0, 0); // Ajusta el espacio en la parte superior

        contentServ.add(mensajeLabel, gbc);
        contentServ.revalidate(); // Vuelve a validar el diseño del JPanel
        contentServ.repaint();    // Repinta el JPanel para mostrar los cambios
    }
    
    public void exMostrar(){
        int velocidadScroll = 16;
        int numColumnas = 3;

        // Agrega un espaciado entre paneles en el GridLayout
        int hgap = 20; // Espaciado horizontal
        int vgap = 20; // Espaciado vertical
        contentServ.setLayout(new GridLayout(0, numColumnas, hgap, vgap));
        
        for (Trabajador t : trabajadores) {
            DropShadowPanel trabPanel = new DropShadowPanel(5); // Cambia el valor según el tamaño de sombra que desees
            trabPanel.setLayout(new BorderLayout());
            trabPanel.setPreferredSize(new Dimension(200, 320));

            DropShadowPanel cuadroPanel = new DropShadowPanel(5); // Cambia el valor según el tamaño de sombra que desees
            cuadroPanel.setLayout(new BoxLayout(cuadroPanel, BoxLayout.Y_AXIS));
            cuadroPanel.setPreferredSize(new Dimension(200, 320));

            cuadroPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));

            JPanel contenidoPanel = new JPanel();
            contenidoPanel.setLayout(new BoxLayout(contenidoPanel, BoxLayout.Y_AXIS));
            contenidoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            // Mostrar el título del trabajador (nombre)
            JLabel nameLabel = new JLabel(t.getNombTrab());
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            contenidoPanel.add(nameLabel);

            contenidoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            // Mostrar la imagen del trabajador
            String imagePath = "/images/user/trabajadores/" + t.getCodiUsua()+ ".png";
            URL imageURL = getClass().getResource(imagePath);
            ImageIcon icon;

            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
            } else {
                // Si la imagen no existe, utiliza la imagen predeterminada.
                icon = new ImageIcon(getClass().getResource("/images/user/trabajadores/defaultTrabajador.png"));
            }

            Image image = icon.getImage().getScaledInstance(150, -1, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contenidoPanel.add(imageLabel);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mostrar el ID del servicio y la fecha de creación de la cuenta del trabajador

        infoPanel.add(new JLabel("Especialidad: " + daoEsp.obtener(t.getCodiEspe()).getNombEspe()));
        infoPanel.add(new JLabel("E-mail: " + t.getEmailTrab()));

        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Mostrar la calificación y el botón "Contactar" y "Más Detalles"
        double promedioCalificaciones = daoTrab.obtenerPromedioCalificaciones(t.getCodiTrab());
        infoPanel.add(new JLabel("Calificación Promedio: " + promedioCalificaciones));

        contenidoPanel.add(infoPanel);

        contenidoPanel.add(Box.createRigidArea(new Dimension(0, 10)));


            JButton contactarButton = new JButton("Contactar");
            JButton detallesButton = new JButton("Más Detalles");

            // Agregar ActionListeners para manejar los clics en los botones
            contactarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContratoDto c = new ContratoDto();
                    String descripcion = "Solicito servicio de "+daoEsp.obtener(t.getCodiEspe()).getNombEspe()+", para "+t.getNombTrab();
                    c.setDescCont(descripcion);
                    c.setCodiCont(daoCont.obtenerNuevoCodigoContrato());
                    c.setCodiEmpl(daoEmp.obtenerEmpleadorPorIDUsuario(us.getCodiUsua()).getCodiEmpl());
                    c.setCodiNego(null);
                    c.setCodiTrab(t.getCodiTrab());
                    c.setEstCont("Pendiente");
                    c.setFechCont(new Date(System.currentTimeMillis()));
                    new ventanaContactar(c).setVisible(true);
                }
            });

            detallesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para ver más detalles del trabajador
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(contactarButton);
            buttonPanel.add(detallesButton);

            contenidoPanel.add(buttonPanel);

            JPanel descPanel = new JPanel();
            descPanel.setLayout(new BorderLayout());

            contenidoPanel.add(descPanel);

            cuadroPanel.add(Box.createVerticalGlue());
            cuadroPanel.add(contenidoPanel);

            trabPanel.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
            trabPanel.add(cuadroPanel, BorderLayout.CENTER);

            contentServ.add(trabPanel);
        }

        contentServ.revalidate();
        Scroll.getVerticalScrollBar().setUnitIncrement(velocidadScroll);
    }
    
    public class DropShadowPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        public int pixels;

        public DropShadowPanel(int pix) {
            this.pixels = pix;
            Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
            this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), border));
            this.setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            int shade = 0;
            int topOpacity = 80;
            for (int i = 0; i < pixels; i++) {
                g.setColor(new Color(shade, shade, shade, ((topOpacity / pixels) * i)));
                g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
            }
        }
    }
    public void MostrarPanel(JPanel panel){
        panel.setSize(this.getWidth(),this.getHeight());
        panel.setLocation(0,0);
        this.removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
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
        Scroll = new guiRecursos.GuiJScrollPane();
        contentServ = new javax.swing.JPanel();
        cmbServicios = new javax.swing.JComboBox<>();
        cstmButon1 = new guiRecursos.cstmButon();

        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Ofertas");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 40));

        Scroll.setBorder(null);

        javax.swing.GroupLayout contentServLayout = new javax.swing.GroupLayout(contentServ);
        contentServ.setLayout(contentServLayout);
        contentServLayout.setHorizontalGroup(
            contentServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        contentServLayout.setVerticalGroup(
            contentServLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        Scroll.setViewportView(contentServ);

        Panel.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 890, 510));

        cmbServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General" }));
        cmbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServiciosActionPerformed(evt);
            }
        });
        Panel.add(cmbServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 200, -1));

        cstmButon1.setForeground(new java.awt.Color(0, 0, 0));
        cstmButon1.setText("Ver Tabla");
        cstmButon1.setColor(new java.awt.Color(204, 204, 204));
        cstmButon1.setColorClick(new java.awt.Color(215, 219, 221));
        cstmButon1.setColorOver(new java.awt.Color(189, 195, 199));
        cstmButon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstmButon1ActionPerformed(evt);
            }
        });
        Panel.add(cstmButon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 120, -1));

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

    private void cmbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServiciosActionPerformed
        mostrarTrabajadoresEnScrollPanel(cmbServicios.getSelectedItem().toString());
    }//GEN-LAST:event_cmbServiciosActionPerformed

    private void cstmButon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstmButon1ActionPerformed
        new clienteTablaTrab(trabajadores).setVisible(true);
        /*ExportarExcel obj;
        try {
            obj = new ExportarExcel();
            obj.exportarExcel(sa);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }*/
        
    }//GEN-LAST:event_cstmButon1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private guiRecursos.GuiJScrollPane Scroll;
    private javax.swing.JComboBox<String> cmbServicios;
    private javax.swing.JPanel contentServ;
    private guiRecursos.cstmButon cstmButon1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
