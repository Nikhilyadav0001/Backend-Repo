package nikhil.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.bean.Person;
import nikhil.bean.PhoneNumber;
import nikhli.util.HibernateUtil;

public class PersonDaoImpl implements IPersonDao {

	

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordsUsingHQLJoins() {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			
			String HQL_INNER_JOIN = "select per.pid,per.pname,per.paddress,ph.regNo,ph.mobileNo,ph.type from Person per inner join per.numbers ph";
			Query<Object[]> query = session.createQuery(HQL_INNER_JOIN);
			List<Object[]> parents = query.getResultList();
			parents.forEach(record -> {
				for (Object row : record) {
					System.out.print(row+"  ");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

	@Override
	public void loadRecordsUsingQBCFetchTypeJoin() {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			CriteriaBuilder builder =session.getCriteriaBuilder();
			
			//configuring the parent record
			CriteriaQuery<Person> qr = builder.createQuery(Person.class);
			Root<Person> root = qr.from(Person.class);
			
			//getting the child object  using join
			root.fetch("numbers",JoinType.INNER);

			Query<Person> query = session.createQuery(qr);
			List<Person> parents = query.getResultList();
			parents.forEach(record -> {
				System.out.println(record);
//				Set<PhoneNumber> ph = record.getNumbers();
//				ph.forEach(System.out::println);
				System.out.println();
			});
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
