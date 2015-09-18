package com.connectorframework.rally.discrepancy.exception;

public class NoSuchDiscrepancyType extends Exception {
	private static final long serialVersionUID = 8439015279501226234L;
	
	private long discTypeId;

	public NoSuchDiscrepancyType(final long discTypeId) {
		super("No such DiscrepancyType [" + discTypeId + "] exists in the database.");
		this.discTypeId = discTypeId;
	}

	public long getDiscTypeId() {
		return discTypeId;
	}
}
