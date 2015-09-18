/**
 * 
 */
package com.connectorframework.rally.discrepancy.service;

import java.util.Date;
import java.util.List;

import com.connectorframework.rally.discrepancy.dao.DiscrepancyDAO;
import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyReport;
import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyType;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType;

/**
 * @author suvonkar.dam
 *
 */
public class DiscrepancyServiceImpl implements DiscrepancyService {
	
	DiscrepancyDAO discrepancyDAO = new DiscrepancyDAO();
	
	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancyTypes()
	 */
	@Override
	public List<DiscrepancyType> getDiscrepancyTypes() {
		return discrepancyDAO.getDiscrepancyTypes();
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancyType(long)
	 */
	@Override
	public DiscrepancyType getDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType {
		return discrepancyDAO.getDiscrepancyType(discTypeId);
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#deleteDiscrepancyType(long)
	 */
	@Override
	public void deleteDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType {
		discrepancyDAO.deleteDiscrepancyType(discTypeId);

	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#saveDiscrepancyType(com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType)
	 */
	@Override
	public long saveDiscrepancyType(DiscrepancyType discrepancyType) {
		return discrepancyDAO.saveDiscrepancyType(discrepancyType);

	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancrReports()
	 */
	@Override
	public List<DiscrepancyReport> getDiscrepancrReports() {
		return discrepancyDAO.getDiscrepancrReports();
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancyReport(long)
	 */
	@Override
	public DiscrepancyReport getDiscrepancyReport(long discReportId) throws NoSuchDiscrepancyReport {
		return discrepancyDAO.getDiscrepancyReport(discReportId);
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancyReport(java.lang.String, java.util.Date)
	 */
	@Override
	public List<DiscrepancyReport> getDiscrepancyReport(String teamName, Date date) throws NoSuchDiscrepancyReport {
		return discrepancyDAO.getDiscrepancyReport(teamName, date);
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getDiscrepancyReport(java.util.Date)
	 */
	@Override
	public List<DiscrepancyReport> getDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport {
		return discrepancyDAO.getDiscrepancyReport(date);
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#getEmptyTeamDiscrepancyReport(java.util.Date)
	 */
	@Override
	public List<DiscrepancyReport> getEmptyTeamDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport {
		return discrepancyDAO.getEmptyTeamDiscrepancyReport(date);
	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#saveDiscrepancyReports(java.util.List)
	 */
	@Override
	public void saveDiscrepancyReports(List<DiscrepancyReport> discrepancyReports) {
		discrepancyDAO.saveDiscrepancyReports(discrepancyReports);

	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#saveDiscrepancyReport(com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport)
	 */
	@Override
	public long saveDiscrepancyReport(DiscrepancyReport discrepancyReport) {
		return discrepancyDAO.saveDiscrepancyReport(discrepancyReport);

	}

	/* (non-Javadoc)
	 * @see com.connectorframework.rally.discrepancy.service.DiscrepancyService#deleteDiscrepancyReport(java.util.Date)
	 */
	@Override
	public void deleteDiscrepancyReport(Date date) {
		discrepancyDAO.deleteDiscrepancyReport(date);

	}

}
