package nikhil.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.PersonInfo;

import nikhli.util.HibernateUtil;
public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			PersonInfo info = new PersonInfo();
			info.setPaddr("rewari");
			info.setPname("sachin");
			//yesr 1900+ month1-12 date 1-31 hours 0-23 minutes 0-59 
			info.setDob(LocalDateTime.of(2005, 5, 03, 17, 30));
			info.setDoj(LocalTime.of(1, 30, 55));
			info.setDom(LocalDate.now());
			session.saveOrUpdate(info);
			
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
