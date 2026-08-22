package nikhil.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.Project;
import nikhli.util.HibernateUtil;

public class QBCMainApp {
	
	public static void main(String[] args) {
		
		Session session = null;
//		try {
//			session = HibernateUtil.getSession();
//			
//			//QBC FOR SELECT QUERY
//			
//			//create a builder object
//			CriteriaBuilder builder =session.getCriteriaBuilder();
//			
//			//Create a CriteriaQuery object
//			CriteriaQuery<Project>cQuery =builder.createQuery(Project.class);
//			
//			//create a root object specifying the entity class
//			//(table name for which records should be selected)
//			Root<Project> root = cQuery.from(Project.class);
//			 
//			//adding root object to cquery object
//			cQuery.select(root);
//			
//			//preparing a query object having cquery
//			Query<Project> query =session.createQuery(cQuery);
//			
//			//execute JPA query object
//			List<Project> list = query.getResultList();
//			list.forEach(System.out::println);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.closeSession(session);
//			HibernateUtil.closeSessionFactory();
//			
//		}
		
//		// QBC :HQL:SQL ->SELECT ... FROM PROJEST_QBC WHERE >= AND <= ORDER BY DECS
//		try {
//			session = HibernateUtil.getSession();
//			
//			CriteriaBuilder builder1 =session.getCriteriaBuilder();
//			CriteriaQuery<Project>cquery =builder1.createQuery(Project.class);
//			
//			Root<Project> root2 = cquery.from(Project.class);
//			cquery.select(root2);
//			
//			//creating the parameter
//			ParameterExpression <Long> param1 =builder1.parameter(Long.class);
//			ParameterExpression <Long> param2 =builder1.parameter(Long.class);
//			
//			//creating the conditions object
//			Predicate p1 =builder1.ge(root2.get("projId"), param1);//projId>=param1
//			Predicate p2 =builder1.le(root2.get("projId"), param2);//projId<=param1
//			
//			//creating final condition for the where clasue
//			Predicate finalCond = builder1.and(p1,p2);
//			cquery.where(finalCond);//SELECT ... FROM PROJEST_QBC WHERE projId>=param1 AND projid<=param2 
//			
//			//preparing the order
//			Order order = builder1.desc(root2.get("projName"));
//			
//			//added order by clause
//			cquery.orderBy(order);
//			
//			
//			Query<Project> query =session.createQuery(cquery);
//			query.setParameter(param1, 1l);
//			query.setParameter(param2, 3l);
//			List<Project> list = query.getResultList();
//			list.forEach(System.out::println);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.closeSession(session);
//			HibernateUtil.closeSessionFactory();
//			
//		}
		
		//select ... from project where location in ('gurugram','maneser','jaipur') order by projname asc
		
//		try {
//			session = HibernateUtil.getSession();
//			
//			CriteriaBuilder builder2 =session.getCriteriaBuilder();
//			CriteriaQuery<Project>cquery1 =builder2.createQuery(Project.class);
//			
//			Root<Project> root3 = cquery1.from(Project.class);
//			cquery1.select(root3).where(root3.get("location").in("gurgram", "maneser","jaipur")) 
//			.orderBy(builder2.asc(root3.get("projName")));
//			
//			
//			Query<Project> query =session.createQuery(cquery1);
//			List<Project> list = query.getResultList();
//			list.forEach(System.out::println);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.closeSession(session);
//			HibernateUtil.closeSessionFactory();
//			
//		}

		// select ... from project where teamsize between (10,20) and projName like 'j%'
		
		try {
			session = HibernateUtil.getSession();
			
			CriteriaBuilder builder3 =session.getCriteriaBuilder();
			CriteriaQuery<Project>cquery2 =builder3.createQuery(Project.class);
			
			Root<Project> root4 = cquery2.from(Project.class);
			
			cquery2.select(root4)
					.where(builder3
							.and(builder3.between(root4.get("teamSize"), 10, 20),
								 builder3.like(root4.get("projName"), "j%")));
			
			
			Query<Project> query =session.createQuery(cquery2);
			List<Project> list = query.getResultList();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}
}
