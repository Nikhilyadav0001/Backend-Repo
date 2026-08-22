package nikhil.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import nikhil.util.HibernateUtil;

public class NativeSQLInsertQueryAppApp {

	public static void main(String[] args) {
		
		
		Session session = null;
		Transaction trans = null;
		boolean flag =false;
		int count = 0;
		try {
			//native sql
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			
			NativeQuery nqr=session.createSQLQuery("insert into insurancepolicy(company, policyName, policyType, tenure) values(:comp,:pname,:ptype,:tenure)");
			
			nqr.setParameter("comp", "sbi");
			nqr.setParameter("pname", "jivansathi");
			nqr.setParameter("ptype", "daily");
			nqr.setParameter("tenure", 15);

			
			
			//running the query
			count =nqr.executeUpdate();
			flag=true;
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				if (trans != null) {
					if (flag) {
						trans.commit();
						System.out.println("no of records inserted are:"+count);
					} else {
						trans.rollback();
						System.out.println("some problen in the insersion");
					}
				}
			
			
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
				
			}
		}

	}

}
