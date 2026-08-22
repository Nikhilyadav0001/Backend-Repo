package nikhil.main;



import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.Student;
import nikhli.util.HibernateUtil;


public class LoadRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Scanner scanner =null;
		Student std1 = null;
		Integer sid =null;
		
		
		try {
			session = HibernateUtil.getSession();
			System.out.println("enter the sid ::");
			scanner = new Scanner(System.in);
			if (session !=null && scanner != null) {
				
				sid = scanner.nextInt();
				scanner.nextLine(); // clear newline

				std1 = session.load(Student.class, sid);//select query::bd to l1 cache
				System.out.println(std1);
				
				if (std1 != null) {
					System.out.println("name is :"+ std1.getSname());
					System.out.println("age is :"+ std1.getSage());
					System.out.println("address is :"+ std1.getSaddress());
				}
			}
		} catch (HibernateException he) {
			System.out.println("no records found for sid:"+sid);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			
			if (session != null) {
				session.close();
			}
			
		}
		
	}

}
