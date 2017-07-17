package com.citi.reghub.rds.simulator.util;

public class Util {
	private Util() {
		throw new UnsupportedOperationException("The Util class contains static methods only and cannot be instantiated.");
	}

	public static String convertLongToTime(long time) {
		long milli = time % 1000;
		long seconds = time / 1000;
		long sec = seconds % 60;
		long minutes = seconds / 60;
		long min = minutes % 60;
		long hours = minutes / 60;
		
		return hours + ":" + min + ":" + sec + ":" + milli;
	}
}
