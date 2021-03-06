package com.citi.reghub.rds.simulator.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "entities_rds")
public class Entity {
	@Id
	@Indexed
	@Field("id")
	private String regHubId;			// reghub generated unique id for each message
	private Status status;				// reghub reporting status e.g. REPORTABLE, NON_REPORTABLE, EXCEPTION, PENDING, REPORTED, REJECTED 
	private String stream;				// reporting stream (always 4 char) e.g. M2TR, M2PR, M2PO
	private String flow;				// reporting asset class / product (always 3 char) e.g. CEQ (cash equities), CFI (cash fixed income)
	private String sourceUId;			// unique id for a message received from source e.g. OceanId for transaction reporting
	private String sourceId;			// trade/quote/order id
	private String sourceVersion;		// trade/quote/order version
	private SourceStatus sourceStatus;	// always normalised to NEW, AMEND and CANCEL
	private String sourceSystem;		// upstream source system generated the message e.g. TPS, PRIMO
	private String regReportingRef;		// used as reporting id for trade/quote/order/transaction e.g. stream + flow + sourceId
	private LocalDateTime receivedTs;	// Time when entity is received in reghub
	private LocalDateTime publishedTs;	// trade activity time .i.r when this trade version was created
	private LocalDateTime executionTs;	// trade origination time
	private LocalDateTime lastUpdatedTs; // timestamp of last activity in reghub, classical updated timestamp for reghub
	private boolean isRDSEligible;

	private List<String> reasonCodes;
	private Info info;

	public Entity(Status status, String stream, String flow, String sourceUId, String sourceId,
			String sourceVersion, SourceStatus sourceStatus, String sourceSystem, String regReportingRef, LocalDateTime receivedTs,
			LocalDateTime publishedTs, LocalDateTime executionTs, LocalDateTime lastUpdatedTs, List<String> reasonCodes, Info info) {
		super();
		this.status = status;
		this.stream = stream;
		this.flow = flow;
		this.sourceUId = sourceUId;
		this.sourceId = sourceId;
		this.sourceVersion = sourceVersion;
		this.sourceStatus = sourceStatus;
		this.sourceSystem = sourceSystem;
		this.regReportingRef = regReportingRef;
		this.receivedTs = receivedTs;
		this.publishedTs = publishedTs;
		this.executionTs = executionTs;
		this.lastUpdatedTs = lastUpdatedTs;
		this.reasonCodes = reasonCodes;
		this.info = info;
	}

	public String getRegHubId() {
		return regHubId;
	}
	public void setRegHubId(String regHubId) {
		this.regHubId = regHubId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getFlow() {
		return flow;
	}
	public void setFlow(String flow) {
		this.flow = flow;
	}
	public String getSourceUId() {
		return sourceUId;
	}
	public void setSourceUId(String sourceUId) {
		this.sourceUId = sourceUId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceVersion() {
		return sourceVersion;
	}
	public void setSourceVersion(String sourceVersion) {
		this.sourceVersion = sourceVersion;
	}
	public SourceStatus getSourceStatus() {
		return sourceStatus;
	}
	public void setSourceStatus(SourceStatus sourceStatus) {
		this.sourceStatus = sourceStatus;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getRegReportingRef() {
		return regReportingRef;
	}
	public void setRegReportingRef(String regReportingRef) {
		this.regReportingRef = regReportingRef;
	}
	public LocalDateTime getReceivedTs() {
		return receivedTs;
	}
	public void setReceivedTs(LocalDateTime receivedTs) {
		this.receivedTs = receivedTs;
	}
	public LocalDateTime getPublishedTs() {
		return publishedTs;
	}
	public void setPublishedTs(LocalDateTime publishedTs) {
		this.publishedTs = publishedTs;
	}
	public LocalDateTime getExecutionTs() {
		return executionTs;
	}
	public void setExecutionTs(LocalDateTime executionTs) {
		this.executionTs = executionTs;
	}
	public LocalDateTime getLastUpdatedTs() {
		return lastUpdatedTs;
	}
	public void setLastUpdatedTs(LocalDateTime lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}
	public List<String> getReasonCodes() {
		return reasonCodes;
	}
	public void setReasonCodes(List<String> reasonCodes) {
		this.reasonCodes = reasonCodes;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public boolean isRDSEligible() {
		return isRDSEligible;
	}
	public void setRDSEligible(boolean isRDSEligible) {
		this.isRDSEligible = isRDSEligible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regHubId == null) ? 0 : regHubId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (regHubId == null) {
			if (other.regHubId != null)
				return false;
		} else if (!regHubId.equals(other.regHubId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Entity [regHubId=" + regHubId + ", status=" + status + ", stream=" + stream + ", flow=" + flow
				+ ", sourceUId=" + sourceUId + ", sourceId=" + sourceId + ", sourceVersion=" + sourceVersion
				+ ", sourceStatus=" + sourceStatus + ", sourceSystem=" + sourceSystem + ", regReportingRef="
				+ regReportingRef + ", receivedTs=" + receivedTs + ", publishedTs=" + publishedTs + ", executionTs="
				+ executionTs + ", lastUpdatedTs=" + lastUpdatedTs + ", isRDSEligible=" + isRDSEligible + ", reasonCodes=" + reasonCodes + ", info=" + info
				+ "]";
	}
}