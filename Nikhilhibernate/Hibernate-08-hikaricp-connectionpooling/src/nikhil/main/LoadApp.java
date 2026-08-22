package nikhil.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import nikhil.bean.Naukari;
import nikhli.util.HibernateUtil;
public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		
		
		try {
			session = HibernateUtil.getSession();
			Naukari naukari = session.get(Naukari.class, id);
			
			if (naukari != null) {
				System.out.println("id is"+naukari.getId());
				System.out.println("Name is"+naukari.getName());
				System.out.println("addr is"+naukari.getAddress());
				
				String resumeLoc="D:\\java files\\text file\\reumehiber.txt";
				String imageLoc ="D:\\java files\\images\\imagehiber.png";
				
				try (FileWriter fw = new FileWriter(new File(resumeLoc));
						FileOutputStream fos = new FileOutputStream(new File(imageLoc))){
					
					
					fw.write(naukari.getResume());
					fw.flush();
					System.out.println("resume details");
					System.out.println("resume details is in:"+resumeLoc);
					
					System.out.println();
					
					fos.write(naukari.getImage());
					fos.flush();
					System.out.println("image details");
					System.out.println("image details in ::"+ imageLoc);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("record not found for nid::"+id);
			}
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
				
			}
		}
	}
}
