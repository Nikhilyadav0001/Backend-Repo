package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.Employee;
import nikhli.util.HibernateUtil;

public class CollectionMappingSelectApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			Query<Employee> query = session.createQuery("from Employee");
			List<Employee> employees = query.getResultList();
			System.out.println("Total Employees: " + employees.size());
			employees.forEach(employee -> System.out.println(employee));
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
