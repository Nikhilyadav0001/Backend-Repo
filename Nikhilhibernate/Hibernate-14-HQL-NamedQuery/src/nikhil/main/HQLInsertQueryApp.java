package nikhil.main;

import nikhil.dao.InsurancePolicyDao;
import nikhil.dao.InsurancePolicyDaoImpl;

public class HQLInsertQueryApp {

	public static void main(String[] args) {

		InsurancePolicyDao dao = new InsurancePolicyDaoImpl();
		System.out.println(dao.transferPolicies(12));
	}
}
