package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Table
@Entity(name="account_transaction")
public class AccountTransaction {

    @Id
    private int accountId;

    @NotBlank
    private String transactionNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionDate;

    private float transactionAmount;

    @NotBlank
    private String transactionType;

    private int loanId;

    private int payeeId;



    private float balance;

    public AccountTransaction() {
        super();
    }

    public AccountTransaction(int accountId,String transactionNo,LocalDateTime transactionDate,float transactionAmount,String transactionType,int loanId,int payeeId, float balance) {
        super();
        this.accountId=accountId;
        this.transactionNo=transactionNo;
        this.transactionDate=transactionDate;
        this.transactionAmount=transactionAmount;
        this.transactionType=transactionType;
        this.loanId=loanId;
        this.payeeId=payeeId;
        this.balance=balance;
    }
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
