package com.citi.reghub.rds.simulator.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.citi.reghub.rds.simulator.domain.Entity;
import com.citi.reghub.rds.simulator.domain.Info;
import com.citi.reghub.rds.simulator.domain.SourceStatus;
import com.citi.reghub.rds.simulator.domain.Status;

@Component
public class DataGenerator {
	private static Logger logger = LoggerFactory.getLogger(DataGenerator.class);
	
	private Random random = new Random();
	private int totalRecordNum;
	private int batchSize;
	private Map<String, Integer> streamMap;
	private List<String> streamList;
	private List<String> flowList;
	private int intervalTime;
	private int nonEligibleNum; // number of eligible records

	@Autowired
	public DataGenerator(
			@Value("${rds.simulator.streams}") String streams,
			@Value("${rds.simulator.flows}") String flows,
			@Value("${rds.simulator.total}") int total,
			@Value("${rds.simulator.timeframe}") int timeFrame,
			@Value("${rds.simulator.batchsize}") int batchSize,
			@Value("${rds.simulator.batchsize}") int nonEligible
			) {

		logger.info("\nSettings file content:\n" + "streams: {}\nflows: {}\ntotal: {}\ntimeFrame: {}\nbatch size: {}",
				streams, flows, total, timeFrame, batchSize);
		
		streamMap = new HashMap<>();
		streamList = new ArrayList<>();
		flowList = new ArrayList<>();
		
		totalRecordNum = total;
		this.batchSize = batchSize;
		nonEligibleNum = (nonEligible * totalRecordNum) / 100;
		intervalTime = 0;	// disable the time frame function for this version.

		String[] streamArray = streams.split(",");
		int percentageSum = 0;
		int remainNum = totalRecordNum;		// used for the last stream to avoid the inaccurate of the divide calculation

		for (int i = 0; i < streamArray.length - 1; i++) {
			String[] splitStr = streamArray[i].split(":");
			int streamPercentage = 0;

			try {
				streamPercentage = Integer.parseInt(splitStr[1]);
				percentageSum += streamPercentage;
				
				// validate the percentage value in the settings file. The sum of all streams' percentage should not be greater than 100
				if (percentageSum >= 100) {
					logger.error("Invalid values: the sum of percentage for streams is greater than 100%.");
					System.exit(1);
				}
			} catch (NumberFormatException e) {
				logger.error("The settings.properties file contains invalid values.");
				System.exit(1);
			}
			
			int eachTreamNum = (streamPercentage * totalRecordNum) / 100;
			remainNum -= eachTreamNum;
			streamMap.put(splitStr[0], eachTreamNum); // record number for each of the stream names
			streamList.add(splitStr[0]);
		}

		// the last element of the stream
		if (streamArray.length > 0) {
			String[] splitStr = streamArray[streamArray.length-1].split(":");
			streamMap.put(splitStr[0], remainNum);
			streamList.add(splitStr[0]);
		}

		flowList = Arrays.asList(flows.split(","));
	}

	// To distribute the insertion operations in a time frame, get the waiting time for each insertion.
	public int getIntervalTime() {
		return intervalTime;
	}

	public int getTotalRecordNum() {
		return totalRecordNum;
	}

	public Entity getBaseEntity() {
		List<String> reasonCodes = new ArrayList<String>();
		Info info = getBaseInfo();

		return new Entity(Status.getRandomElement(), "stream", "flow", "sourceUId", "sourceId", "sourceVersion",
				SourceStatus.getRandomElement(), "sourceSystem", "regReportingRef", 
				LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), reasonCodes, info);
	}
	
	private Info getBaseInfo() {
		return new Info("PACW1", "sub type", LocalDateTime.now(), "EUR", LocalDateTime.now(), "7921619", LocalDate.of(2016, 7, 4),
				"New", "0109", "origSrcSys", "02", "ACCOUNTMNEMONIC", "EUR", "BUY", "FII", "ACCOUNTMNEMONIC",
				LocalDateTime.parse("2017-01-10 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
				new BigDecimal("2500.000000"), new BigDecimal("47.300000"), new BigDecimal("47.300000"),
				new BigDecimal("100.000000"), "Market", "02WB644", "AGENCY");
	}

	public Entity getOneEntity() {
		String rstr = getRandomStream();
		if (rstr == null || rstr.trim().isEmpty()) {
			return null;
		}

		Entity entity = getBaseEntity();
		boolean eligible = this.getRandomBoolean();

		entity.setStream(rstr);
		entity.setFlow(getRandomFlow());
		entity.setRDSEligible(eligible);

		return entity;
	}

	public List<Entity> getBatchEntity() {
		List<Entity> entityList = new ArrayList<>();

		for (int i = 0; i < batchSize; i++) {
			Entity entity = getOneEntity();
			if (entity == null) {
				break;
			}
			
			entityList.add(entity);
		}

		return entityList.isEmpty() ? null : entityList;
	}

	// Each of the stream names is assigned a percentage of the total record.
	// The percentage is set in the settings properties file.
	// Select a stream from the available stream list and the number of the stream
	// is decreased by one and if it's 0, the the stream name is removed from the list
	private String getRandomStream() {
		int streamSize = streamList.size();
		if (streamSize < 1) {
			return ""; // finished creating all records
		}

		int selectedIndex = random.nextInt(streamSize);
		String strm = streamList.get(selectedIndex);
		int remainStream = streamMap.get(strm);

		remainStream--;
		if (remainStream < 1) {
			streamList.remove(strm);
			streamMap.remove(strm);
		} else {
			streamMap.put(strm, remainStream);
		}

		return strm;
	}

	private String getRandomFlow() {
		int selectedIndex = random.nextInt(flowList.size());
		return flowList.get(selectedIndex);
	}

	private boolean getRandomBoolean() {
		if (nonEligibleNum < 1) {
			return true;
		}

		boolean rb = random.nextBoolean();
		
		if (!rb) {
			nonEligibleNum--;
		}
		
		return rb;
	}
}
