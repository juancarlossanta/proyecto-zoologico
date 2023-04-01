package zoo.models;

import java.util.Date;

import zoo.interfaces.LivingBeings;

public class Animal implements LivingBeings {

	private static int accum;

	private int animalId;
	private String urlImg;
	private String name;
	private Date birthdate;

	public Animal(String urlImg, String name, Date birthdate) {
		this.animalId = ++accum;
		this.urlImg = urlImg;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Animal() {
		this.urlImg = "";
		this.name = "";
		this.birthdate = null;
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public void toEat() {
		System.out.println("Hola, soy " + name + " y estoy comiendo!");
	}

	@Override
	public void toDrink() {
		System.out.println("Hola, soy " + name + " y estoy bebiendo!");
	}

	@Override
	public void toPlay() {
		System.out.println("Hola, soy " + name + " y estoy jugando!");
	}

	@Override
	public void toSleep() {
		System.out.println("Hola, shhh! " + name + " está durmiendo.");
	}

	@Override
	public String toString() {
		return "Animal [animalId=" + animalId + ", urlImg=" + urlImg + ", name=" + name + ", birthdate=" + birthdate
				+ "]";
	}

}
