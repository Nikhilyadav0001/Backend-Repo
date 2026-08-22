package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.BankAccount;
import nikhli.util.HibernateUtil;
public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		BankAccount acc = null;
		long id = 1;
		
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			acc =session.get(BankAccount.class, id);
						
			if (acc != null) {
				transaction = session.beginTransaction();
				
				acc.setBalance(acc.getBalance()+10000l);
				
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
					System.out.println(acc);
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
