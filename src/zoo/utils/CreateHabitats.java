package zoo.utils;

import java.util.ArrayList;

import zoo.models.Animal;
import zoo.models.Habitat;

public class CreateHabitats {

	static ArrayList<Habitat> habitats = new ArrayList<>();

	public static ArrayList<Habitat> create() {

		Habitat granja = new Habitat("Granja");
		Habitat jungla = new Habitat("Jungla");
		Habitat laguna = new Habitat("Laguna");
		Habitat aviario = new Habitat("Aviario");
		Habitat acuario = new Habitat("Acuario");

		habitats.add(granja);
		habitats.add(jungla);
		habitats.add(laguna);
		habitats.add(aviario);
		habitats.add(acuario);

		return habitats;
	}

	public static void addAnimal(String nameHabitat, Animal animal) {
		Habitat habitat = buscarHabitat(nameHabitat);
		habitat.addAnimal(animal);
	}

	public static Habitat buscarHabitat(String nameHabitat) {
		Habitat encontrado = null;
		for (Habitat habitat : habitats) {
			if (habitat.getName() == nameHabitat) {
				encontrado = habitat;
				break;
			}
		}
		return encontrado;
	}

	public static ArrayList<Animal> getTodos() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (Habitat habitat : habitats) {
			animals.addAll(habitat.getAnimals());
		}
		return animals;
	}

	public static String[] getHabitatNames() {
		String[] names = new String[habitats.size()];
		for (int i = 0; i < habitats.size(); i++) {
			names[i] = habitats.get(i).getName();
		}
		return names;
	}

}
