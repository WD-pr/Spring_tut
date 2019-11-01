package com.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String stringDate) throws ParseException {

		Date date = dateFormatter.parse(stringDate);

		return date;
	}

	public static String formatDate(Date date) {

		String stringDate = null;

		if (date != null) {
			stringDate = dateFormatter.format(date);
		}

		return stringDate;
	}

}
