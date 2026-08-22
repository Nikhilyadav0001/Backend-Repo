package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.Address;
import nikhil.bean.StudentInfo;
import nikhli.util.HibernateUtil;

public class ComponentMappingSelectApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			Query<StudentInfo> qr =session.createQuery("from StudentInfo where address.cityname =:city");
			qr.setParameter("city", "gurugram");
			
			List<StudentInfo> ls = qr.getResultList();
			ls.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
