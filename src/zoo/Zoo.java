package zoo;

import zoo.utils.CreateAnimals;
import zoo.utils.CreateHabitats;
import zoo.views.Index;

public class Zoo {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Index frame = new Index();
		frame.setVisible(true);
		admonZoo();
	}

	private static void admonZoo() {
		CreateHabitats.create();
		CreateAnimals.create();
	}
}
