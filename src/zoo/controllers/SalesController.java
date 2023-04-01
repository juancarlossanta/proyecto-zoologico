package zoo.controllers;

import java.util.List;

import zoo.arraysgetion.Gestion;
import zoo.models.Sale;

public class SalesController {

	private static Gestion gestion = new Gestion();

//	public SalesController() {
//		SalesController.gestion = new Gestion();
//	}

	public List<Sale> listSales() {
		return gestion.listSales();
	}

	public void addSale(Sale transaction) {
		gestion.addSale(transaction);
	}

	public double getTotalSales() {
		return gestion.getTotalSales();
	}

}
