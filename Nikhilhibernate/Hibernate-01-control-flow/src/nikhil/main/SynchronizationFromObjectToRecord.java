package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Student;
import nikhli.util.HibernateUtil;

public class SynchronizationFromObjectToRecord {

	public static void main(String[] args) {
		Session session = null;
		Student student = null;
		boolean flag = false;
		Transaction transaction = null;
		int id = 11;
		try {
			session = HibernateUtil.getSession();
			
			// Getting the record in the form of student object(session)
			student = session.get(Student.class, id);
			System.out.println("Before modification :: " + student);
			//application in pausing state
			System.in.read();
			
			if (student != null) {
				transaction = session.beginTransaction();

				// modifying the data
				student.setSname("sheer");
				flag = true;

				} else {
					System.out.println("Record not found for the id :: " + id);
				}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("After modification :: " + student);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}

}
