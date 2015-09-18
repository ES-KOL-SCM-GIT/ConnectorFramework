/**
 * 
 */
package com.connectorframework.rally.discrepancy.service;

import java.util.Date;
import java.util.List;

import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyReport;
import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyType;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType;

/**
 * @author suvonkar.dam
 *
 */
public interface DiscrepancyService {

	/**
	 * Get all the Discrepancy Types
	 * 
	 * @return
	 */
	List<DiscrepancyType> getDiscrepancyTypes();

	/**
	 * Get Discrepancy Type based on discTypeId
	 * 
	 * @param discTypeId
	 * @return
	 * @throws NoSuchDiscrepancyType
	 */
	DiscrepancyType getDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType;

	/**
	 * Delete Discrepancy Type based on discTypeId
	 * 
	 * @param discTypeId
	 */
	void deleteDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType ;

	/**
	 * Save Discrepancy Type
	 * 
	 * @param discrepancyType
	 */
	long saveDiscrepancyType(DiscrepancyType discrepancyType);

	/**
	 * Get all Discrepancy Reports
	 * 
	 * @return
	 */
	List<DiscrepancyReport> getDiscrepancrReports();

	/**
	 * Get Discrepancy Report based on id
	 * 
	 * @param discReportId
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	DiscrepancyReport getDiscrepancyReport(long discReportId) throws NoSuchDiscrepancyReport;

	/**
	 * Get Discrepancy Report based on team name and date
	 * 
	 * @param discReportId
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	List<DiscrepancyReport> getDiscrepancyReport(String teamName, Date date) throws NoSuchDiscrepancyReport;

	/**
	 * Get all Discrepancy Report for a particular date
	 * 
	 * @param date
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	List<DiscrepancyReport> getDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport;

	/**
	 * Get the Discrepancy Report for the Empty team for a perticular date
	 * 
	 * @param date
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	List<DiscrepancyReport> getEmptyTeamDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport;

	/**
	 * Save list of Discrepancy Report
	 * 
	 * @param discrepancyReports
	 */
	void saveDiscrepancyReports(List<DiscrepancyReport> discrepancyReports);

	/**
	 * Save Discrepancy Report
	 * 
	 * @param discrepancyReports
	 */
	long saveDiscrepancyReport(DiscrepancyReport discrepancyReport);

	/**
	 * Delete all Discrepancy Reports for a provided date
	 * 
	 * @param date
	 */
	void deleteDiscrepancyReport(Date date);
}
