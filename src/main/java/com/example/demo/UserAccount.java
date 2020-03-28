package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table
@Entity(name="user_account")
public class UserAccount {


    @Id
    private int userId;
    private int accountId;

    public UserAccount() {
        super();
    }

    public UserAccount(int userId,int accountId) {
        super();
        this.userId=userId;
        this.accountId=accountId;
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

}
