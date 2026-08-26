package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Project;
import nikhli.util.HibernateUtil;


public class SoftDeletionApp {


	public static void main(String[] args) {
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			
			session= HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Project project=new Project();
			project.setProjId(5l);
			session.delete(project);
			flag=true;
					
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if(flag=true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
			session.close();
			
		}

	}

}


