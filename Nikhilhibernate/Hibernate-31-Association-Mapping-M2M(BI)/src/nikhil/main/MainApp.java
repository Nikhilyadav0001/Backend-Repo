package nikhil.main;

import nikhil.dao.IHospitalDao;
import nikhil.dao.HospitalDaoImpl;

public class MainApp {

	public static void main(String[] args) {
		
		IHospitalDao dao = new HospitalDaoImpl();
		dao.loadRecordUsingParent();
	}
}	