package nikhil.main;

import nikhil.dao.IPassportDao;
import nikhil.dao.PassportDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		IPassportDao dao = new PassportDaoImpl();
		dao.loadRecordUsingParent();
	}
}	