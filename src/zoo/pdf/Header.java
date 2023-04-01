package zoo.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Header {

	public static PdfPTable create() {

		PdfPTable table = new PdfPTable(2); // Crea una tabla con 2 columnas

		try {

			table.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
			table.setSpacingBefore(10f); // Espacio antes de la tabla
			table.setSpacingAfter(10f); // Espacio después de la tabla

			// Añadir imagen
			Image image = Image.getInstance("src/zoo/imgs/logo.png");
			image.scaleToFit(250f, 250f);
			image.setAlignment(Chunk.ALIGN_MIDDLE);

			// Create Font objects
			Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.ITALIC | Font.BOLD);
			font.setColor(new BaseColor(127, 127, 127));

			// Datos Encabezado
			String nombre = "ZOODI";
			String ubicacion = "Medellín, Colombia";
			String contacto = "321-1234567";
			String newLine = System.getProperty("line.separator");

			Paragraph info = new Paragraph(nombre + newLine + ubicacion + newLine + contacto, font);
			info.setAlignment(Element.ALIGN_CENTER);

			// Agrega encabezados a la tabla
			PdfPCell cell1 = new PdfPCell(image);
			PdfPCell cell2 = new PdfPCell();
			cell2.addElement(info);

			cell1.setBackgroundColor(MyReport.myPrimaryColor);
			cell2.setBackgroundColor(MyReport.myPrimaryColor);

			cell1.setBorder(0);
			cell2.setBorder(0);

			table.addCell(cell1);
			table.addCell(cell2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;

	}

}
