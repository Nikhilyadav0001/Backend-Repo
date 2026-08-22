package nikhil.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.Person;
import nikhil.bean.PhoneNumber;
import nikhli.util.HibernateUtil;

public class PersonDaoImpl implements IPersonDao {
	
	@Override
	public void saveRecordUsingParent() {
		Session session = null;
		Transaction transaction =null;
		boolean flag =false;
		
	
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Creating a parent object
			Person person = new Person();
			person.setPname("Sheer");
			person.setPaddress("sherpal");

			// Creating a child objects
			PhoneNumber number1 = new PhoneNumber();
			number1.setMobileNo(7787787848l);
			number1.setProvider("jio");
			number1.setType("personal");

			PhoneNumber number2 = new PhoneNumber();
			number2.setMobileNo(796454225l);
			number2.setProvider("airtel");
			number2.setType("office");

			PhoneNumber number3 = new PhoneNumber();
			number3.setMobileNo(599787888L);
			number3.setProvider("jio");
			number3.setType("personal");

			// linking child objects to parent object
			person.setNumbers(Set.of(number1, number2, number3));

			// saving parent object
			session.save(person);
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("record saved to db using parent");
			} else {
				transaction.rollback();
				System.out.println("record not saved to db some problem");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingParent() {
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			Query<Person> query = session.createQuery("from Person");
			List<Person> parents = query.getResultList();
			parents.forEach(parent -> {
				System.out.println(parent);
				Set<PhoneNumber> childs = parent.getNumbers();
				childs.forEach(child -> System.out.println(child));
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
	public void addChildToExistingParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// got the parent
			Person parent = session.get(Person.class,2);

			// get the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();
			PhoneNumber child = new PhoneNumber();
			child.setMobileNo(6548777888L);
			child.setProvider("vi");
			child.setType("office");

			// add extra child
			childs.add(child);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("New Child added to Existing Parent...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}

		}
     
	}

	@Override
	public void deleteAllChildsOfAParent() {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 2);

			// Getting all the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();

			// removing all the childs
			childs.removeAll(childs);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("All child records are deleted w.r.t parent::");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting the records of the parent..");
				}
			}

		}
	}

	@Override
	public void deleteOneChildFromCollectionofChildsOfAParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 3);

			// Getting all the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();

			PhoneNumber child = session.get(PhoneNumber.class, 5);

			// removing one child
			childs.remove(child);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("One child records is deleted w.r.t parent");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting a Child record of the parent..");
				}
			}

		}
	}

	@Override
	public void deleteParentAndItsChilds() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 3);
			session.delete(parent);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Parent and its child records are deleted ");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting the records of the parent..");
				}
			}

		}

	}
}


