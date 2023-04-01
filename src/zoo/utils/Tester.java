package zoo.utils;

import java.util.ArrayList;

import zoo.models.Animal;
import zoo.models.Tour;

public class Tester {

	public static void main(String[] args) {

		CreateHabitats.create();
		CreateAnimals.create();

		ArrayList<Tour> tours = CreateTours.create();

		System.out.println(tours.get(0).getExtras().get(0).getName());
		System.out.println(tours.get(0).getHabitats().get(0).getAnimals().get(0).getName());

		ArrayList<Animal> animals = todos();

		System.out.println(animals.size());

		System.out.println(CreateHabitats.getHabitatNames()[1]);

	}

	private static ArrayList<Animal> todos() {
		return CreateHabitats.getTodos();
	}

}
