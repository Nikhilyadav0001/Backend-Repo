package nikhil.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.LibraryMembership;
import nikhil.bean.Student;
import nikhli.util.HibernateUtil;

public class LibraryDaoImpl implements ILibraryDao {

	@Override
	public void saveRecordUsingParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Create parent object(Student)
			Student student = new Student();
			student.setSname("sheer");
			student.setSaddress("sherrnager");
			
			// Create a child object(LibraryMembership)
			LibraryMembership library = new LibraryMembership();
			library.setType("gold");
			library.setDate(LocalDate.of(2026, 02, 19));
			
			// link parent to child
			student.setLibrary(library);
			
			// link child to parent
			library.setStudent(student);

			// save parent object
			session.save(student);

			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using doctors...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database Some Problem...");
				}
			}

		}

	}

	@Override
	public void loadRecordUsingParent() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				Session session = null;

				try {
					session = HibernateUtil.getSession();
					
					Query<Student> query = session.createQuery("from Student");
					List<Student> records = query.getResultList();
					System.out.println();
					records.forEach(row -> {
						System.out.println(row);
						LibraryMembership libraryMembership = row.getLibrary();
						System.out.println(libraryMembership);
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
	public void saveRecordUsingChild() {

		Session session = null;
		Transaction transaction = null;
		
		
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			// Create parent object(Student)
			Student student = new Student();
			student.setSname("chita");
			student.setSaddress("chitanager");
						
			// Create a child object(LibraryMembership)
			LibraryMembership library = new LibraryMembership();
			library.setType("solver");		
			library.setDate(LocalDate.of(2026, 02, 19));
						
			// link parent to child
			student.setLibrary(library);
						
			// link child to parent			
			library.setStudent(student);

			// save parent object
			session.save(library);

			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Saving record using child...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}

		}

	}
}
