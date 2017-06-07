package com.citi.reghub.rds.simulator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.citi.reghub.rds.simulator.util.Simulator;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
class ApplicationConfig extends AbstractMongoConfiguration {
	@Override
	protected String getDatabaseName() {
		return "simulator";
	}

	@Override
	@Bean //("mongoClient")
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
	}

	@Bean(name="simulator")
	@DependsOn("dataGenerator")
	public Simulator simulator() {
		return new Simulator();
	}
}