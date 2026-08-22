package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Query<InsurancePolicy> query=null;
		List<InsurancePolicy> listOfRecords=null;
		
		try {
			session = HibernateUtil.getSession();
			query =session.createQuery("FROM nikhil.bean.InsurancePolicy");
			
			listOfRecords =query.getResultList();
			
			//retiriving using foreach and lambda expression
			listOfRecords.forEach(policy -> System.out.println(policy));
			
			System.out.println();
			//retiriving using foreach and method refrence
			listOfRecords.forEach(System.out::println);
			
			System.out.println("*********************************");
			
			System.out.println("working with Named parameter....");
			query =session.createQuery("FROM nikhil.bean.InsurancePolicy WHERE company IN (:org1,:org2)");
			
			//set the named parameter value
			query.setParameter("org1", "lic");
			query.setParameter("org2", "govt");
			
			//exicute and retrive the records 
			listOfRecords =query.getResultList();
			//print the results
			listOfRecords.forEach(policy -> System.out.println(policy));
			
 			

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
