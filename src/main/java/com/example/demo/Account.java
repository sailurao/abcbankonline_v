package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;


@Table
@Entity(name="account")
public class Account {

    @Id
    private int accountId;

    @NotBlank
    private String accountType;

    @NotBlank
    private String accountName;

    @NotBlank
    private String accountAddress;

    @NotBlank
    private String accountStatus;

    @NotBlank
    @Email
    private String emailId;

    @NotBlank
    private String mobileNumber;


    private float accountBalance;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOpen;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    private LocalDateTime dateClosed;

    public Account() {
        super();
    }

    public Account(int accountId,String accountType,String accountName, String accountAddress,String accountStatus,String emailId,String mobileNumber,LocalDateTime dateOpen,LocalDateTime dateClosed,float accountBalance) {
        super();
        this.accountId=accountId;
        this.accountType=accountType;
        this.accountName=accountName;
        this.accountAddress=accountAddress;
        this.accountStatus=accountStatus;
        this.emailId=emailId;
        this.mobileNumber=mobileNumber;
        this.dateOpen=dateOpen;
        this.dateClosed=dateClosed;
        this.accountBalance=accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(LocalDateTime dateOpen) {
        this.dateOpen = dateOpen;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }
    public float getAccount_balance() {
        return accountBalance;
    }

    public void setAccount_balance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

}
