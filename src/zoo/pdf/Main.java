package zoo.pdf;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import zoo.controllers.SalesController;
import zoo.models.Sale;

public class Main {

	private static SalesController salesController = new SalesController();

	public static Paragraph createParagraph() {
		Paragraph formParagraph = new Paragraph("Informe de ventas discriminado por el tipo de plan:");
		return formParagraph;
	}

	public static PdfPTable createTable() {

		PdfPTable table2 = new PdfPTable(6); // Crea una tabla con 3 columnas
		table2.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
		table2.setSpacingBefore(10f); // Espacio antes de la tabla
		table2.setSpacingAfter(10f); // Espacio después de la tabla

		// Agrega encabezados a la tabla
		PdfPCell cell12 = new PdfPCell(new Paragraph("PLAN"));
		PdfPCell cell22 = new PdfPCell(new Paragraph("VALOR"));
		PdfPCell cell32 = new PdfPCell(new Paragraph("CANTIDAD"));
		PdfPCell cell42 = new PdfPCell(new Paragraph("VALOR VENTA"));
		PdfPCell cell52 = new PdfPCell(new Paragraph("DESCUENTO"));
		PdfPCell cell62 = new PdfPCell(new Paragraph("TOTAL"));
		table2.addCell(cell12);
		table2.addCell(cell22);
		table2.addCell(cell32);
		table2.addCell(cell42);
		table2.addCell(cell52);
		table2.addCell(cell62);

		// Agrega filas a la tabla
		List<String[]> planes = obtenerPlanes();
		for (String[] plan : planes) {
			table2.addCell(plan[0]);
			table2.addCell(plan[1]);
			table2.addCell(plan[2]);
			table2.addCell(plan[3]);
			table2.addCell(plan[4]);
			table2.addCell(plan[5]);
		}

		return table2;

	}

	public static Paragraph createResumen() {
		Paragraph totales = new Paragraph(String.format("Total de las ventas: $%.2f", obtenerTotal()));
		totales.setAlignment(Element.ALIGN_RIGHT);
		return totales;
	}

	// Retorna una lista de ciudades como array de strings
	private static List<String[]> obtenerPlanes() {

		List<String[]> planes = new ArrayList<>();

		List<Sale> transactions = salesController.listSales();
		for (Sale sales : transactions) {
			String[] plan = new String[6];
			double valorVenta = sales.getItem().getPrice() * sales.getQuantity();
			plan[0] = sales.getItem().getName();
			plan[1] = sales.getItem().getPrice() + "";
			plan[2] = sales.getQuantity() + "";
			plan[3] = valorVenta + "";
			plan[4] = (int) (sales.getItem().getDiscount() * 100) + "%";
			plan[5] = String.format("%.2f", valorVenta * (1 - sales.getItem().getDiscount()));
			planes.add(plan);
		}

		return planes;
	}

	private static double obtenerTotal() {
		return salesController.getTotalSales();
	}

}
