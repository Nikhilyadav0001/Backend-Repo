package nikhil.main;

import nikhil.dao.IPersonDao;
import nikhil.dao.PersonDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		IPersonDao dao = new PersonDaoImpl();
		dao.loadRecordUsingChild();
	}
}