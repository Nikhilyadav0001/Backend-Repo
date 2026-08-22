package nikhil.dto;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nikhil.bean.Product;
import nikhli.util.MySQLHibernateUtil;
import nikhli.util.OracleHibernateUtil;

public class TransferDaoImpl implements TransferDao {

	@Override
	public String transferProductById(Integer id) {

	    Session oracleSession = null;
	    Session mysqlSession = null;
	    Transaction mysqlTrans = null;

	    try {
	        oracleSession = OracleHibernateUtil.getSession();
	        //geting the record from oracle based on id
	        Product product = oracleSession.get(Product.class, id);

	        if (product == null) {
	            return "no record available";
	        }

	        mysqlSession = MySQLHibernateUtil.getSession();
	        mysqlTrans = mysqlSession.beginTransaction();

//	        Product newProduct = new Product();
//	        newProduct.setPname(product.getPname());
//	        newProduct.setPrice(product.getPrice());
//	        newProduct.setQty(product.getQty());

	        mysqlSession.save(product);
	        mysqlTrans.commit();

	        return "record copied from oracle to mysql";

	    } catch (Exception e) {
	        if (mysqlTrans != null) {
	            mysqlTrans.rollback();
	        }
	        e.printStackTrace();
	        return "record not copied from oracle to mysql";

	    } finally {
	        if (oracleSession != null) oracleSession.close();
	        if (mysqlSession != null) mysqlSession.close();
	    }
	}


//	package nikhil.dto;
//
//	import org.hibernate.Session;
//	import org.hibernate.Transaction;
//
//	import nikhil.bean.Product;
//	import nikhli.util.MySQLHibernateUtil;
//	import nikhli.util.OracleHibernateUtil;
//
//	public class TransferDaoImpl implements TransferDao {
//
//		@Override
//		public String transferProductById(Integer id) {
//			
//			Session oracleSession =null, mysqlSession = null;
//			//one transaction object is needed as we are taking data from oracle (mysql different db) so no need of transaction object 
//			Transaction mysqlTrans = null;
//			String status = "";
//			boolean flag =false;
//			
//			
//			
//			oracleSession = OracleHibernateUtil.getSession();
//			
//			//geting the record from oracle based on id
//			Product product =oracleSession.get(Product.class, id);
//			
//			if (product != null) {
//				//sending to my sql
//				try {
//					mysqlSession = MySQLHibernateUtil.getSession();
//					mysqlTrans = mysqlSession.beginTransaction();
//					
//					mysqlSession.save(product);
//					flag = true;
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					if (mysqlTrans != null) {
//						
//						if (flag) {
//							mysqlTrans.commit();
//							return "record coppied from oracle to sql";
//						} else {
//							mysqlTrans.rollback();
//							return "record not  coppied from oracle to sql";
//						}
//					}else {
//						return"problen in transaction";
//					}
//				}
//				
//			} else {
//				status ="no record are avalable";
//				return status;
//				
//			}
//			
//			
//		}
//
//	}

	
}
