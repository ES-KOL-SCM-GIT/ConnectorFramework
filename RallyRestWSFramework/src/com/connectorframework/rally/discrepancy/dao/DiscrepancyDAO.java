package com.connectorframework.rally.discrepancy.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyReport;
import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyType;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType;
import com.connectorframework.rally.discrepancy.hibernate.util.HibernateUtil;

public class DiscrepancyDAO {

	final static Logger LOGGER = Logger.getLogger(DiscrepancyDAO.class);

	/**
	 * Get all the Discrepancy Types
	 * 
	 * @return
	 */
	public List<DiscrepancyType> getDiscrepancyTypes() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called...");
		}
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			
			return session.createCriteria(DiscrepancyType.class).list();
		}finally{
			if(session != null){
				session.close();
			}
		}
			
	}

	/**
	 * Get Discrepancy Type based on discTypeId
	 * 
	 * @param discTypeId
	 * @return
	 * @throws NoSuchDiscrepancyType
	 */
	public DiscrepancyType getDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discTypeId : " + discTypeId);
		}
		
		Validate.notNull(discTypeId);

		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DiscrepancyType.class).add(Restrictions.eq("id", discTypeId));
	
			if (criteria.list().size() != 0) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Found DiscrepancyType with discTypeId : " + discTypeId
							+ " and size of the DiscrepancyType list : " + criteria.list().size());
				}
	
				return (DiscrepancyType) criteria.list().get(0);
			} else {
				LOGGER.error("No Such DiscrepancyType available with discTypeId : " + discTypeId);
	
				throw new NoSuchDiscrepancyType(discTypeId);
			}
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Delete Discrepancy Type based on discTypeId
	 * 
	 * @param discTypeId
	 * @throws NoSuchDiscrepancyType 
	 */
	public void deleteDiscrepancyType(long discTypeId) throws NoSuchDiscrepancyType {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discTypeId : " + discTypeId);
		}
		
		Validate.notNull(discTypeId);

		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(DiscrepancyType.class).add(Restrictions.eq("id", discTypeId));

			if(criteria.list().isEmpty()){
				throw new NoSuchDiscrepancyType(discTypeId);
			}else{
				session.delete(criteria.list().get(0));
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			LOGGER.error("Exception ocured to execute method with discTypeId : " + discTypeId, e);
			tx.rollback();
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Save Discrepancy Type
	 * 
	 * @param discrepancyType
	 */
	public long saveDiscrepancyType(DiscrepancyType discrepancyType) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discrepancyType : " + discrepancyType);
		}
		
		Validate.notNull(discrepancyType);
		
		long saveDiscrepancyTypeId = -1;

		Session session = null;
		Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(discrepancyType);

			tx.commit();
			
			saveDiscrepancyTypeId = discrepancyType.getId();

		} catch (RuntimeException e) {
			LOGGER.error("Exception ocured to execute method with discrepancyType : " + discrepancyType , e);
			tx.rollback();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
		return saveDiscrepancyTypeId;
	}

	/**
	 * Get all Discrepancy Reports
	 * 
	 * @return
	 */
	public List<DiscrepancyReport> getDiscrepancrReports() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called...");
		}
		
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createCriteria(DiscrepancyReport.class).list();
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Get Discrepancy Report based on id
	 * 
	 * @param discReportId
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	public DiscrepancyReport getDiscrepancyReport(long discReportId) throws NoSuchDiscrepancyReport {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discReportId : " + discReportId);
		}
		
		Validate.notNull(discReportId);

		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DiscrepancyReport.class).add(Restrictions.eq("id", discReportId));
	
			if (criteria.list().size() != 0) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Found DiscrepancyReport with discReportId : " + discReportId
							+ " and size of the DiscrepancyType list : " + criteria.list().size());
				}
	
				return (DiscrepancyReport) criteria.list().get(0);
			} else {
				LOGGER.error("No Such DiscrepancyReport available with discReportId : " + discReportId);
	
				throw new NoSuchDiscrepancyReport(String.valueOf(discReportId));
			}
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Get Discrepancy Report based on team name and date
	 * 
	 * @param discReportId
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	public List<DiscrepancyReport> getDiscrepancyReport(String teamName, Date date) throws NoSuchDiscrepancyReport {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with teamName : " + teamName + " and date : " + date);
		}
		
		Validate.notNull(teamName);
		Validate.notNull(date);
		
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(DiscrepancyReport.class)
					.add(Restrictions.eq("teamName", teamName))
					.add(Restrictions.eq("date", date))
					.addOrder(Order.asc("discType"));
	
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Found Discrepancy Report with teamName : " + teamName + " and date : " + date
						+ " and size of the DiscrepancyType list : " + criteria.list().size());
			}

			return criteria.list();
			
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Get all Discrepancy Report for a particular date
	 * 
	 * @param date
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	public List<DiscrepancyReport> getDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with date : " + date);
		}
		
		Validate.notNull(date);
		
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(DiscrepancyReport.class).add(Restrictions.eq("date", date))
								.addOrder(Order.asc("teamName"))
								.addOrder(Order.asc("discType"))
								.addOrder(Order.asc("productOwner"));
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Found DiscrepancyReport with date : " + date + " and size of the DiscrepancyType list : "
						+ criteria.list().size());
			}

			return criteria.list();
			
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Get the Discrepancy Report for the Empty team for a perticular date
	 * 
	 * @param date
	 * @return
	 * @throws NoSuchDiscrepancyReport
	 */
	public List<DiscrepancyReport> getEmptyTeamDiscrepancyReport(Date date) throws NoSuchDiscrepancyReport {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with date : " + date);
		}
		
		Validate.notNull(date);
		
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(DiscrepancyReport.class)
					.add(Restrictions.or(Restrictions.eq("teamName", ""), Restrictions.isNull("teamName")))
					.add(Restrictions.eq("date", date))
					.addOrder(Order.asc("discType"))
					.addOrder(Order.asc("productOwner"));
	
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Found DiscrepancyReport with empty team and date : " + date
						+ ", size of the DiscrepancyType list : " + criteria.list().size());
			}

			return criteria.list();
			
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Save list of Discrepancy Report
	 * 
	 * @param discrepancyReports
	 */
	public void saveDiscrepancyReports(List<DiscrepancyReport> discrepancyReports) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discrepancyReports : " + discrepancyReports);
		}
		
		Validate.notNull(discrepancyReports);
		Validate.notEmpty(discrepancyReports);
		
		saveAllDiscrepancyReports(discrepancyReports);
	}

	/**
	 * Save the list of Discrepancy Report in a batch
	 * @param discrepancyReports
	 */
	private void saveAllDiscrepancyReports(List<DiscrepancyReport> discrepancyReports) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			int count = 0;
			for (DiscrepancyReport discrepancyReport : discrepancyReports) {
				count++;
				session.save(discrepancyReport);
				if (count % 50 == 0) { // 50, same as the JDBC batch size
					// flush a batch of inserts and release memory:
					session.flush();
					session.clear();
				}
			}
			tx.commit();

		} catch (RuntimeException e) {
			LOGGER.error("Exception ocured to execute method.", e);
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Save Discrepancy Report
	 * 
	 * @param discrepancyReports
	 */
	public long saveDiscrepancyReport(DiscrepancyReport discrepancyReport) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with discrepancyReport : " + discrepancyReport);
		}
		
		Validate.notNull(discrepancyReport);

		long saveDiscrepancyTypeId = -1;
		Session session = null;
		Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			tx = session.beginTransaction();
			
			session.save(discrepancyReport);

			tx.commit();
			
			saveDiscrepancyTypeId = discrepancyReport.getId();

		} catch (RuntimeException e) {
			LOGGER.error("Exception ocured to execute method with discrepancyReport : " + discrepancyReport , e);
			tx.rollback();
		}finally{
			if (session != null) {
				session.close();
			}
		}
		return saveDiscrepancyTypeId;
	}

	/**
	 * Delete all Discrepancy Reports for a provided date
	 * 
	 * @param date
	 */
	public void deleteDiscrepancyReport(Date date) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Method called with date : " + date);
		}
		
		Validate.notNull(date);

		Session session = null;
		Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			tx = session.beginTransaction();
			
			DiscrepancyReport discrepancyReport = (DiscrepancyReport) session.createCriteria(DiscrepancyReport.class)
					.add(Restrictions.eq("date", date));

			session.delete(discrepancyReport);

			tx.commit();
		} catch (RuntimeException e) {
			LOGGER.error("Exception ocured to execute method with date : " + date , e);
			tx.rollback();
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}
	
	

}
