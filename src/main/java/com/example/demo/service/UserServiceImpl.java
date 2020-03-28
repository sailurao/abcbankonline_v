package com.example.demo.service;

import com.example.demo.UserAccountNotFoundException;
import com.example.demo.UserNotFoundException;
import com.example.demo.UserRepository;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserInputMapper;
import com.example.demo.mapper.UserOutputMapper;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInputMapper userInputMapper;

    @Autowired
    UserOutputMapper userOutputMapper;

    @Override
    public UserModel updateUser(UserModel userModel, String requestType) throws UserNotFoundException {
        User user = new User();
        userInputMapper.mapToDomain(userModel, user);
        if (requestType.equals("updateUser")) {
            userRepository.findById(userModel.getUserId()).orElseThrow(() -> new UserNotFoundException(userModel.getUserId()));
        }
        userRepository.save(user);
        return userModel;
    }

    @Override
    public List<UserModel> getUser() {
        List<User> userList = userRepository.findAll();

        List<UserModel> userModelList = new ArrayList<>();
        userOutputMapper.mapDomainListToModelList(userList, userModelList);

        return userModelList;
    }

    @Override
    public Optional<UserModel> getUserById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        UserModel userModel = userOutputMapper.mapDomainToModel(user.get());
        return Optional.of(userModel);
    }

    @Override
    public void deleteUserById(Integer userId) throws  UserNotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.deleteById(userId);

    }


}
