package zoo.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Footer {

	public static PdfPTable create() {
		PdfPTable table3 = new PdfPTable(1); // Crea una tabla con 3 columnas
		table3.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
		table3.setSpacingBefore(10f); // Espacio antes de la tabla
		table3.setSpacingAfter(10f); // Espacio después de la tabla

		// Agregar pie de pagina
		Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font2.setColor(new BaseColor(127, 127, 127));

		Paragraph copyright = new Paragraph("zoodi.org | Copyright © 2023. All rights reserved.", font2);
		copyright.setSpacingBefore(10f);
		copyright.setSpacingAfter(10f);
		copyright.setAlignment(Element.ALIGN_CENTER);

		PdfPCell cell31 = new PdfPCell();
		cell31.addElement(copyright);

		cell31.setBackgroundColor(MyReport.myPrimaryColor);
		cell31.setBorder(0);

		table3.addCell(cell31);

		return table3;
	}

}
