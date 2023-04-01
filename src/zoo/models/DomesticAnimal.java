package zoo.models;

import java.util.Date;

public class DomesticAnimal extends Animal {

	private String service; // companions, food, transportation, or labor

	public DomesticAnimal() {
	}

	public DomesticAnimal(String img, String name, Date birthdate, String service) {
		super(img, name, birthdate);
		this.service = service;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String interactWithVisitor() {
		return "Hola, soy una animal domestico y estoy interactuando con este humano";
	}

	@Override
	public String toString() {
		return "DomesticAnimal [service=" + service + "]";
	}

}
