package com.example.demo.controller;


import com.example.demo.UserAccount;
import com.example.demo.UserAccountNotFoundException;
import com.example.demo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class UserAccountController{

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/userAccount")
    public List<UserAccount> getUserAccount(){
        return userAccountRepository.findAll();
    }

    @GetMapping("/userAccount/{id}")
    public Optional<UserAccount> getUserAccountById(@PathVariable(value = "id") Integer id)
    {
        return userAccountRepository.findById(id);
    }

    @PostMapping("/userAccount")
    public @Valid UserAccount createUserAccount(@Valid @RequestBody UserAccount userAccount){
        return userAccountRepository.save(userAccount);

    }

    @PutMapping("/userAccount/{id}")
    public UserAccount updateUserAccount(@PathVariable(value="id") Integer id, @Valid @RequestBody UserAccount userAccount)
            throws UserAccountNotFoundException {
        UserAccount usrAcc = userAccountRepository.findById(id).orElseThrow(() ->new UserAccountNotFoundException(id));
        usrAcc.setAccountId(userAccount.getAccountId());
        UserAccount updUser = userAccountRepository.save(usrAcc);
        return updUser;
    }

    @DeleteMapping("/userAccount/{id}")
    public ResponseEntity<?> deleteUserAccount(@PathVariable ("id") Integer id) throws UserAccountNotFoundException {
        UserAccount usrAcc1=userAccountRepository.findById(id).orElseThrow(()->new UserAccountNotFoundException(id));
        userAccountRepository.delete(usrAcc1);
        return ResponseEntity.ok().build();
    }

}
