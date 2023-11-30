
package modelo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
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
            Paragraph encabezado = new Paragraph("Encabezado del PDF");
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);

            // Agregar la imagen
            Image imagen = Image.getInstance("src/main/resources/images/logoComp.png");
            imagen.scaleToFit(200, 200);
            document.add(imagen);

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
        

        PdfPTable tabla = new PdfPTable(modeloTabla.getColumnCount());
        tabla.setWidthPercentage(100);

        // Agregar encabezados de columna
        for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
            tabla.addCell(new PdfPCell(new Phrase(modeloTabla.getColumnName(columna))));
        }

        // Agregar contenido de la tabla
        for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
            for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
                tabla.addCell(new PdfPCell(new Phrase(modeloTabla.getValueAt(fila, columna).toString())));
            }
        }

        // Agregar la tabla al documento
        document.add(tabla);
    }
    
 
    
    
    
}
