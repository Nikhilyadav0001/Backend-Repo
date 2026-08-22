package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

public class HQLPaginationApp {

	public static void main(String[] args) {

		Session session = null;
		Query<InsurancePolicy> query=null;
		List<InsurancePolicy> listOfRecords=null;
		
		try {
			session = HibernateUtil.getSession();
			query =session.createQuery("FROM nikhil.bean.InsurancePolicy");
			
			//pagination settings
			//starting from 1st row
			query.setFirstResult(1);
			
			//show only 3 records
			query.setMaxResults(3);
			
			
			
			listOfRecords = query.getResultList();
			listOfRecords.forEach(System.out::println);
 			

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
				
			}
		}
	}
}
