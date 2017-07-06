package com.citi.reghub.rds.simulator.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.citi.reghub.rds.simulator.domain.Entity;
import com.citi.reghub.rds.simulator.repository.EntityRepository;

public class Simulator {
	private static Logger LOGGER = LoggerFactory.getLogger(Simulator.class);

	@Autowired
	private DataGenerator dataGenerator;
	@Autowired
	private EntityRepository entityRepository;

	public void runSimulator() {
		long start = System.currentTimeMillis();
		List<Entity> entity = dataGenerator.getBatchEntity();
		int recSaved = 0;

		while (entity != null) {
			entityRepository.save(entity);
			recSaved += entity.size();

			try {
				Thread.sleep(dataGenerator.getIntervalTime());
			} catch (InterruptedException e) {
				LOGGER.error("runSimulator error:\n{}", e.getMessage());
				break;
			}
			
			entity = dataGenerator.getBatchEntity();
		}
		
		long end = System.currentTimeMillis();

		LOGGER.info("{} records saved to MongoDB. Time used: {}.", recSaved, Util.convertLongToTime(end - start));
	}
}