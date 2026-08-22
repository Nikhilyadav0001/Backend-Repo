package nikhil.main;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.Project;
import nikhli.util.HibernateUtil;

public class QBCUpdateApp {
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction =null;
		boolean flag =false;
		long count =0;
		
		try {
			//update project set teamsize = 20 ,location ='gurugram' where cost>35000;
			session = HibernateUtil.getSession();
			transaction =session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<Project> criteriaUpdate = builder.createCriteriaUpdate(Project.class);
			Root<Project> root = criteriaUpdate.from(Project.class);
			
			//update operation
			criteriaUpdate.set(root.get("teamSize"),20)
					      .set(root.get("location"), "gurugram")
					      .where(builder.ge(root.get("cost"), 35000));
			
			
			Query<Integer> query = session.createQuery(criteriaUpdate);
			count = query.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records updated is :: "+count);
			} else {
				transaction.rollback();
				System.out.println("No records found to update");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
