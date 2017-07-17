package com.citi.reghub.rds.simulator.domain;

import java.util.Random;

public enum Status {
	REPORTABLE, NON_REPORTABLE, EXCEPTION, PENDING, REPORTED, REJECTED;
	
	private static Random random = new Random();
	
	public static Status getRandomElement() {
		return Status.values()[random.nextInt(Status.values().length)];
	}
}
