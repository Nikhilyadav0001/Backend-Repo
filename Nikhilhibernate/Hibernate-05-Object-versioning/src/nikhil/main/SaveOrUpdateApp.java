package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.MoibileCustomer;
import nikhli.util.HibernateUtil;
public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;
	
		
		//logic for hgibernate working
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			MoibileCustomer c = new MoibileCustomer();
			c.setName("SACHIN");
			c.setCallerTune("yasu di bale bale");
			c.setMobileNo(7011752235L);
			
			session.saveOrUpdate(c);
			
			
			
		
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				HibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
