package com.citi.reghub.rds.simulator;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.citi.reghub.rds.simulator.util.Simulator;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
class ApplicationConfig extends AbstractMongoConfiguration {
	private static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return "simulator";
	}

	@Override
	@Bean //("mongoClient")
	public Mongo mongo() throws Exception {
		String mongoHost = env.getProperty("mongo.host");
		String dbName = env.getProperty("mongo.db");
		int mongoPort = Integer.parseInt(env.getProperty("mongo.port"));
		String username = env.getProperty("mongo.username");
		String password = env.getProperty("mongo.password");

		log.info("MongHost = " + mongoHost + ", dbName = " + dbName + ", mongoPort = " + mongoPort + ", username = " + username);

		if ("localhost".equalsIgnoreCase(mongoHost)) {
			return new MongoClient("localhost",  mongoPort);
		}

		//MongoCredential credential = MongoCredential.createMongoCRCredential(username, dbName, password.toCharArray());
		MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());
		return new MongoClient(new ServerAddress(mongoHost, mongoPort), Arrays.asList(credential));
	}

	@Bean(name="simulator")
	@DependsOn("dataGenerator")
	public Simulator simulator() {
		return new Simulator();
	}
}