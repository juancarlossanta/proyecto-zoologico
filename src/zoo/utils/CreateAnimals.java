package zoo.utils;

import zoo.models.DomesticAnimal;
import zoo.models.WildAnimal;

public class CreateAnimals {

	public static void create() {

		DomesticAnimal perro, pezGuppy;
		WildAnimal tigre, leon, flamenco, aguila;
		perro = new DomesticAnimal("src/zoo/imgs/dog.jpg", "Perro", MakeDate.convert("13/12/2019"), "Compañía");
		pezGuppy = new DomesticAnimal("src/zoo/imgs/guppy.jpeg", "PezGuppy", MakeDate.convert("11/11/2021"),
				"Compañía");
		tigre = new WildAnimal("src/zoo/imgs/tiger.png", "Tigre", MakeDate.convert("03/02/2018"), '7');
		leon = new WildAnimal("src/zoo/imgs/lion.jpg", "León", MakeDate.convert("30/06/2019"), '5');
		flamenco = new WildAnimal("src/zoo/imgs/flemish.jpg", "Flamenco", MakeDate.convert("31/03/2022"), '4');
		aguila = new WildAnimal("src/zoo/imgs/eagle.png", "Águila", MakeDate.convert("01/12/2020"), '2');

		CreateHabitats.addAnimal("Granja", perro);

		CreateHabitats.addAnimal("Jungla", tigre);
		CreateHabitats.addAnimal("Jungla", leon);

		CreateHabitats.addAnimal("Laguna", flamenco);

		CreateHabitats.addAnimal("Aviario", aguila);

		CreateHabitats.addAnimal("Acuario", pezGuppy);

	}

}
