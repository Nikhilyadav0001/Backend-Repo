package nikhil.bean;

import javax.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "BANK_ACC")
@FilterDef(
    name = "FILTER_BANK_ACCOUNT_STATUS",
    parameters = {
        @ParamDef(name = "param1", type = "string"),
        @ParamDef(name = "param2", type = "string")
    }
)
@Filter(
    name = "FILTER_BANK_ACCOUNT_STATUS",
    condition = "status not in (:param1, :param2)"
)
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accNo;

    private String holderName;
    private Float balance;
    private String status;

    public BankAccount() {
        System.out.println("Object created");
    }

    // Getters and Setters

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
        return "BankAccount [accNo=" + accNo +
                ", holderName=" + holderName +
                ", balance=" + balance +
                ", status=" + status + "]";
    }
}
