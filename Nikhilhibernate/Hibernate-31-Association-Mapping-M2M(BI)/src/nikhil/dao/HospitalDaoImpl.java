package nikhil.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import nikhil.bean.Doctor;
import nikhil.bean.Patient;
import nikhli.util.HibernateUtil;

public class HospitalDaoImpl implements IHospitalDao {

	@Override
	public void saveRecordUsingDoctor() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			
			//created parent object
			Doctor doctor = new Doctor();
			doctor.setDoctName("kartik");
			doctor.setHospital("kartik madicos");
			
			Doctor doctor1 = new Doctor();
			doctor1.setDoctName("pankaj");
			doctor1.setHospital("kartik madicos");
			
			
			//created child object
			Patient p1 = new Patient();
			p1.setPatName("sheer");
			p1.setProblem("heart");
			
			Patient p2 = new Patient();
			p2.setPatName("pal");
			p2.setProblem("kidney");
			
			Patient p3 = new Patient();
			p3.setPatName("pal");
			p3.setProblem("kidney");
			
			//linking child to parent
			doctor.setPatients(Set.of(p1, p2));
			doctor1.setPatients(Set.of(p2, p3));
			
			//linking parent to child
			
			p1.setDoctor(Set.of(doctor));
			p2.setDoctor(Set.of(doctor,doctor1));
			p3.setDoctor(Set.of(doctor1));
			
			session.save(doctor);
			session.save(doctor1);
			
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
					Query<Doctor> query = session.createQuery("from Doctor");
					List<Doctor> records = query.getResultList();
					records.forEach(row->{
						System.out.println(row);
						Set<Patient> patients = row.getPatients();
						patients.forEach(System.out::println);
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
			
			//created parent object
			Doctor doctor = new Doctor();
			doctor.setDoctName("kartik");
			doctor.setHospital("kartik madicos");
			
			Doctor doctor1 = new Doctor();
			doctor1.setDoctName("pankaj");
			doctor1.setHospital("kartik madicos");
			
			
			//created child object
			Patient p1 = new Patient();
			p1.setPatName("sheer");
			p1.setProblem("heart");
			
			Patient p2 = new Patient();
			p2.setPatName("pal");
			p2.setProblem("kidney");
			
			Patient p3 = new Patient();
			p3.setPatName("pal");
			p3.setProblem("kidney");
			
			//linking child to parent
			doctor.setPatients(Set.of(p1, p2));
			doctor1.setPatients(Set.of(p2, p3));
			
			//linking parent to child
			
			p1.setDoctor(Set.of(doctor));
			p2.setDoctor(Set.of(doctor,doctor1));
			p3.setDoctor(Set.of(doctor1));
			
			session.save(p1);
			session.save(p2);
			session.save(p3);
			
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
