package com.example.demo.service;

import com.example.demo.UserAccountNotFoundException;
import com.example.demo.UserNotFoundException;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserModel updateUser(UserModel userModel, String requestType) throws UserNotFoundException;
    public List<UserModel> getUser();
    public Optional<UserModel> getUserById(Integer userId);
    public void deleteUserById(Integer userId) throws  UserNotFoundException;
}
