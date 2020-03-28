package com.example.demo.controller;

import com.example.demo.Account;
import com.example.demo.AccountNotFoundException;
import com.example.demo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController

public class AccountController{

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account")
    public List<Account> getAccount(){
        return accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Optional<Account> getAccountById(@PathVariable(value = "id") Integer id)
    {
        return accountRepository.findById(id);
    }

    @PostMapping("/account")
    public @Valid Account createAccount(@Valid @RequestBody Account account){
        return accountRepository.save(account);
    }

    @PutMapping("/account/{id}")
    public @Valid Account updateAccount(@PathVariable(value="id") Integer id, @Valid @RequestBody Account account)
            throws AccountNotFoundException {
        Account acc = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        acc.setAccountType(account.getAccountType());
        acc.setAccountName(account.getAccountName());
        acc.setAccountAddress(account.getAccountAddress());
        acc.setAccountStatus(account.getAccountStatus());
        acc.setEmailId(account.getEmailId());
        acc.setMobileNumber(account.getMobileNumber());
        acc.setDateOpen(account.getDateOpen());
        acc.setDateClosed(account.getDateClosed());
        acc.setAccount_balance(account.getAccount_balance());
        Account updAccount = accountRepository.save(acc);
        return updAccount;
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable ("id") Integer id) throws AccountNotFoundException {
        Account acc1=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException(id));
        accountRepository.delete(acc1);
        return ResponseEntity.ok().build();
    }

}
