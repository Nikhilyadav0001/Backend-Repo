package nikhil.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.BankAccount;
import nikhli.util.HibernateUtil;

public class FilterApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		try {
			session=HibernateUtil.getSession();
			
			//enable the filter 
			Filter f =session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			f.setParameter("param1", "blocked");
			f.setParameter("param2", "closed");

			//hql
			Query<BankAccount>qr =session.createQuery("from BankAccount where balance>=:amt");
			
			qr.setParameter("amt", 15000.f);
			List<BankAccount> acc =qr.getResultList();
			acc.forEach(System.out::println);
			
			System.out.println("******************************");
			
			//diable the filter
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			Query<BankAccount>qr1 =session.createQuery("from BankAccount where balance>=:amt");
			qr.setParameter("amt", 15000.f);
			List<BankAccount> acc1 =qr.getResultList();
			acc1.forEach(System.out::println);
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
