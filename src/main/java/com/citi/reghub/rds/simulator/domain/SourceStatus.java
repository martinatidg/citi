package com.citi.reghub.rds.simulator.domain;

import java.util.Random;

public enum SourceStatus {
	NEW, AMEND, CANCEL;
	
	private static Random random = new Random();

	public static SourceStatus getRandomElement() {
		return SourceStatus.values()[random.nextInt(SourceStatus.values().length)];
	}
}
