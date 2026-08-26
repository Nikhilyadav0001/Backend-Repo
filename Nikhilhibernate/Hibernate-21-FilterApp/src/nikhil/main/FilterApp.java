package nikhil.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.BankAccount;
import nikhli.util.HibernateUtil;

public class FilterApp {

    public static void main(String[] args) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();

            // Enable Filter
            Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
            filter.setParameter("param1", "blocked");
            filter.setParameter("param2", "closed");

            // HQL Query
            Query<BankAccount> query =
                    session.createQuery(
                            "from BankAccount where balance >= :amt",
                            BankAccount.class
                    );

            query.setParameter("amt", 15000f);

            List<BankAccount> accounts = query.getResultList();
            accounts.forEach(System.out::println);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}
