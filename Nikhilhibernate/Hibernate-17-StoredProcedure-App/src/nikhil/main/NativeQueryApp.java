package nikhil.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import nikhil.bean.Products;
import nikhli.util.HibernateUtil;

public class NativeQueryApp {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();

            NativeQuery<Products> query =
                    session.createSQLQuery("CALL GET_PRODUCT_DETAILS_BY_NAME(:p1, :p2)");
            
            query.addEntity(Products.class);
            query.setParameter("p1", "milk");
            query.setParameter("p2", "egg");

            List<Products> list = query.getResultList();
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
            HibernateUtil.closeSessionFactory();
        }
    }
}
