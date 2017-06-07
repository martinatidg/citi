package com.citi.reghub.rds.simulator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.citi.reghub.rds.simulator.domain.Entity;
import com.citi.reghub.rds.simulator.repository.EntityRepository;

public class Simulator {
	private static Logger log = LoggerFactory.getLogger(Simulator.class);
	@Autowired
	private DataGenerator dataGenerator;

	@Autowired
	private EntityRepository entityRepository;
	

	public void runSimulator() {
		Entity entity = dataGenerator.getOneEntity();
		int recSaved = 0;

		while (entity != null) {
			entityRepository.save(entity);
			++recSaved;

			try {
				Thread.sleep(dataGenerator.getIntervalTime());
			} catch (InterruptedException e) {
				log.error("runSimulator error:\n" + e.getMessage());
				break;
			}
			
			entity = dataGenerator.getOneEntity();
		}

		log.info("Total number of records saved to database: " + recSaved);
	}
}