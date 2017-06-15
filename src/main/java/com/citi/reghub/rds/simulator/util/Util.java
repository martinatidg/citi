package com.citi.reghub.rds.simulator.util;

public class Util {
	// get a random integer between 0 and max
	public static int getRandomInteger(int max) {
		int rindex = (int) Math.round(Math.random() * max);
		rindex = rindex >= max ? max - 1 : rindex;

		return rindex;
	}
}
