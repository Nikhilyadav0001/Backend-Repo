package nikhil.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.InsurancePolicy;
import nikhli.util.HibernateUtil;

public class InsertRecordApp {
	public static void main(String[] args) {
		Session session =HibernateUtil.getSession();
		
		Transaction tr = session.beginTransaction();
		InsurancePolicy ir = new InsurancePolicy();
		ir.setCompany("sher");
		ir.setPolicyName("no insurance");
		ir.setPolicyType("lifelong");
		ir.setTenure(60);
		session.save(ir);
		tr.commit();
	}
}
