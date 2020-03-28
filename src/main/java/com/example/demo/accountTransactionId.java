package com.example.demo;

import java.io.Serializable;

public class accountTransactionId implements Serializable {
    private int accountId;
    private int transactionNo;

    public accountTransactionId(int accountId, int transactionNo) {
        this.accountId = accountId;
        this.transactionNo = transactionNo;
    }
}
