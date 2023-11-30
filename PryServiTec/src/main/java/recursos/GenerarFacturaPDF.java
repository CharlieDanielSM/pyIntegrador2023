
package recursos;

/* 🚀 Developed by NelsonJGP */
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import guiRecursos.CustomFont;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerarFacturaPDF {
    
    public static Font loadAnotherFont() {
        return loadFont("/fonts/Lato-Regular.ttf", 12f);
    }

    private static Font loadFont(String fontPath, float size) {
        try {
            // Cargar la fuente personalizada desde el archivo TTF
            InputStream fontStream = CustomFont.class.getResourceAsStream(fontPath);
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            return new Font(baseFont, size);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void generarPDF(DefaultTableModel modeloTabla) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar factura como PDF");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = chooser.getSelectedFile().toString();
            if (!nombreArchivo.toLowerCase().endsWith(".pdf")) {
                nombreArchivo += ".pdf";
            }

            Document document = new Document(PageSize.A4);
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));

                // Agregar encabezado
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);

                document.open();

                // Agregar marca de agua (watermark)
                PdfContentByte canvas = writer.getDirectContentUnder();
                Font watermarkFont = loadAnotherFont();
                Phrase watermark = new Phrase("Confidencial", watermarkFont);
                ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 297, 421, 45);

                // Agregar encabezado de factura
                Font fontEncabezado = loadAnotherFont();
                Paragraph encabezado = new Paragraph("FACTURA", fontEncabezado);
                encabezado.setAlignment(Element.ALIGN_CENTER);
                document.add(encabezado);

                // Agregar información de la empresa
                Font fontEmpresa = loadAnotherFont();
                Paragraph infoEmpresa = new Paragraph("Nombre de la Empresa\nDirección de la Empresa\nTeléfono: 123-456-789", fontEmpresa);
                infoEmpresa.setAlignment(Element.ALIGN_LEFT);
                document.add(infoEmpresa);

                // Línea divisoria
                document.add(new Chunk(new LineSeparator()));

                // Agregar información del cliente
                Font fontCliente = loadAnotherFont();
                Paragraph infoCliente = new Paragraph("Cliente: Nombre del Cliente\nDirección del Cliente\nFecha: 01/01/2023", fontCliente);
                infoCliente.setAlignment(Element.ALIGN_LEFT);
                infoCliente.setSpacingBefore(10);
                document.add(infoCliente);

                // Línea divisoria
                document.add(new Chunk(new LineSeparator()));

                // Agregar contenido de la factura
                agregarContenidoFactura(document, modeloTabla);

                JOptionPane.showMessageDialog(null, "Factura generada correctamente.");
                document.close();

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al generar la factura.");
            }
        }
    }

    private static void agregarContenidoFactura(Document document, DefaultTableModel modeloTabla) throws DocumentException {
        PdfPTable tabla = new PdfPTable(modeloTabla.getColumnCount());
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);

        // Estilo de celda para los encabezados
        PdfPCell encabezadoCell = new PdfPCell();
        encabezadoCell.setBackgroundColor(new BaseColor(173, 216, 230));
        encabezadoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        encabezadoCell.setPadding(8);

        // Agregar encabezados de columna
        for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
            encabezadoCell.setPhrase(new Phrase(modeloTabla.getColumnName(columna)));
            tabla.addCell(encabezadoCell);
        }

        // Estilo de celda para el contenido
        PdfPCell contenidoCell = new PdfPCell();
        contenidoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        contenidoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        contenidoCell.setPadding(6);

        // Agregar contenido de la tabla
        for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
            for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
                contenidoCell.setPhrase(new Phrase(modeloTabla.getValueAt(fila, columna).toString()));
                tabla.addCell(contenidoCell);
            }
        }

        // Agregar la tabla al documento
        document.add(tabla);
    }

    public static class HeaderFooterPageEvent extends PdfPageEventHelper {
        private Font headerFont = loadAnotherFont();
        private Font footerFont = loadAnotherFont();

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            // Agregar encabezado en cada página
            Paragraph header = new Paragraph("FACTURA", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            try {
                document.add(header);
            } catch (DocumentException ex) {
                Logger.getLogger(GenerarFacturaPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            // Agregar número de página en el pie de página
            int pageNum = writer.getPageNumber();
            Paragraph footer = new Paragraph("Página " + pageNum, footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            try {
                document.add(footer);
            } catch (DocumentException ex) {
                Logger.getLogger(GenerarFacturaPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Descripción");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Precio Unitario");
            modeloTabla.addColumn("Total");

            Object[] fila1 = {"Producto A", 2, 10.0, 20.0};
            Object[] fila2 = {"Producto B", 1, 15.0, 15.0};

            modeloTabla.addRow(fila1);
            modeloTabla.addRow(fila2);

            generarPDF(modeloTabla);
        });
    }
}