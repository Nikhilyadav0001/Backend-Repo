package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.Customer;
import nikhli.util.HibernateUtil;
public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		String id = "c001";
		try {
			session = HibernateUtil.getSession();

			Customer customer = session.get(Customer.class, id);
			
			System.out.println(customer);
			

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
