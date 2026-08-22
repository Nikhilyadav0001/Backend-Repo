package nikhil.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

//a using b's atm card if canara bank
public class ClientApp2 {
	public static void main(String[] args) {
		
		Session session = null;
		Transaction tr = null;
		boolean flag = false;
		
		try {
			session =HibernateUtil.getSession();
			tr = session.beginTransaction();
			InsurancePolicy ip = session.get(InsurancePolicy.class, 1l);
			System.out.println(ip);
			
			ip.setTenure(16);
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
