package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOutputMapper {

    public void mapDomainListToModelList(List<User> userList, List<UserModel> userModelList) {
        userList.forEach(user -> {
            UserModel userModel = getUserModel(user);
            userModelList.add(userModel);
        });
    }

    public  UserModel mapDomainToModel(User user){
        return getUserModel(user);
    }

    private UserModel getUserModel(User user) {
        UserModel userModel=new UserModel();
        userModel.setUserId(user.getUserId());
        userModel.setAddress(user.getAddress());
        userModel.setEmailId(user.getEmailId());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setMiddleName(user.getMiddleName());
        userModel.setMobileNumber(user.getMobileNumber());
        userModel.setPassword(user.getPassword());
        userModel.setAddress(user.getAddress());
        return userModel;
    }
}
