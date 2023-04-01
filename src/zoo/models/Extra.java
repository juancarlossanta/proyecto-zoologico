package zoo.models;

public class Extra {

	private String name; // Souvenir, snack

	public Extra(String name) {
		this.name = name;
	}

	public Extra() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Extra [name=" + name + "]";
	}

}
