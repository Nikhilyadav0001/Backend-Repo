package nikhil.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Student;
import nikhli.util.HibernateUtil;

public class SaveOrUpdateApp {

	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction = null;
		Student std = null;
		Integer id = null;
		BufferedReader br =null;
		boolean flag =false;
		String name =null, address =null, age =null;
		
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			session =HibernateUtil.getSession(); 
			if (session != null && br != null) {
				
				System.out.println("enter the id :");
				id =Integer.parseInt(br.readLine());
				std =session.get(Student.class, id);
				
			}
			if (std != null) {
				transaction = session.beginTransaction();
				
				if (transaction != null) {
					
					System.out.println("records of id:"+id);
					System.out.println("old name is ::"+std.getSname()+"   ENTER NEW NAME");
					name =br.readLine();
					
					if (name.equals("") || name == null) {
						std.setSname(std.getSname());
					} else {
						std.setSname(name);
					}
					
					
					System.out.println("old address is ::"+std.getSaddress()+"   ENTER NEW address");
					address =br.readLine();
					
					if (address.equals("") || address == null) {
						std.setSaddress(std.getSaddress());
					} else {
						std.setSaddress(address);
					}
					
					
					System.out.println("old age is ::"+std.getSage()+"   ENTER NEW age");
					age =br.readLine();
					
					if (age.equals("") || age == null) {
						std.setSage(std.getSage());
					} else {
						std.setSage(Integer.parseInt(age));
					}
					
					// record sent for UPDATION with new values along with id present in table
					session.saveOrUpdate(std);
					
					flag= true;
					
				}
				
			} else {
				System.out.println("no record for the given id:"+id);
				// record not available in database
				std = new Student();
				
				std.setSid(id);

                System.out.print("Enter name: ");
                std.setSname(br.readLine());
                System.out.print("Enter address: ");
                std.setSaddress(br.readLine());
                System.out.print("Enter age: ");
                std.setSage(Integer.parseInt(br.readLine()));
                session.save(std);
                System.out.println("Record inserted successfully.");

                transaction = session.beginTransaction();
				//record w.r.t id not found in table, so it performed insert operation
				session.saveOrUpdate(std);
				flag = true;
			}
			
		}catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("record updatedd...");
				
			} else {
				System.out.println("record update fail");
			}
			HibernateUtil.closeSessionFactory();
			
			if (session != null) {
				session.close();
			}
		}

	}

}
