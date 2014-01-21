package com.operasolutions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Utils {

	public static Double doublePrecise = 0.000001d;
	public static Float floatPrecise = 0.000001f;
	private final static SimpleDateFormat simple = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	static {
		simple.setTimeZone(TimeZone.getTimeZone("GMT-4"));
	}

	public synchronized static String timestampeToString(long date) {

		return simple.format(new Date(date));
	}

	public synchronized static Long stringTotimestamp(String str) {

		try {
			return simple.parse(str).getTime();
		} catch (ParseException e) {
			throw new RuntimeException(
					"exception is happened during string to timestamp");
		}
	}

}