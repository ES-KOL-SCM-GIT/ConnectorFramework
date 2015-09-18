package com.connectorframework.rally.discrepancy.hibernate.util;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType;


public class TestHibernate {
	@Transactional
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		

		DiscrepancyType user = new DiscrepancyType();

		user.setId(Long.valueOf(1));

		
		for(int i = 0 ; i < 10 ; i++){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			DiscrepancyReport report = new DiscrepancyReport(user, "formatedId" ,  "artifactName", "artifactRef", null, "artifatOwner", "productOwner", new DateTime().toDate());
			session.save(report);
			session.getTransaction().commit();
			session.close();
		}
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(DiscrepancyReport.class).add(Restrictions.eq("id", 52));
		
		DiscrepancyReport report = (DiscrepancyReport) criteria.list().get(0);
		
		System.out.println(report);*/
	}
}
