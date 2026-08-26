package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.query.Query;

import nikhil.bean.CardPayment;
import nikhil.bean.ChequePayment;
import nikhil.bean.Payment;
import nikhli.util.HibernateUtil;

public class TBCSelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			Query<Payment> query1 = session.createQuery("from Payment");
			List<Payment> payments = query1.getResultList();
			payments.forEach(System.out::println);

			System.in.read();
			
			
			// selecting child classes
			Query<CardPayment> query2 = session.createQuery("from CardPayment");
			List<CardPayment> card = query2.getResultList();
			card.forEach(System.out::println);

			System.in.read();
			//always override to string include parent class amount in it
			
			// selecting child classes
			Query<ChequePayment> query3 = session.createQuery("from ChequePayment");
			List<ChequePayment> cheque = query3.getResultList();
			cheque.forEach(System.out::println);

			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}	
	}
}
