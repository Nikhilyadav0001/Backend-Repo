package nikhil.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.beans.Naukri;
import nikhil.dao.INaukriDao;


@Component
public class NaukriRunner implements CommandLineRunner {

	@Autowired
	private INaukriDao dao;

	@Override
	public void run(String... args) throws Exception {

		 /* Naukri naukri = new Naukri(); 
	      naukri.setAddress("hayatpur");
	      naukri.setName("Nikhil");
	  
	      File image = new File("D:\\java files\\images\\imagehiber.png"); naukri.setImage(image);
	 
	      File resume = new File("D:\\java files\\text file\\resumme.txt"); naukri.setResume(resume);
	  
	      dao.saveObject(naukri);
		 */

	      Naukri naukri1 = dao.readObject();
	      System.out.println("Name     is :: " + naukri1.getName());
	      System.out.println("Address  is :: " + naukri1.getAddress());
	      System.out.println("Image    is :: " + naukri1.getImage().getAbsolutePath());
	      System.out.println("Resume   is :: " + naukri1.getResume().getAbsolutePath());

	}
}