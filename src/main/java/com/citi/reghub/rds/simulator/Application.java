package com.citi.reghub.rds.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.citi.reghub.rds.simulator.util.Simulator;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {
	@Autowired
	Simulator simulator;

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		simulator.runSimulator();
		System.exit(0);		// Explicit call this because when run from Eclipse, it will not exit automatically.
	}

}
