package zoo.utils;

import java.util.ArrayList;

import zoo.models.Visitor;

public class CreateVisitor {

	public static ArrayList<Visitor> create() {

		ArrayList<Visitor> visitors = new ArrayList<>();
		visitors.add(new Visitor("123", "Juan", "Calle falsa", "321"));
		return visitors;

	}

}
