package zoo.models;

public class Visitor {

	private int visitorId;
	private String cedula;
	private String name;
	private String address;
	private String phone;
	public int visits;

	public static int accum;

	public Visitor(String cedula, String name, String address, String phone) {
		this.visitorId = ++accum;
		this.cedula = cedula;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.visits = 1;
	}

	public Visitor() {
		this.cedula = "";
		this.name = "";
		this.address = "";
		this.phone = "";
	}

	public int getVisitorId() {
		return visitorId;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void incrementVisits() {
		visits++;
	}

	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", cedula=" + cedula + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", visits=" + visits + "]";
	}

}
