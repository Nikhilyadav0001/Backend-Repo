package nikhil.runner;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IMarrigeRepository;
import nikhil.entity.MarriageSeeker;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IMarrigeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name of the user :: ");
		String name = scanner.nextLine();

		System.out.print("Enter the address of the user :: ");
		String address = scanner.nextLine();

		System.out.print("Is Person Indian? :: ");
		boolean indian = Boolean.parseBoolean(scanner.nextLine());

		System.out.print("Enter the path of Person photo :: ");
		String photoLoc = scanner.nextLine();

		System.out.print("Enter the path of Person biodata :: ");
		String bioDataLoc = scanner.nextLine();
		  
		  // working with binary image data 
		  InputStream is = new FileInputStream(new File(photoLoc));
		  byte[] img = new byte[is.available()];
		  img = is.readAllBytes();
		  
		  // working with text file data
		  Reader reader = new FileReader(new File(bioDataLoc));
		  char[] bio = new char[(int) new File(bioDataLoc).length()];
		  reader.read(bio);
		
		  
		  MarriageSeeker obj = new MarriageSeeker(name, address,
				  LocalDateTime.of(2006, 04, 17, 19, 45),
				  img, bio, indian);
		  		repo.save(obj);
		  System.out.println("Object saved to database....");
		  
		  scanner.close();
		  reader.close();
		  is.close();
		 
		*/
		
		// code for retrieval
		Optional<MarriageSeeker> optional = repo.findById(1);
		if (optional.isPresent()) {
			MarriageSeeker obj = optional.get();
			System.out.println(obj);

			System.out.println("Image data stored in ...");
			OutputStream os = new FileOutputStream(new File("retrieved_img.jpg"));
			os.write(obj.getPhoto());
			os.flush();

			System.out.println("BioData stored in ...");
			Writer writer = new FileWriter(new File("retrieved_bio.txt"));
			writer.write(obj.getBiodata());
			writer.flush();
			System.out.println("Lob's are retrieved...");

		} else {
			System.out.println("Record not available...");
		}

		
	}
}
