package nikhil.main;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

public class QueryCacheApp {

	public static void main(String[] args) {
		
		Session session =null;
		SessionFactory sf =null;
		try {
			session = HibernateUtil.getSession();
			sf = HibernateUtil.getSessionFactory();
			List<InsurancePolicy> ls =null;
			
			@SuppressWarnings("unchecked")
			Query<InsurancePolicy> qr =session.createQuery("from InsurancePolicy");
			
			//enable the l2 cache  and mark region as region1
			qr.setCacheable(true);
			qr.setCacheRegion("region1");
			
			ls = qr.getResultList();//from db
			ls.forEach(System.out::println);
			
			System.out.println("--------------------------------------------");
			session.clear();//to show nothing is in the l1 cache
			
			ls = qr.getResultList();//from l2 cache
			ls.forEach(System.out::println);
			
			Cache cache =sf.getCache();
			cache.evictRegion("region1");//removing the qury cache entity of l2
			
			System.out.println("--------------------------------------------");
			session.clear();//to show nothing is in the l1 cache
			
			ls = qr.getResultList();//from l2 cache
			ls.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();	
		}

	}

}
