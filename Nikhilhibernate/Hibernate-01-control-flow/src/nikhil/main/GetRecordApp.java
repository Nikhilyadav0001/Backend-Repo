package nikhil.main;



import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.Student;
import nikhli.util.HibernateUtil;


public class GetRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Scanner scanner =null;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;
		Integer sid =null;
		
		
		try {
			session = HibernateUtil.getSession();
			System.out.println("enter the sid ::");
			scanner = new Scanner(System.in);
			if (session !=null && scanner != null) {
				
				sid = scanner.nextInt();
				scanner.nextLine(); // clear newline

				std1 = session.get(Student.class, sid);
				System.out.println(std1 + " its hash code is " + std1.hashCode());

				System.out.println("Press Enter to continue...");
				scanner.nextLine(); // PAUSE 1
				
				//remove everything from the l1 cache
				//session.clear(); 
				//remove std3(only this object) from l1 cache
				//session.evict(std1); 
				

				std2 = session.get(Student.class, sid);
				System.out.println(std2 + " its hash code is " + std2.hashCode());

				System.out.println("Press Enter to continue...");
				scanner.nextLine(); // PAUSE 2

				std3 = session.get(Student.class, 3);
				System.out.println(std3 + " its hash code is " + std3.hashCode());

			
			
			}
		
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			
			if (session != null) {
				session.close();
			}
			
		}
		
	}

}
