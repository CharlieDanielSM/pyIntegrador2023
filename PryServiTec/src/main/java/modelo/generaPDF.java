package modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import guiRecursos.CustomFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;

public class generaPDF {

    public static Font fuenteNormal() {
        return loadFont("/fonts/Lato-Regular.ttf", 12f);
    }
    public static Font fuenteNegrita() {
        return loadFont("/fonts/Lato-Bold.ttf", 12f);
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

    public static void generarPDF(DefaultTableModel modeloTabla, EmpleadorDto emp) {
       JFileChooser chooser = new JFileChooser();
       chooser.setDialogTitle("Guardar archivo PDF");
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
                Font fuenteNueva = fuenteNormal();

                PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
                document.open();

                // Crear un contenedor para la imagen y el texto
                PdfPTable contenedor = new PdfPTable(2);
                contenedor.setWidthPercentage(100);

                // Agregar la imagen a la izquierda
                Image imagen = Image.getInstance("src/main/resources/images/logoDoc.png");
                imagen.scaleToFit(220, 100);
                PdfPCell imagenCell = new PdfPCell(imagen);
                imagenCell.setBorder(Rectangle.NO_BORDER);
                contenedor.addCell(imagenCell);

                // Agregar el texto de información de la empresa a la derecha
                PdfPCell infoCell = new PdfPCell();
                infoCell.setBorder(Rectangle.NO_BORDER);
                
                Font fontInfo = fuenteNueva;
                Paragraph infoEmpresa = new Paragraph();
                Chunk chunkServitec = new Chunk("Servitec", loadFont("/fonts/Lato-Bold.ttf", 18f));
                infoEmpresa.add(chunkServitec);
                infoEmpresa.add("\nDirección: Calle 123, Ciudad\nTeléfono: 123-456-7890");
                infoEmpresa.setAlignment(Element.ALIGN_LEFT);
                infoEmpresa.setSpacingAfter(20);  // Espaciado después del párrafo
                infoCell.addElement(infoEmpresa);

                // Agregar infoCell al contenedor
                contenedor.addCell(infoCell);

                // Agregar el contenedor al documento
                document.add(contenedor);

                // Agregar código, nombre, email antes de la tabla
                Font fontDatos = new Font(Font.FontFamily.HELVETICA, 12);
                Chunk chunckInfo = new Chunk("Factura para:", loadFont("/fonts/Lato-Bold.ttf", 14f));
                Paragraph datos = new Paragraph();
                datos.add(chunckInfo);
                datos.add("\nCódigo: "+emp.getCodiEmpl()+""
                        + "\nNombre: "+emp.getNombEmpl()
                        + "\nDni/Ruc: "+emp.getDniRucEmpl()
                        + "\nEmail: "+emp.getEmailEmpl()
                        + "\nTelefono: "+emp.getTeleEmp());
                datos.setAlignment(Element.ALIGN_LEFT);
                datos.setSpacingAfter(20);  // Espaciado después del párrafo
                document.add(datos);

                 // Agregar contenido de la tabla
                agregarContenidoTabla(document, modeloTabla);

                JOptionPane.showMessageDialog(null, "COMPROBANTE GENERADO");
                document.close();

           } catch (DocumentException | IOException e) {
               e.printStackTrace();
               JOptionPane.showMessageDialog(null, "ERROR AL GENERAR PDF");
           }
       }
   }

    private static void agregarContenidoTabla(Document document, DefaultTableModel modeloTabla) throws DocumentException {
        PdfPTable tabla = new PdfPTable(modeloTabla.getColumnCount());
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);  // Espaciado antes de la tabla
        tabla.setSpacingAfter(10f);   // Espaciado después de la tabla
        
        // Estilo de celda para los encabezados
        PdfPCell encabezadoCell = new PdfPCell();
        encabezadoCell.setBorderColor(BaseColor.GRAY);
        encabezadoCell.setBackgroundColor(new BaseColor(214, 219, 223));
        encabezadoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        encabezadoCell.setPadding(5);

        // Agregar encabezados de columna
        for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
            encabezadoCell.setPhrase(new Phrase(modeloTabla.getColumnName(columna)));
            tabla.addCell(encabezadoCell);
        }

        // Estilo de celda para el contenido
        PdfPCell contenidoCell = new PdfPCell();
        contenidoCell.setBorderColor(BaseColor.GRAY);
        contenidoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        contenidoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        contenidoCell.setPadding(3);

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
}