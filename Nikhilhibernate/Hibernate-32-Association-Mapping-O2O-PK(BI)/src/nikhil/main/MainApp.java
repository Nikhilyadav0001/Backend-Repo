package nikhil.main;

import nikhil.dao.ILibraryDao;
import nikhil.dao.LibraryDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		ILibraryDao dao = new LibraryDaoImpl();
		dao.loadRecordUsingParent();
	}
}	