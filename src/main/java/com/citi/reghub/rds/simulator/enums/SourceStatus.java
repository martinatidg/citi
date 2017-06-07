package com.citi.reghub.rds.simulator.enums;

import com.citi.reghub.rds.simulator.util.Util;

public enum SourceStatus {
	NEW, AMEND, CANCEL;
	
	public static SourceStatus getRandomElement() {
		return SourceStatus.values()[Util.getRandomInteger(SourceStatus.values().length)];
	}
}
