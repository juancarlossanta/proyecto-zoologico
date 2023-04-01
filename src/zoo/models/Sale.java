package zoo.models;

import java.util.Date;

public class Sale {

	private static int accum;

	private int transactionId;
	private Date date;
	private Tour item;
	private Visitor visitor;
	private int quantity;
	private double total;

	public Sale(Date date, Tour item, Visitor visitor, int quantity, double total) {
		this.transactionId = ++accum;
		this.date = date;
		this.item = item;
		this.visitor = visitor;
		this.quantity = quantity;
		this.total = total;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public Date getDate() {
		return date;
	}

	public Tour getItem() {
		return item;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "SalesTransaction [transactionId=" + transactionId + ", date=" + date + ", item=" + item + ", quantity="
				+ quantity + ", payment=" + total + "]";
	}

}
