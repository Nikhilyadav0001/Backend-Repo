package nikhil.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;

import nikhil.bean.InsurancePolicy;
import nikhil.util.HibernateUtil;

public class NativeSQLSelectApp {

    public static void main(String[] args) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();
            //native with entity maping
            NativeQuery<InsurancePolicy> query =
                    session.createNativeQuery(
                            "SELECT * FROM insurancepolicy " +
                            "WHERE tenure >= :min AND tenure <= :max",
                            InsurancePolicy.class);

            query.setParameter("min", 10);
            query.setParameter("max", 25);

            List<InsurancePolicy> list = query.getResultList();

            list.forEach(System.out::println);
            
            System.out.println("***********************");
            //without mappping
            NativeQuery<Object[]> query1 =
                    session.createNativeQuery(
                            "SELECT * FROM insurancepolicy " +
                            "WHERE tenure >= :min AND tenure <= :max");

            query1.setParameter("min", 10);
            query1.setParameter("max", 25);

            List<Object[]> results = query1.getResultList();

            results.forEach(objects->{
            	for (Object data : objects) {
            		System.out.print(data + " ");
				}
            	System.out.println();
            });

        } finally {
            if (session != null)
                session.close();
            HibernateUtil.closeSessionFactory();
        }
    }
}
