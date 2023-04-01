package zoo.utils;

import java.util.Calendar;
import java.util.Date;

public class Today {

	public static Date getTime() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
		return today.getTime();
	}

}
