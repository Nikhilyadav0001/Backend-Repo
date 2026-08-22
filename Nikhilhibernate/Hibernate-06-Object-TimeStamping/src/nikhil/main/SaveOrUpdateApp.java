package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.BankAccount;
import nikhli.util.HibernateUtil;
public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		BankAccount  account =null;
		Boolean flag = false;
	
		
		//logic for hgibernate working
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			account = new BankAccount ();
			account.setBalance(52255.44);
			account.setHolderName("nikhil");
			account.setType("saving");
			
			session.save(account);
			
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
					System.out.println(account);
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
