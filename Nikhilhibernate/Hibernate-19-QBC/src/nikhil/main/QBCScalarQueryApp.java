package nikhil.main;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.Project;
import nikhli.util.HibernateUtil;

public class QBCScalarQueryApp {
	
	public static void main(String[] args) {
		
		Session session = null;
		
		//select projName form project where cost between(?,?) order by projName asc

		
//		try {
//			session = HibernateUtil.getSession();
//			
//			CriteriaBuilder builder =session.getCriteriaBuilder();
//			CriteriaQuery<String>cquery =builder.createQuery(String.class);
//			
//			Root<Project> root = cquery.from(Project.class);
//			
//			cquery.multiselect(root.get("projName"))
//					.where(builder.between(root.get("cost"), 25000, 40000))
//						.orderBy(builder.asc(root.get("projName")));
//			
//			Query <String> qr = session.createQuery(cquery);
//			List <String>l1 =qr.getResultList();
//			l1.forEach(System.out::println);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.closeSession(session);
//			HibernateUtil.closeSessionFactory();
//			
//		}

		
		//select count(*) from project
		
		try {
			session = HibernateUtil.getSession();
			
			CriteriaBuilder builder =session.getCriteriaBuilder();
			CriteriaQuery<Long>cquery =builder.createQuery(Long.class);
			Root<Project> root = cquery.from(Project.class);
			
			cquery.multiselect(builder.count(root.get("projId")));
			
			
			Query <Long> qr = session.createQuery(cquery);
			Optional<Long> op=qr.uniqueResultOptional();
			long count = op.isPresent()? op.get() : 0;
			System.out.println("no of records avalable is:"+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}
}
