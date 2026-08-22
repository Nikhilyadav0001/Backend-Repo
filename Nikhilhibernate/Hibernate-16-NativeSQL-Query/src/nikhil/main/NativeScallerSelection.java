package nikhil.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import nikhil.bean.InsurancePolicy;
import nikhil.util.HibernateUtil;

public class NativeScallerSelection {

    public static void main(String[] args) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();
            NativeQuery<Object[]> query =
                    session.createNativeQuery(
                            "SELECT policyName, policyType FROM insurancepolicy");

            List<Object[]> results = query.getResultList();
            
            results.forEach(objects->{
            	for (Object data : objects) {
            		System.out.print(data + " ");
				}
            	System.out.println();
            });;
            System.out.println("****************");
            
            NativeQuery<String> query1 =
                    session.createNativeQuery(
                            "SELECT company FROM insurancepolicy");

            List<String> companies = query1.getResultList();
            companies.forEach(System.out::println);
            

        } finally {
            if (session != null)
                session.close();
            HibernateUtil.closeSessionFactory();
        }
    }
}
