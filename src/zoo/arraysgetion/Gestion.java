package zoo.arraysgetion;

import java.util.ArrayList;
import java.util.List;

import zoo.models.Animal;
import zoo.models.Habitat;
import zoo.models.Sale;
import zoo.models.Tour;
import zoo.models.Visitor;
import zoo.utils.CreateHabitats;
import zoo.utils.CreateTours;

public class Gestion {

	private static ArrayList<Sale> sales = new ArrayList<>();
	private static ArrayList<Visitor> visitors = new ArrayList<>();

	private static ArrayList<Habitat> habitats = CreateHabitats.create();
	private static ArrayList<Tour> tours = CreateTours.create();

	public void addAnimal(String nameHabitat, Animal animal) {
		Habitat habitat = buscarHabitat(nameHabitat);
		habitat.addAnimal(animal);
		System.out.println("Bienvenido " + animal.toString());
	}

	public static Habitat buscarHabitat(String nameHabitat) {
		Habitat found = null;
		for (Habitat habitat : habitats) {
			if (habitat.getName().equals(nameHabitat)) {
				found = habitat;
				break;
			}
		}
		return found;
	}

	public int getIndexByAnimalId(int id) {
		return get(getAllAnimals(), id);
	}

	private int get(List<Animal> allAnimals, int id) {
		int i = 0;
		for (Animal animal : allAnimals) {
			if (animal.getAnimalId() == id) {
				i = animal.getAnimalId();
			}
		}
		return i;
	}

	public List<Animal> getAllAnimals() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (Habitat habitat : habitats) {
			animals.addAll(habitat.getAnimals());
		}
		return animals;
	}

	public void updateAnimal(int index, Animal animal) {
		List<Animal> animals = getAllAnimals();
		animals.add(index, animal);

	}

	public int sizeListAnimals() {
		return getAllAnimals().size() - 1;
	}

	public Animal getCurrentAnimal(int index) {
		return getAllAnimals().get(index);
	}

	public String getNameByAnimalId(int animalId) {
		String name = "";
		for (Habitat habitat : habitats) {
			for (Animal animal : habitat.getAnimals())
				if (animal.getAnimalId() == animalId) {
					name = habitat.getName();
					break;
				}

			if (!name.equals(""))
				break;
		}
		return name;
	}

	public void addVisitor(Visitor visitor) {
		visitors.add(visitor);
	}

	public List<Visitor> listVisitors() {
		return visitors;
	}

	public Visitor searchVisitorByCedula(String cedula) {
		Visitor found = new Visitor();
		for (Visitor visitor : visitors) {
			if (visitor.getCedula().equals(cedula)) {
				found = visitor;
			}
		}
		return found;
	}

	public void addSale(Sale sale) {
		sales.add(sale);
	}

	public Tour getTourById(int id) {
		Tour found = null;
		for (Tour tour : tours)
			if (tour.getId() == id) {
				found = tour;
				break;
			}

		return found;
	}

	public Tour getByName(String name) {
		Tour found = null;
		for (Tour tour : tours)
			if (tour.getName().equals(name)) {
				found = tour;
				break;
			}

		return found;
	}

	public List<Tour> listTours() {
		return tours;
	}

	public List<Sale> listSales() {
		return sales;
	}

	public double getTotalSales() {
		double total = 0;
		for (Sale sale : sales) {
			total += sale.getTotal();
		}
		return total;
	}

}
