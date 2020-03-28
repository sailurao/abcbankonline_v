package com.example.demo.controller;


import com.example.demo.UserNotFoundException;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

   @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<UserModel> getUser(){
        logger.info("get user ====>");
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public Optional<UserModel> getUserById(@PathVariable(value = "id") Integer id) {
        logger.info("get user by id====>");
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public @Valid UserModel createUser(@Valid @RequestBody UserModel userModel){
        logger.info("create userModel ====>");
        UserModel responseUser = null;
        try {
            responseUser= userService.updateUser(userModel, "createUser");
        }catch (Exception ex){

        }
        return  responseUser;
    }

    @PutMapping("/user/{id}")
    public @Valid UserModel updateUser(@PathVariable(value="id") Integer id, @Valid @RequestBody UserModel user)
            throws UserNotFoundException {
        logger.info("updateUser====>");
        user.setUserId(id);
        return userService.updateUser(user,"updateUser");
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id") Integer id)   {
        logger.info("deleteUser====>");
        try {
            userService.deleteUserById(id);
        }catch (UserNotFoundException ex){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }

}
