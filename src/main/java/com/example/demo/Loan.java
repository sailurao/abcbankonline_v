package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Table
@Entity(name="loan")
public class Loan {

    @Id
    private int loanId;
    @NotBlank
    private String loanType;

    private float loanAmount;

    private int userId;

    private int accountId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loanOpenDate;
    @NotBlank
    private String loanStatus;

    private int loanTerm;

    public Loan() {
        super();
    }

    public Loan(int loanId,String loanType,Float loanAmount,int userId,int accountId,LocalDateTime loanOpenDate,String loanStatus,int loanTerm) {
        super();
        this.loanId=loanId;
        this.loanType=loanType;
        this.loanAmount=loanAmount;
        this.userId=userId;
        this.accountId=accountId;
        this.loanOpenDate=loanOpenDate;
        this.loanStatus=loanStatus;
        this.loanTerm=loanTerm;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getLoanOpenDate() {
        return loanOpenDate;
    }

    public void setLoanOpenDate(LocalDateTime loanOpenDate) {
        this.loanOpenDate = loanOpenDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

}
