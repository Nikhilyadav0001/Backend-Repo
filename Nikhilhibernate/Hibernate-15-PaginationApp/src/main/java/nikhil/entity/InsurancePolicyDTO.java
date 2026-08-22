package nikhil.entity;

import java.io.Serializable;

public class InsurancePolicyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int serialno;
	private Long policyId;
	
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	static {
		System.out.println("Hibernate-> Loading InsurancePolicy.class file...");
	}
	 
	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public InsurancePolicyDTO() {
		System.out.println("Hibernate-> InsurancePolicy Object created using Zero param constructor...");
	}
	
	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicyDTO [serialno=" + serialno + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", policyType=" + policyType + ", company=" + company + ", tenure=" + tenure + "]";
	}

	

}
