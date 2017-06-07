package com.citi.reghub.rds.simulator.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Info {
	private String firmAcctId;  			// "PACW1"
	private String tradeSubType; 			// null
	private LocalDateTime tradeExecTs; 		// LocalDateTime.parse("2016-07-04 03:58:27", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
	private String settlementCcy;  			// "EUR"
	private LocalDateTime rioTxnTs; 		// LocalDateTime.parse("2016-07-04 04:14:02", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
	private String securityId;  			// "7921619"
	private LocalDate tradeDate; 			// LocalDate.of(2016, 7, 4)
	private String tradeExecType;  			// "New"
	private String traderId;  				// "0109"
	private String origSrcSys; 				// null
	private String sourceFirmCode;  		// "02"
	private String firmAcctIdType;  		// "ACCOUNTMNEMONIC"
	private String tradePriceCcy;  			// "EUR"
	private String buySellInd;  			// "BUY"
	private String securityIdType;  		// "FII"
	private String cptyAcctIdType;  		// "ACCOUNTMNEMONIC"
	private LocalDateTime oceanCreatedTs; 	// LocalDateTime.parse("2017-01-10 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
	private BigDecimal tradeQty; 			// new BigDecimal("2500.000000")
	private BigDecimal settlementPrice; 	// new BigDecimal("47.300000")
	private BigDecimal regTradePrice; 		// new BigDecimal("47.300000")
	private BigDecimal tradePrice; 			// new BigDecimal("100.000000")
	private String tradeType;  				// "Market"
	private String cptyAcctId;  			// "02WB644"
	private String tradeCapacity;  			// "AGENCY"

	public Info() {}

	public Info(String firmAcctId, String tradeSubType, LocalDateTime tradeExecTs, String settlementCcy, LocalDateTime rioTxnTs, String securityId,
			LocalDate tradeDate, String tradeExecType, String traderId, String origSrcSys, String sourceFirmCode, String firmAcctIdType,
			String tradePriceCcy, String buySellInd, String securityIdType, String cptyAcctIdType, LocalDateTime oceanCreatedTs, BigDecimal tradeQty,
			BigDecimal settlementPrice, BigDecimal regTradePrice, BigDecimal tradePrice, String tradeType, String cptyAcctId, String tradeCapacity) {
		super();
		this.firmAcctId = firmAcctId;
		this.tradeSubType = tradeSubType;
		this.tradeExecTs = tradeExecTs;
		this.settlementCcy = settlementCcy;
		this.rioTxnTs = rioTxnTs;
		this.securityId = securityId;
		this.tradeDate = tradeDate;
		this.tradeExecType = tradeExecType;
		this.traderId = traderId;
		this.origSrcSys = origSrcSys;
		this.sourceFirmCode = sourceFirmCode;
		this.firmAcctIdType = firmAcctIdType;
		this.tradePriceCcy = tradePriceCcy;
		this.buySellInd = buySellInd;
		this.securityIdType = securityIdType;
		this.cptyAcctIdType = cptyAcctIdType;
		this.oceanCreatedTs = oceanCreatedTs;
		this.tradeQty = tradeQty;
		this.settlementPrice = settlementPrice;
		this.regTradePrice = regTradePrice;
		this.tradePrice = tradePrice;
		this.tradeType = tradeType;
		this.cptyAcctId = cptyAcctId;
		this.tradeCapacity = tradeCapacity;
	}

	public String getFirmAcctId() {
		return firmAcctId;
	}

	public void setFirmAcctId(String firmAcctId) {
		this.firmAcctId = firmAcctId;
	}

	public String getTradeSubType() {
		return tradeSubType;
	}

	public void setTradeSubType(String tradeSubType) {
		this.tradeSubType = tradeSubType;
	}

	public LocalDateTime getTradeExecTs() {
		return tradeExecTs;
	}

	public void setTradeExecTs(LocalDateTime tradeExecTs) {
		this.tradeExecTs = tradeExecTs;
	}

	public String getSettlementCcy() {
		return settlementCcy;
	}

	public void setSettlementCcy(String settlementCcy) {
		this.settlementCcy = settlementCcy;
	}

	public LocalDateTime getRioTxnTs() {
		return rioTxnTs;
	}

	public void setRioTxnTs(LocalDateTime rioTxnTs) {
		this.rioTxnTs = rioTxnTs;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeExecType() {
		return tradeExecType;
	}

	public void setTradeExecType(String tradeExecType) {
		this.tradeExecType = tradeExecType;
	}

	public String getTraderId() {
		return traderId;
	}

	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	public String getOrigSrcSys() {
		return origSrcSys;
	}

	public void setOrigSrcSys(String origSrcSys) {
		this.origSrcSys = origSrcSys;
	}

	public String getSourceFirmCode() {
		return sourceFirmCode;
	}

	public void setSourceFirmCode(String sourceFirmCode) {
		this.sourceFirmCode = sourceFirmCode;
	}

	public String getFirmAcctIdType() {
		return firmAcctIdType;
	}

	public void setFirmAcctIdType(String firmAcctIdType) {
		this.firmAcctIdType = firmAcctIdType;
	}

	public String getTradePriceCcy() {
		return tradePriceCcy;
	}

	public void setTradePriceCcy(String tradePriceCcy) {
		this.tradePriceCcy = tradePriceCcy;
	}

	public String getBuySellInd() {
		return buySellInd;
	}

	public void setBuySellInd(String buySellInd) {
		this.buySellInd = buySellInd;
	}

	public String getSecurityIdType() {
		return securityIdType;
	}

	public void setSecurityIdType(String securityIdType) {
		this.securityIdType = securityIdType;
	}

	public String getCptyAcctIdType() {
		return cptyAcctIdType;
	}

	public void setCptyAcctIdType(String cptyAcctIdType) {
		this.cptyAcctIdType = cptyAcctIdType;
	}

	public LocalDateTime getOceanCreatedTs() {
		return oceanCreatedTs;
	}

	public void setOceanCreatedTs(LocalDateTime oceanCreatedTs) {
		this.oceanCreatedTs = oceanCreatedTs;
	}

	public BigDecimal getTradeQty() {
		return tradeQty;
	}

	public void setTradeQty(BigDecimal tradeQty) {
		this.tradeQty = tradeQty;
	}

	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public BigDecimal getRegTradePrice() {
		return regTradePrice;
	}

	public void setRegTradePrice(BigDecimal regTradePrice) {
		this.regTradePrice = regTradePrice;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getCptyAcctId() {
		return cptyAcctId;
	}

	public void setCptyAcctId(String cptyAcctId) {
		this.cptyAcctId = cptyAcctId;
	}

	public String getTradeCapacity() {
		return tradeCapacity;
	}

	public void setTradeCapacity(String tradeCapacity) {
		this.tradeCapacity = tradeCapacity;
	}
}
