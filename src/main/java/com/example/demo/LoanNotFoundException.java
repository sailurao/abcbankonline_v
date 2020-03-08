package com.example.demo;

public class LoanNotFoundException extends Exception {
    private int loanId;
    public LoanNotFoundException(int loanId){
        super(String.format("Account is not found with id : '%s'", loanId));
    }
}
