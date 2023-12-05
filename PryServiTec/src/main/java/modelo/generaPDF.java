
package modelo;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class generaPDF 
{
    
    public static void generarPDF(String nombreArchivo, DefaultTableModel modeloTabla) {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Agregar encabezado
            Paragraph encabezado = new Paragraph("RECIBO");
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);
            document.add(Chunk.NEWLINE);
            // Agregar la imagen
            Image imagen = Image.getInstance("src/main/resources/images/logoComp.png");
            imagen.scaleToFit(200, 200);
            
            document.add(imagen);
            
            document.add(Chunk.NEWLINE);
            // Agregar contenido de la tabla
            agregarContenidoTabla(document, modeloTabla);
            JOptionPane.showMessageDialog(null,"COMPROBANTE GENERADO");
            document.close();
            
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR AL GENERAR PDF");           
        }
    }
    private static void agregarContenidoTabla(Document document, DefaultTableModel modeloTabla) throws DocumentException {
       int numColumnas = modeloTabla.getColumnCount() + 3;  // Añadir 3 columnas adicionales

       // Crear tabla sin bordes
       PdfPTable tabla = new PdfPTable(numColumnas);
       tabla.setWidthPercentage(100);
       tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

       // Establecer fuente para encabezados en negrita y tamaño grande
       com.itextpdf.text.Font fontEncabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
       PdfPCell Items = encabezadoCelda("Items", fontEncabezado);
       // Agregar encabezados de columna, incluyendo las nuevas columnas
       for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
           PdfPCell encabezadoCell = new PdfPCell(new Phrase(modeloTabla.getColumnName(columna), fontEncabezado));
           encabezadoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
           encabezadoCell.setBorder(Rectangle.BOTTOM);  // Agregar línea de separación en la parte inferior
           tabla.addCell(encabezadoCell);
       }

       // Agregar encabezados para las nuevas columnas
       PdfPCell comisionHeader = encabezadoCelda(" %Comision", fontEncabezado);
       PdfPCell igvHeader = encabezadoCelda(" IGV", fontEncabezado);
       PdfPCell subtotalHeader = encabezadoCelda(" Subtotal", fontEncabezado);

       // Agregar línea de separación en la parte inferior de las nuevas columnas
       Items.setBorder(Rectangle.BOTTOM);
       comisionHeader.setBorder(Rectangle.BOTTOM);
       igvHeader.setBorder(Rectangle.BOTTOM);
       subtotalHeader.setBorder(Rectangle.BOTTOM);

       tabla.addCell(Items);
       tabla.addCell(comisionHeader);
       tabla.addCell(igvHeader);
       tabla.addCell(subtotalHeader);

       // Establecer fuente para el contenido de la tabla
       com.itextpdf.text.Font fontContenido = FontFactory.getFont(FontFactory.HELVETICA, 10);

       // Agregar contenido de la tabla
       for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
           // Añadir número de ítem
           tabla.addCell(celda(Integer.toString(fila + 1), fontContenido));

           for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
               PdfPCell contenidoCell = celda(modeloTabla.getValueAt(fila, columna).toString(), fontContenido);
               contenidoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
               tabla.addCell(contenidoCell);
           }

           // Añadir valores para las nuevas columnas (puedes reemplazar estos valores con los cálculos reales)
           PdfPCell comisionCell = celda("10%", fontContenido);
           PdfPCell igvCell = celda("5%", fontContenido);
           PdfPCell subtotalCell = celda("200", fontContenido);

           tabla.addCell(comisionCell);
           tabla.addCell(igvCell);
           tabla.addCell(subtotalCell);
       }

       // Agregar la tabla al documento
       document.add(tabla);
   }

   // Método para crear celda con alineación específica
   private static PdfPCell celda(String texto, com.itextpdf.text.Font font) {
       PdfPCell cell = new PdfPCell(new Phrase(texto, font));
       cell.setBorder(Rectangle.BOTTOM);
       return cell;
   }

   // Método para crear celda de encabezado con alineación específica
   private static PdfPCell encabezadoCelda(String texto, com.itextpdf.text.Font font) {
       PdfPCell cell = celda(texto, font);
       cell.setBackgroundColor(com.itextpdf.text.BaseColor.LIGHT_GRAY);
       return cell;
   }

    
    
    
//    private static void agregarContenidoTabla(Document document, DefaultTableModel modeloTabla) throws DocumentException {
//        int numColumnas = modeloTabla.getColumnCount() + 3;  // Añadir 3 columnas adicionales
//
//        PdfPTable tabla = new PdfPTable(numColumnas);
//        tabla.setWidthPercentage(100);
//
//        // Agregar encabezados de columna, incluyendo las nuevas columnas
//        for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
//            tabla.addCell(new PdfPCell(new Phrase(modeloTabla.getColumnName(columna))));
//        }
//
//        // Agregar encabezados para las nuevas columnas
//        tabla.addCell(new PdfPCell(new Phrase("%Comision")));
//        tabla.addCell(new PdfPCell(new Phrase("IGV")));
//        tabla.addCell(new PdfPCell(new Phrase("Subtotal")));
//
//        // Agregar contenido de la tabla
//        for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
//            for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
//                tabla.addCell(new PdfPCell(new Phrase(modeloTabla.getValueAt(fila, columna).toString())));
//            }
//
//            // Añadir valores para las nuevas columnas (puedes reemplazar estos valores con los cálculos reales)
//            tabla.addCell(new PdfPCell(new Phrase("10%")));  // Porcentaje de comisión
//            tabla.addCell(new PdfPCell(new Phrase("5%")));   // IGV
//            tabla.addCell(new PdfPCell(new Phrase("200")));      // Subtotal (debe calcularse)
//
//        }
//
//        // Agregar la tabla al documento
//        document.add(tabla);
//    }

}
