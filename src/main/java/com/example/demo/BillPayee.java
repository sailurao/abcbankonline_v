package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table
@Entity(name="bill_payee")

public class BillPayee {


    @Id
    private int payeeId;


    private int accountId;

    @NotBlank
    private String  payeeAccountNo;

    @NotBlank
    private String payeePhone;

    @NotBlank
    private String payeeAddress;


    public BillPayee() {
        super();
    }
    public BillPayee(int payeeId,int accountId,String payeeAccountNo,String payeePhone,String payeeAddress) {
        super();
        this.payeeId=payeeId;
        this.accountId=accountId;
        this.payeeAccountNo=payeeAccountNo;
        this.payeePhone=payeePhone;
        this.payeeAddress=payeeAddress;
    }
    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getPayeePhone() {
        return payeePhone;
    }

    public void setPayeePhone(String payeePhone) {
        this.payeePhone = payeePhone;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }

}
