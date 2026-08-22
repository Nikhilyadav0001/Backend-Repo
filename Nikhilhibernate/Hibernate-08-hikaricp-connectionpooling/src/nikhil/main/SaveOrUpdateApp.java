package nikhil.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Naukari;


import nikhli.util.HibernateUtil;
public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;
		byte[] image =null;
		char [] resume = null;
		FileInputStream fis =null;
		BufferedReader br =null;
		
		try {
			//reading an image
			fis =new FileInputStream("C:\\Users\\nikhi\\OneDrive\\Pictures\\Camera Roll\\WIN_20260126_13_01_51_Pro.jpg");
			//int size = fis.available();
			image = new byte[fis.available()];
			fis.read(image);
			
			//reading a reasume 
			File file = new File("D:\\java files\\text file\\resumme.txt");
			br =new BufferedReader(new FileReader (file));
			resume = new char[(int)file.length()];
			
			br.read(resume);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		//logic for hgibernate working
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Naukari naukari = new Naukari();
			naukari.setAddress("gurugram");
			naukari.setName("Kunal");
			naukari.setImage(image);
			naukari.setResume(resume);
			
			session.saveOrUpdate(naukari);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				HibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
