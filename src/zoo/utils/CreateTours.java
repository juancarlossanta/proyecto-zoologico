package zoo.utils;

import java.util.ArrayList;

import zoo.models.Extra;
import zoo.models.Tour;

public class CreateTours {

	public static ArrayList<Tour> create() {

		ArrayList<Tour> plans = new ArrayList<>();

		Extra souvenir = new Extra("Gorra");
		Extra refrigerio = new Extra("Refrigerio");

		Tour tour1 = new Tour("Tour de Mascotas", 8000, .04f);
		tour1.addHabitat(CreateHabitats.buscarHabitat("Granja"));
		tour1.addExtra(refrigerio);

		Tour tour2 = new Tour("Safari Salvaje", 10000, .08f);
		tour2.addHabitat(CreateHabitats.buscarHabitat("Jungla"));
		tour2.addHabitat(CreateHabitats.buscarHabitat("Laguna"));

		Tour tour3 = new Tour("Aves rapaces y aves exóticas", 12000, .09f);
		tour3.addHabitat(CreateHabitats.buscarHabitat("Aviario"));
		tour3.addExtra(souvenir);

		Tour tour4 = new Tour("Los delfines y vida acuática", 9000, .10f);
		tour4.addHabitat(CreateHabitats.buscarHabitat("Acuario"));
		tour4.addHabitat(CreateHabitats.buscarHabitat("Laguna"));

		Tour tour5 = new Tour("Tour por el acuario", 8000, .02f);
		tour5.addHabitat(CreateHabitats.buscarHabitat("Acuario"));

		plans.add(tour1);
		plans.add(tour2);
		plans.add(tour3);
		plans.add(tour4);
		plans.add(tour5);

		return plans;

	}

}
