package zoo.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import zoo.utils.OpenFile;

public class MyReport {

	public static BaseColor myPrimaryColor = new BaseColor(50, 88, 134); // or red, green, blue, alpha

	public static void generate() {

		// Crear el document PDF
		Document document = new Document();
		String path = "src/zoo/pdf/my-report.pdf";

		try {
			// Escribir el documento en un archive PDF
			PdfWriter.getInstance(document, new FileOutputStream(path));

			// Abrir el documento
			document.open();

			// Crear Encabezado
			document.add(Header.create()); // Agrega la tabla al documento

			// Informe de ventas
			document.add(Main.createParagraph());
			document.add(Main.createTable()); // Agrega la tabla al documento

			// Agregar Totales (Resumen)
			document.add(Main.createResumen());

			// Crear Pies de Página
			document.add(Footer.create());

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar et documento
			document.close();
		}

		OpenFile.report(path);

	}

}
