package com.citi.reghub.rds.simulator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component(value="entityProperties")
public class EntityProperties {
	// default values
	private static final int TOTAL = 100;
	private static final int TIME_FRAME = 2; // minutes
	private static final int BATCH_SIZE = 2;

    @Autowired
    Environment env;
    

	public String getStreams() {
		return env.getProperty("streams");
	}

	public String getFlows() {
		return env.getProperty("flows");
	}

	public int getTotal() {
		return parseInteger("total", TOTAL);
	}

	public int getTimeframe() {
		return parseInteger("timeframe", TIME_FRAME);
	}

	public int getBatchSize() {
		return parseInteger("batchsize", BATCH_SIZE);
	}

	private int parseInteger(String intStr, int defaultInt) {
		int intValue = 0;
		try {
			intValue = Integer.parseInt(env.getProperty(intStr));
		}
		catch(Exception e) {
			intValue = defaultInt;
		}

		return intValue;
	}
}
