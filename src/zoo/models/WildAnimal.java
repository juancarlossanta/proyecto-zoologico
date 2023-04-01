package zoo.models;

import java.util.Date;

public class WildAnimal extends Animal {

	private char dangerLevel;

	public WildAnimal(String img, String name, Date birthdate, char dangerLevel) {
		super(img, name, birthdate);
		this.dangerLevel = dangerLevel;
	}

	public WildAnimal() {

	}

	public char getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(char dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public String attackHuman() {
		return "Hola, soy una animal salvaje y te ataco porque me sentí en peligro";
	}

	@Override
	public String toString() {
		return "WildAnimal [dangerLevel=" + dangerLevel + "]";
	}

}
