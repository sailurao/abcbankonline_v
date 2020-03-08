package com.example.demo;

public class BillPayeeNotFoundException extends Exception{
    private int payeeId;
    public BillPayeeNotFoundException(int payeeId){
        super(String.format("Bill Payee is not found with id : '%s'", payeeId));
    }
}
