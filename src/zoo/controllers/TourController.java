package zoo.controllers;

import java.util.List;

import zoo.arraysgetion.Gestion;
import zoo.models.Tour;

public class TourController {

	private static Gestion gestion = new Gestion();

	public List<Tour> listTours() {
		return gestion.listTours();
	}

	public Tour getTourById(int id) {
		return gestion.getTourById(id);
	}

	public Tour getByName(String name) {
		return gestion.getByName(name);
	}

}
