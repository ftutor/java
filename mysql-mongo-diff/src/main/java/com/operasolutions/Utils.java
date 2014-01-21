package com.operasolutions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.operasolutions.mongo.FundOverviewEntity;

public final class Utils {
	private static Logger logger = Logger.getLogger(FundOverviewEntity.class);
	private static int bitNum = 6;
	public static Double doublePrecise = 0.00001d;
	public static Float floatPrecise = 0.00001f;
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

	public static boolean comp(Object objA, Object objB) {

		String A = objA.toString();
		String B = objB.toString();
		// logger.info("A value:" + A);
		// logger.info("B value:" + B);
		if (A.length() >= bitNum && B.length() >= bitNum) {

			for (int i = 0; i < bitNum; i++) {

				if (A.charAt(i) != B.charAt(i)) {
					return false;
				}
			}
		}

		return false;

	}

}