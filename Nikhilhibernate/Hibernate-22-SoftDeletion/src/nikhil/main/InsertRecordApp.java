package nikhil.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.BankAccount;
import nikhli.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		
		Session session =HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setBalance(35000.f);
		account.setHolderName("nikhil");
		account.setStatus("active");
		
		session.save(account);
		trans.commit();
		
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();

	}

}
