package com.example.demo;

public class UserAccountNotFoundException extends Exception {
    private int userId;
    public UserAccountNotFoundException(int userId){
        super(String.format("UserAccount is not found with id : '%s'", userId));
    }
}
