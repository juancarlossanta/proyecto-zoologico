package zoo.controllers;

import java.util.List;

import zoo.arraysgetion.Gestion;
import zoo.models.Visitor;

public class VisitorController {

	private static Gestion gestion = new Gestion();

//	public VisitorController() {
//		VisitorController.gestion = new Gestion();
//	}

	public void addVisitor(Visitor visitor) {
		gestion.addVisitor(visitor);
	}

	public List<Visitor> listVisitors() {
		return gestion.listVisitors();
	}

	public Visitor searchVisitorByCedula(String cedula) {
		return gestion.searchVisitorByCedula(cedula);
	}

}
