package nikhil.beans;

public class CustomerBo {

	private String custName;
	private String custAddr;
	private Float pamt;
	private Float rate;
	private Float time;
	
	//extra field needed to be stored in the db
	private Float interestAmount;

	@Override
	public String toString() {
		return "CustomerBo [custName=" + custName + ", custAddr=" + custAddr + ", pamt=" + pamt + ", rate=" + rate
				+ ", time=" + time + ", interestAmount=" + interestAmount + "]";
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public Float getPamt() {
		return pamt;
	}

	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Float getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(Float interestAmount) {
		this.interestAmount = interestAmount;
	}
	
	
}
