package com.connectorframework.rally.discrepancy.exception;

public class NoSuchDiscrepancyReport extends Exception {
	private static final long serialVersionUID = 8439015279501226234L;
	
	private String details;

	public NoSuchDiscrepancyReport(final String details) {
		super("No such DiscrepancyReport [" + details + "] exists in the database.");
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
}
