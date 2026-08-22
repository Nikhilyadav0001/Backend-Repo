package nikhil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import nikhil.entity.InsurancePolicy;
import nikhil.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public long getTotalrecordsCount() {
		Session session =HibernateUtil.getSession();
		Query query =session.getNamedQuery("GET_POLICIES_COUNT");
		
		List <Long>list=query.getResultList();
		
		return list.get(0);
	}

	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		Session session = HibernateUtil.getSession();
		Query query =session.getNamedQuery("GET_ALL_POLICIES");
		
		//performing pageination
		query.setFirstResult(startPos);//0
		query.setMaxResults(pageSize);//3
		
		List <InsurancePolicy>list=query.getResultList();
		
		return list;
	}

}
