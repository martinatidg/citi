package com.citi.reghub.rds.simulator.enums;

import com.citi.reghub.rds.simulator.util.Util;

public enum Status {
	REPORTABLE, NON_REPORTABLE, EXCEPTION, PENDING, REPORTED, REJECTED;
	
	public static Status getRandomElement() {
		return Status.values()[ Util.getRandomInteger(Status.values().length)];
	}
}
