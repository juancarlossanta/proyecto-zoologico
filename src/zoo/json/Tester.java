package zoo.json;

import java.util.List;

import zoo.models.Animal;
import zoo.utils.MakeDate;

public class Tester {

	public static void main(String args[]) {

		GsonAnimal gsonAnimal = new GsonAnimal();

		Animal animal = new Animal("src/zoo/imgs/bear.jpg", "Mi oso", MakeDate.convert("13/01/2021"));
		gsonAnimal.writeJSON(animal);

		List<Animal> animals2 = gsonAnimal.readJSON();
		System.out.println(animals2.get(0));

	}

}
