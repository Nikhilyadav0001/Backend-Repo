package nikhil.main;

import java.time.LocalDate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.CardPayment;
import nikhil.bean.ChequePayment;
import nikhli.util.HibernateUtil;

public class TBCCInsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction trans =null;
		boolean flag =false;
		
	
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			
			
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setCardNo(54844L);
			cardPayment.setCardType("credit");
			cardPayment.setPaymentGateWay("visa");
			cardPayment.setAmount(50000.0f);

			session.save(cardPayment);

			ChequePayment chequePayment = new ChequePayment();
			chequePayment.setAmount(51200.0f);
			chequePayment.setChequeNo(1605L);
			chequePayment.setChequeType("all");
			chequePayment.setExpriyDate(LocalDate.of(2025, 05, 25));

			session.save(chequePayment);


			
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
