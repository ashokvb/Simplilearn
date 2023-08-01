package com.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesUtil {
	/**
	 * Returns current date. Default date format is "M/dd/yyyy" if input parameter
	 * is supplied empty String.
	 * 
	 * @param: String
	 *             dateFormat Ex: dd/MM/yyyy or any Expected format
	 */
	public static String getCurrentDatebyFormat(String dateFormat) {
		DateFormat format = new SimpleDateFormat(dateFormat.isEmpty() ? "M/dd/yyyy" : dateFormat);
		Date date = new Date();

		System.out.println(" THis is Date" + format.format(date));
		return format.format(date);
	}

	/**
	 * Returns future date from today to number of days supplied in parameters.
	 * 
	 * @param: int
	 *             numberOfDays
	 * @param: String
	 *             dateFormat
	 */
	public static String getFutureDatebyDays(int numberOfDays, String dateFormat) {
		DateFormat format = new SimpleDateFormat(dateFormat.isEmpty() ? "M/dd/yyyy" : dateFormat);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		Date date = calendar.getTime();

		return format.format(date);
	}

	/*
	 * Returns current year
	 * 
	 * @param: String format
	 */
	public static String getCurrentYear(String format) {
		DateFormat sdf = new SimpleDateFormat(format.isEmpty() ? "yyyy" : format);
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}

	/**
	 * Returns future year from current year to no of years supplied in parameters.
	 * 
	 * @param: int
	 *             numberOfYears
	 * @param: String
	 *             format
	 */
	public static String getFutureYear(String format, int numberOfYears) {
		DateFormat sdf = new SimpleDateFormat(format.isEmpty() ? "yyyy" : format);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, numberOfYears);
		return sdf.format(calendar.getTime());
	}

}
