package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Address;
import nikhil.bean.StudentInfo;
import nikhli.util.HibernateUtil;

public class ComponentMappingInsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction trans =null;
		boolean flag =false;
		
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			
			Address adr =new Address("121","xyzstreet","hayatpur","bangaluru","ind", 122505l);
			StudentInfo std = new StudentInfo("nikhil",19.5f,adr);
			session.save(std);
			
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag) {
				trans.commit();
				System.out.println("record saved to db");
			} else {
				trans.rollback();
				System.out.println("record not saved to db");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
