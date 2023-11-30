
package modelo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;

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

            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        
    }
    


    private static void agregarContenidoTabla(Document document, DefaultTableModel modeloTabla) throws DocumentException {
        for (int fila = 0; fila < modeloTabla.getRowCount(); fila++) {
            for (int columna = 0; columna < modeloTabla.getColumnCount(); columna++) {
                document.add(new Paragraph(modeloTabla.getValueAt(fila, columna).toString()));
            }
            // Agregar nueva línea después de cada fila
            document.add(new Paragraph("\n"));
        }
    }
    
    
    
    
    
}
