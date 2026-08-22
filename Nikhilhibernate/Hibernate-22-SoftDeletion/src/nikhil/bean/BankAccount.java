package nikhil.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "BANK_ACC")
@FilterDef(name = "FILTER_BANK_ACCOUNT_STATUS",
			parameters = {
					@ParamDef(type = "string" ,name = "param1"),
					@ParamDef(type = "string" ,name = "param2")
				} )
@Filter(name = "FILTER_BANK_ACCOUNT_STATUS",condition = "status not in (:param1,:param2)")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accNo;
	
	private String holderName;
	private Float balance;
	private String status;
	
	static {
		System.out.println("bankAccount.class file loading..");
	}
	public BankAccount() {
		System.out.println("object created");
	}
	
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
	
	
}
