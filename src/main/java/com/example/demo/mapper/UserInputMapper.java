package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {
    public void mapToDomain(UserModel userModel, User user) {
        user.setUserId(userModel.getUserId());
        user.setFirstName(userModel.getFirstName());
        user.setMiddleName(userModel.getMiddleName());
        user.setLastName(userModel.getLastName());
        user.setAddress(userModel.getAddress());
        user.setPassword(userModel.getPassword());
        user.setEmailId(userModel.getEmailId());
        user.setMobileNumber(userModel.getMobileNumber());
    }
}
