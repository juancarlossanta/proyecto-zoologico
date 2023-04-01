package zoo.utils;

import javax.swing.JOptionPane;

public class ShowMessage {

	public static void generic(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static void info(String message) {
		JOptionPane.showMessageDialog(null, message, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void warning(String message) {
		JOptionPane.showMessageDialog(null, message, "INFORMATION", JOptionPane.WARNING_MESSAGE);
	}

	public static int question(String message) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		return JOptionPane.showOptionDialog(null, message, "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
	}

}
