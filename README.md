# Remote Data Store - Data Simulator
DataSimulator 0.1.0 is an application to generate data and save them to a MongoDB for testing purpose. 

1. Data Structure

The data comprise records and each record has the below elements:

	- regHubId;
	- status;
	- stream;
	- flow;
	- sourceUId;
	- sourceId;
	- sourceVersion;
	- sourceStatus;
	- sourceSystem;
	- regReportingRef;
	- receivedTs;
	- publishedTs;
	- executionTs;
	- lastUpdatedTs;
	- isRDSEligible
	- reasonCodes;
	- info; 

The info element also contains the following elements:

	- firmAcctId;
	- tradeSubType;
	- tradeExecTs;
	- settlementCcy;
	- rioTxnTs;
	- securityId;
	- tradeDate;
	- tradeExecType;
	- traderId;
	- origSrcSys;
	- sourceFirmCode;
	- firmAcctIdType;
	- tradePriceCcy;
	- buySellInd; 
	- securityIdType;
	- cptyAcctIdType;
	- oceanCreatedTs;
	- tradeQty;
	- settlementPrice;
	- regTradePrice;
	- tradePrice;
	- tradeType;
	- cptyAcctId;
	- tradeCapacity;

2. settings.properties

This properties file is used to set the parameters to run DataSimulator. here is an example:

      - rds.simulator.streams=M2TR:30,M2PR:30,M2PO:40
      - rds.simulator.flows=CEQ,CFI,F01,F02,F03,F04,F05,F06,F07,F08
      - rds.simulator.total=100
      - rds.simulator.timeframe=1
      - rds.simulator.batchsize=10
      - rds.simulator.nonEligible=15
      - spring.data.mongodb.uri=mongodb://localhost/simulator
      - #spring.data.mongodb.uri=mongodb://USERNAME:PASSWORD@HOSTNAME:PORT/DBNAME
      - spring.main.web-environment=false

   - streams: the data may come from different streams. This is a list of streams with each stream separated by a comma(,). Each stream in the list consists of the steam name and the percentage of the stream in all records. The name and the percentage are separated by colon(:).
   - rds.simulator.flows: the possible flow names of the test data. the flow is randomly selected for each record.
   - rds.simulator.total: total records.
   - rds.simulator.timefrmae: this value always set 1. It is for a feature of future versions.
   - rds.simulator.batchsize: the record number to save to MongoDB in batch.
   - rds.simulator.nonEligible: the percentage of records with isRDSEligible is false
   - spring.data.mongodb.uri: the Spring property for accessing the MongoDB. The user need to set it.
   - spring.main.web-environment: disable the web environment


3. How to run:

All the required files to run the the program is put in a ZIP file, rds-data-simulator-0.1.0-release.zip. Unzip it any where and you will see a folder 'rds-data-simulator-0.1.0' which contains the following files: 

   -  rsd-data-simulator-0.1.0.jar
   -  settings.properties
   -  runSimulator.bat
   -  runSimulator.sh
   -  README.md

The user need to change the settings.properties file.

Start the MongoDB server.
 
For windows, run runSimulator.bat or double click it.

For Unix/Linux, run runSimulator.sh
