package com.citi.reghub.rds.simulator.util;

public class Util {
	// get a random integer between 0 and max
	public static int getRandomInteger(int max) {
		int rindex = (int) Math.round(Math.random() * max);
		rindex = rindex >= max ? max - 1 : rindex;

		return rindex;
	}

	public static String getTimeStr(long time) {
		long milli = time % 1000;
		long seconds = time / 1000;
		long sec = seconds % 60;
		long minutes = seconds / 60;
		long min = minutes % 60;
		long hours = minutes / 60;
		
		return "" + hours + " hours " + min + " minutes " + sec + " seconds and " + milli + " milliseconds.";
	}
}
