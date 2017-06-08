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

      - streams=M2TR:30,M2PR:30,M2PO:40
      - flows=CEQ,CFI,F01,F02,F03,F04,F05,F06,F07,F08
      - total=20
      - timeframe=1
      - batchsize=1
      - mongo.host=localhost
      - mongo.port=27017
      - mongo.db=simulator
      - mongo.username=
      - mongo.password=

   - streams: the data may come from different streams. This is a list of streams with each stream separated by a comma(,). Each stream in the list consists of the steam name and the percentage of the stream in the total records. The name and the percentage are separated by colon(:).
   - flows: the possible flow names of the test data. the flow is randomly selected for each record.
   - total: total records.
   - timefrmae: this value always set 1. It is for a feature of future versions.
   - batchsize: this value always set 1. It is for a feature of future versions.
   - mongo.host: host name of MongoDB
   - mongo.port: port number of MongoDB
   - mongo.db: database name
   - mongo.username: username of MongoDB
   - mongo.password: password of MongoDB


3. How to run:

Copy or move the four files below in the same directory:

   -  simulator-0.1.0.jar
   -  settings.properties
   -  runSimulator.bat
   -  runSimulator.sh


For windows, run runSimulator.bat or double click it.


For Unix/Linux, run runSimulator.sh
