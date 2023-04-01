package zoo.controllers;

import java.util.List;

import zoo.arraysgetion.Gestion;
import zoo.models.Animal;

public class HabitatController {

	private static Gestion gestion = new Gestion();

	public void addAnimal(String habitat, Animal animal) {
		gestion.addAnimal(habitat, animal);
	}

	public int getIndexByAnimalId(int id) {
		return gestion.getIndexByAnimalId(id);
	}

	public List<Animal> listAnimals() {
		return gestion.getAllAnimals();
	}

	public int sizeListAnimals() {
		return gestion.sizeListAnimals();
	}

	public void updateAnimal(int index, Animal animal) {
		gestion.updateAnimal(index, animal);
	}

	public Animal getCurrentAnimal(int index) {
		return gestion.getCurrentAnimal(index);
	}

	public String getNameByAnimalId(int animalId) {
		return gestion.getNameByAnimalId(animalId);
	}

	public int getIndexOfAmongAll(int animalId) {
		return gestion.getIndexOfAmongAll(animalId);
	}

	public String getHabiatByAnimal(Animal animal) {
		return gestion.getHabiatByAnimal(animal);
	}

}
