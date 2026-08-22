package nikhil.main;

import nikhil.dto.TransferDao;
import nikhil.dto.TransferDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		TransferDao dao= null;
		dao = new TransferDaoImpl();
		System.out.println("status "+dao.transferProductById(2));
		

	}

}
