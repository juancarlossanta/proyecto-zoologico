package zoo.models;

import java.util.ArrayList;
import java.util.List;

public class Tour {

	private static int accum;

	private int id;
	private String name;
	private double price;
	private double discount;
	private List<Habitat> habitats;
	private List<Extra> extras;

	public Tour(String name, double price, float discount) {
		this.id = ++accum;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.habitats = new ArrayList<>();
		this.extras = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public void addHabitat(Habitat habitat) {
		habitats.add(habitat);
	}

	public void addExtra(Extra extra) {
		extras.add(extra);
	}

	public List<Habitat> getHabitats() {
		return habitats;
	}

	public List<Extra> getExtras() {
		return extras;
	}

}