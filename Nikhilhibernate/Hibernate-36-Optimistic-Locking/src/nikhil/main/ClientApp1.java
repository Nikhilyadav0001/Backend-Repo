package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;


//b useing gpay linked to canra bank
public class ClientApp1 {
	public static void main(String[] args) {
		
		Session session = null;
		Transaction tr = null;
		boolean flag = false;
		try {
			session =HibernateUtil.getSession();
			tr = session.beginTransaction();
			InsurancePolicy ip = session.get(InsurancePolicy.class, 1l);
			System.out.println(ip);
			
			Thread.sleep(10000);//sleep for 10 sec
			
			//contining the exicution
			ip.setTenure(6);
			flag=true;

			
		} catch (HibernateException he) {
			he.printStackTrace();
			flag =false;
		} catch (Exception e) {
			e.printStackTrace();
			flag =false;
		} finally {
			if (flag) {
				tr.commit();
				System.out.println("object modified");
			} else {
				tr.rollback();
				System.out.println("object modification failed");
			}
		}
	}
}
