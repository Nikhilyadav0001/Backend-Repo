package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.MoibileCustomer;
import nikhli.util.HibernateUtil;
public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		MoibileCustomer c = null;

		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			int id = 2;
			c = session.get(MoibileCustomer.class, id);
			
			if (c != null) {
				System.out.println(c);
				c.setCallerTune("BOLO TARA RA AR");
				
				//session.saveOrUpdate(c);
				flag =true;
				
				
			} else {
				System.out.println("no record for id"+id);
			}
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
					System.out.println("object iss modified for:"+c.getVersionCount()+"times");
					System.out.println(c);
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
