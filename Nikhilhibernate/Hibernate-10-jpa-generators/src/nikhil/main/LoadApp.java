package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.PersonInfo;

import nikhli.util.HibernateUtil;
public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		int id = 2;
		try {
			session = HibernateUtil.getSession();

			PersonInfo person =session.get(PersonInfo.class, id);
			if (person != null) {
				System.out.println(person);
			} else {
				System.out.println("no records for this id"+id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
				
			}
		}
	}
}
