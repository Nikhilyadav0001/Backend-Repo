package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.Student;
import nikhli.util.HibernateUtil;

public class SynchronizationApp {

	public static void main(String[] args) {
		Session session = null;
		Student student = null;
		
		try {
			
			session = HibernateUtil.getSession();
			
			student = session.get(Student.class, 11);
			System.out.println("Before modification.....");
			System.out.println("Record with the id value :: " + student);
			
			//appication us in the pausing state
			System.in.read();
			
			//sysnchronization  established b/w record to java object
			session.refresh(student);
			
			System.out.println("After modification in the db");
			System.out.println("record with the id value:"+student);
			
			
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
