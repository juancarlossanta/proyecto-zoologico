package zoo.models;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

	private String name;
	private List<Animal> animals;

	public Habitat(String name) {
		this.name = name;
		this.animals = new ArrayList<>();
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public String getName() {
		return name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

}
