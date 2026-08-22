package nikhil.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Employee;
import nikhli.util.HibernateUtil;

public class CollectionMappingInsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction trans =null;
		boolean flag =false;
		
		Employee employee = null;
		
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			
			employee = new Employee("Nikhil","Hayatpur",
					List.of("sher","pal","nagpal"),
					Set.of(7011752235l,9810667877l,9729940056l),
					Map.of("sbi",254452l,"HDFC",544848l,"Axis",468464l));
			
			session.save(employee);
			
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
