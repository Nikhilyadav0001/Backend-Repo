package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

public class RetriveRecordApp {

	public static void main(String[] args) {
		
		Session session =null;
		InsurancePolicy policy =null;
		try {
			session = HibernateUtil.getSession();
			
			policy = session.get(InsurancePolicy.class, 4l);//geting from db
			System.out.println(policy);
			
			System.out.println("-------------------------------");
			
			policy = session.get(InsurancePolicy.class, 4l);//geting from l1
			System.out.println(policy);
			
			System.out.println("-------------------------------");
			//clearing the l1 cache 
			session.clear();
			
			try {
				Thread.sleep(20000);//20 sec removed from l2 also
			} catch (Exception e) {
				// TODO: handle exception
			}
			policy = session.get(InsurancePolicy.class, 4l);//geting from l2
			System.out.println(policy);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();	
		}

	}

}
