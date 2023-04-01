package zoo.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFile {

	public static void report(String path) {
		File file = new File(path);
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
