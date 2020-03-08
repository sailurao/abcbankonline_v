package com.example.demo;

public class AccountNotFoundException extends Exception {
    private int accountId;
    public AccountNotFoundException(int accountId){
        super(String.format("Account is not found with id : '%s'", accountId));
    }
}
