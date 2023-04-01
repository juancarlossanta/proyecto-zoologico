package zoo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeDate {

	public static Date convert(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
