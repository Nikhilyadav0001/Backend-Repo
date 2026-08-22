package nikhil.main;



import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import nikhil.bean.Student;
import nikhli.util.HibernateUtil;


public class SavePersistApp {

	public static void main(String[] args) {
		Transaction transaction =null;
		Session session = null;
		boolean flag =false;
		
		try {
			session = HibernateUtil.getSession();
			if (session != null) 
				transaction = session.beginTransaction();
			if (session != null) {
				
				Student std = new Student();
				std.setSname("sheer");
				std.setSage(20);
				std.setSaddress("hayatpur");
				
				session.persist(std);//can also use save -insert query ::refing to mapping info
				flag =true;
				
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			
			try{
				if (flag) {
				System.in.read();
				transaction.commit();
				}else {
				transaction.rollback();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			if (session != null) {
				session.close();
			}
			
		}
		
	}

}
